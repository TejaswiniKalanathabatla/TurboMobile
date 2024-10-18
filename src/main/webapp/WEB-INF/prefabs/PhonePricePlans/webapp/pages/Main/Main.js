/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */
Prefab.onPropertyChange = function(key, newVal, oldVal) {
    switch (key) {
        case "prepopulatedplanid":
            // do something with newVal for property 'prop1'
            if (Prefab.Widgets.pricePlanListList2 && Prefab.prepopulatedplanid) {
                if (Prefab.Widgets.pricePlanListList2.getWidgets) {
                    let selectButtons = Prefab.Widgets.pricePlanListList2.getWidgets('buttonSelectPlan');
                    selectButtons.forEach(selectButton => {
                        selectButton.disabled = false;
                        if (selectButton.context.item.id == Prefab.prepopulatedplanid) {
                            selectButton.show = false;
                            selectButton.context.currentItemWidgets.buttonRemovePlan.show = true;
                            Prefab.Variables.stvPricePlan.dataSet = selectButton.context.item;
                        } else {
                            selectButton.show = true;
                            selectButton.disabled = true;
                            selectButton.context.currentItemWidgets.buttonRemovePlan.show = false;
                        }
                    });
                } else {
                    let dataset = Prefab.Widgets.pricePlanListList2.props.dataset;
                    let planIndex = dataset.findIndex(item => item.id == Prefab.prepopulatedplanid);
                    Prefab.Widgets.pricePlanListList2.itemWidgets.forEach((currItem, index) => {
                        currItem.buttonSelectPlan.disabled = false;

                        if (index == planIndex) {
                            currItem.buttonSelectPlan.show = false;
                            currItem.buttonRemovePlan.show = true;
                            Prefab.Variables.stvPricePlan.dataSet = dataset[planIndex];
                        } else {
                            currItem.buttonSelectPlan.show = true;
                            currItem.buttonSelectPlan.disabled = true;
                            currItem.buttonRemovePlan.show = false;
                        }
                    });
                }
            }

            if (Prefab.Widgets.pricePlanListList2 && !Prefab.prepopulatedplanid) {
                if (Prefab.Widgets.pricePlanListList2.getWidgets) {
                    let selectButtons = Prefab.Widgets.pricePlanListList2.getWidgets('buttonSelectPlan');
                    selectButtons.forEach(selectButton => {
                        selectButton.show = true;
                        selectButton.disabled = false;
                        selectButton.context.currentItemWidgets.buttonRemovePlan.show = false;
                    });
                } else {
                    Prefab.Widgets.pricePlanListList2.itemWidgets.forEach(currItem => {
                        currItem.buttonSelectPlan.show = true;
                        currItem.buttonSelectPlan.disabled = false;
                        currItem.buttonRemovePlan.show = false;
                    });
                }
            }

            if (!newVal) {
                Prefab.Variables.stvPricePlan.dataSet = undefined;
            }
            Prefab.onPlanchange(undefined, Prefab.Variables.stvPricePlan.dataSet);
            break;
    }
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    Prefab.Variables.stvPricePlan.dataSet = undefined;
};

Prefab.wsPricePlansListonBeforeDatasetReady = function(variable, data) {
    let content = data;
    content.forEach(item => {
        let pricePlanFeatures = item.phonePricePlanFeatureses ? item.phonePricePlanFeatureses : [];
        let sortedFeatures = pricePlanFeatures.sort((a, b) => {
            if (a.id !== b.id) {
                return a.id - b.id;
            } else {
                return a.pricePlanCategoryId - b.pricePlanCategoryId;
            }
        });

        let groupedResult = sortedFeatures.reduce((acc, curr) => {
            const category = curr.pricePlanCategory ? curr.pricePlanCategory.category : '';
            const planFeature = {
                value: curr.feature
            };

            const index = acc.findIndex(x => x.category === category);
            if (index === -1) {
                acc.push({
                    category,
                    icon: curr.pricePlanCategory.icon,
                    planFeatures: [planFeature]
                });
            } else {
                acc[index].planFeatures.push(planFeature);
            }

            return acc;
        }, []);
        item.phonePricePlanFeatureses = groupedResult;
    });
};

Prefab.buttonSelectPlanClick = function($event, widget, item, currentItemWidgets) {
    if (Prefab.Widgets.pricePlanListList2.getWidgets) {
        let selectButtons = Prefab.Widgets.pricePlanListList2.getWidgets('buttonSelectPlan');
        selectButtons.forEach(selectButton => {
            selectButton.disabled = true;
        });
    } else {
        Prefab.Widgets.pricePlanListList2.itemWidgets.forEach(currItem => {
            currItem.buttonSelectPlan.disabled = true;
        });
    }

    currentItemWidgets.buttonSelectPlan.show = false;
    currentItemWidgets.buttonRemovePlan.show = true;

    Prefab.Variables.stvPricePlan.dataSet = item;
    Prefab.onPlanchange(undefined, Prefab.Variables.stvPricePlan.dataSet);
};

Prefab.buttonRemovePlanClick = function($event, widget, item, currentItemWidgets) {
    if (Prefab.Widgets.pricePlanListList2.getWidgets) {
        let selectButtons = Prefab.Widgets.pricePlanListList2.getWidgets('buttonSelectPlan');
        selectButtons.forEach(selectButton => {
            selectButton.disabled = false;
        });
    } else {
        Prefab.Widgets.pricePlanListList2.itemWidgets.forEach(currItem => {
            currItem.buttonSelectPlan.disabled = false;
        });
    }

    currentItemWidgets.buttonSelectPlan.show = true;
    currentItemWidgets.buttonRemovePlan.show = false;

    Prefab.Variables.stvPricePlan.dataSet = undefined;
    Prefab.onPlanchange(undefined, Prefab.Variables.stvPricePlan.dataSet);
};

Prefab.pricePlanListList2Render = function(widget, $data) {
    if (!Prefab.Variables.stvPricePlan.dataSet && Prefab.prepopulatedplanid) {
        if (Prefab.Widgets.pricePlanListList2.getWidgets) {
            let selectButtons = Prefab.Widgets.pricePlanListList2.getWidgets('buttonSelectPlan');
            selectButtons.forEach(selectButton => {
                selectButton.disabled = false;
                if (selectButton.context.item.id == Prefab.prepopulatedplanid) {
                    selectButton.show = false;
                    selectButton.context.currentItemWidgets.buttonRemovePlan.show = true;
                    Prefab.Variables.stvPricePlan.dataSet = selectButton.context.item;
                } else {
                    selectButton.show = true;
                    selectButton.disabled = true;
                    selectButton.context.currentItemWidgets.buttonRemovePlan.show = false;
                }
            });
        } else {
            let dataset = Prefab.Widgets.pricePlanListList2.props.dataset;
            let planIndex = dataset.findIndex(item => item.id == Prefab.prepopulatedplanid);
            Prefab.Widgets.pricePlanListList2.itemWidgets.forEach((currItem, index) => {
                currItem.buttonSelectPlan.disabled = false;

                if (index == planIndex) {
                    currItem.buttonSelectPlan.show = false;
                    currItem.buttonRemovePlan.show = true;
                    Prefab.Variables.stvPricePlan.dataSet = datase[planIndex];
                } else {
                    currItem.buttonSelectPlan.show = true;
                    currItem.buttonSelectPlan.disabled = true;
                    currItem.buttonRemovePlan.show = false;
                }
            });
        }
    }
    Prefab.onPlanchange(undefined, Prefab.Variables.stvPricePlan.dataSet);
};
