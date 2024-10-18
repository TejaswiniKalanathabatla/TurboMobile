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
    /*
    switch (key) {
        case "prop1":
            // do something with newVal for property 'prop1'
            break;
        case "prop2":
            // do something with newVal for property 'prop2'
            break;
    }
    */
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};
Prefab.stvInternetActivitiesList1Click = function($event, widget) {
    let $data = widget.context.$implicit;
    let itemExists = Prefab.Variables.stvSelectedActivities.dataSet.find(item => item == $data);
    if (itemExists) {
        Prefab.Variables.stvSelectedActivities.dataSet = Prefab.Variables.stvSelectedActivities.dataSet.filter(item => item != $data);
    } else {
        $data.isActive = true;
        Prefab.Variables.stvSelectedActivities.dataSet.push($data);
    }
    Prefab.Widgets.stvInternetActivitiesList1.selecteditem = Prefab.Variables.stvSelectedActivities.dataSet;

    let checkboxes = Prefab.Widgets.stvInternetActivitiesList1.getWidgets('checkbox1');
    checkboxes.forEach(checkbox => {
        let itemValue = checkbox.context.item.dataValue;
        let itemCheckboxExists = Prefab.Variables.stvSelectedActivities.dataSet.find(item => item == itemValue);

        if (itemCheckboxExists) {
            checkbox.datavalue = true;
        } else {
            checkbox.datavalue = false;
        }
    });
};

Prefab.stvInternetNoOfDevicesList1Select = function(widget, $data) {
    let uncheckedIcons = Prefab.Widgets.stvInternetNoOfDevicesList1.getWidgets('icon1');
    uncheckedIcons.forEach(icons => icons.show = true);

    let checkedIcons = Prefab.Widgets.stvInternetNoOfDevicesList1.getWidgets('icon2');
    checkedIcons.forEach(icons => icons.show = false);

    widget._currentItemWidgets.icon1.show = false;
    widget._currentItemWidgets.icon2.show = true;

};

Prefab.list3Select = function(widget, $data) {
    let uncheckedIcons = Prefab.Widgets.list3.getWidgets('icon3');
    uncheckedIcons.forEach(icons => icons.show = true);

    let checkedIcons = Prefab.Widgets.list3.getWidgets('icon4');
    checkedIcons.forEach(icons => icons.show = false);

    widget._currentItemWidgets.icon3.show = false;
    widget._currentItemWidgets.icon4.show = true;
};

Prefab.wsPricePlansListonBeforeDatasetReady = function(variable, data) {
    let content = data;
    content.forEach(item => {
        let pricePlanFeatures = item.phonePricePlanFeatureses;
        let sortedFeatures = pricePlanFeatures.sort((a, b) => {
            if (a.id !== b.id) {
                return a.id - b.id;
            } else {
                return a.pricePlanCategoryId - b.pricePlanCategoryId;
            }
        });

        let groupedResult = sortedFeatures.reduce((acc, curr) => {
            const category = curr.pricePlanCategory.category;
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

    Prefab.Variables.stvRecommendedPlan.dataSet = data.find(item => item.id == 2);
};

Prefab.anchorShowAllPlansClick = function($event, widget) {
    Prefab.Widgets.containerQuiz.show = false;
    Prefab.Widgets.containerRecommendedPlan.show = false;
    Prefab.Widgets.containerAllPlans.show = true;
};

Prefab.buttonTakeQuizClick = function($event, widget) {
    Prefab.Widgets.containerQuiz.show = true;
    Prefab.Widgets.containerRecommendedPlan.show = false;
    Prefab.Widgets.containerAllPlans.show = false;
};

Prefab.buttonShowPersonalisedPlansClick = function($event, widget) {
    Prefab.Widgets.containerQuiz.show = false;
    Prefab.Widgets.containerRecommendedPlan.show = true;
    Prefab.Widgets.containerAllPlans.show = false;
};

Prefab.anchorAllPlansClick = function($event, widget) {
    Prefab.Widgets.containerQuiz.show = false;
    Prefab.Widgets.containerRecommendedPlan.show = false;
    Prefab.Widgets.containerAllPlans.show = true;
};

Prefab.anchorRetakeQuizClick = function($event, widget) {
    Prefab.Widgets.containerQuiz.show = true;
    Prefab.Widgets.containerRecommendedPlan.show = false;
    Prefab.Widgets.containerAllPlans.show = false;
};

Prefab.buttonremoveRecommendedPlanClick = function($event, widget) {
    Prefab.Widgets.buttonSelectRecommendedPlan.show = true;
    Prefab.Widgets.buttonremoveRecommendedPlan.show = false;
    Prefab.selectedPlan = undefined;
};

Prefab.buttonSelectRecommendedPlanClick = function($event, widget) {
    Prefab.Widgets.buttonSelectRecommendedPlan.show = false;
    Prefab.Widgets.buttonremoveRecommendedPlan.show = true;
    Prefab.selectedPlan = Prefab.Variables.stvRecommendedPlan.dataSet;
};

Prefab.buttonSelectAddonClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Variables.stvSelectedAddOns.dataSet.push(item);

    currentItemWidgets.buttonSelectAddon.show = false;
    currentItemWidgets.buttonRemoveAddon.show = true;
};

Prefab.buttonRemoveAddonClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Variables.stvSelectedAddOns.dataSet = Prefab.Variables.stvSelectedAddOns.dataSet.filter(addon => addon.id != item.id);

    currentItemWidgets.buttonSelectAddon.show = true;
    currentItemWidgets.buttonRemoveAddon.show = false;
};


Prefab.stvSimTypesList1Select = function(widget, $data) {
    Prefab.selectedSim = $data.simType;
};

/*
 * on plan change
 */
Prefab.planChange = function() {

};

Prefab.PhonePricePlans1Planchange = function($event, $data) {
    if ($data && $data.id == Prefab.Variables.stvRecommendedPlan.dataSet.id) {
        Prefab.Widgets.buttonSelectRecommendedPlan.show = false;
        Prefab.Widgets.buttonremoveRecommendedPlan.show = true;
    } else {
        Prefab.Widgets.buttonSelectRecommendedPlan.show = true;
        Prefab.Widgets.buttonremoveRecommendedPlan.show = false;
    }
    Prefab.selectedPlan = $data;
};
Prefab.buttonContinuePortingClick = function($event, widget) {
    Prefab.Widgets.containerPortabilityCheck.show = false;
    Prefab.Widgets.containerSelectCurrentPhone.show = true;
};

Prefab.buttonShowOwnPhoneClick = function($event, widget) {
    Prefab.Widgets.containerPortabilityCheck.show = true;
    Prefab.Widgets.containerSelectCurrentPhone.show = false;
    Prefab.Widgets.containerBringYourOwPhone.show = false;
    if (Prefab.Widgets.wizard1) {
        Prefab.Widgets.wizard1.show = true;
    }

    if (Prefab.Widgets.wizard4) {
        Prefab.Widgets.wizard4.show = true;
        Prefab.Widgets.container62_1.show = true;
    }
};

Prefab.buttonViewOrdersClick = function($event, widget) {
    Prefab.Widgets.dialogPaymentSuccessful.close();
    Prefab.onVieworders();
};

Prefab.buttonContinueShoppingClick = function($event, widget) {
    Prefab.Widgets.dialogPaymentSuccessful.close();
    Prefab.onContinueshopping();
};

function getRandomUniqueNumber() {
    let randomNumber = Math.floor(Math.random() * 9000000) + 1000000
    return randomNumber;
}

Prefab.svCreateOrderonBeforeUpdate = function(variable, inputData, options) {
    inputData.Orders.createdAt = moment().toDate();
    inputData.Orders.deliveryDate = moment().add(5, 'days').toDate();
    inputData.Orders.orderId = getRandomUniqueNumber();
};

Prefab.buttonSelectAddonCardClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Variables.stvSelectedAddOns.dataSet.push(item);

    currentItemWidgets.buttonSelectAddonCard.show = false;
    currentItemWidgets.buttonRemoveAddoncard.show = true;
};

Prefab.buttonRemoveAddoncardClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Variables.stvSelectedAddOns.dataSet = Prefab.Variables.stvSelectedAddOns.dataSet.filter(addon => addon.id != item.id);

    currentItemWidgets.buttonSelectAddonCard.show = true;
    currentItemWidgets.buttonRemoveAddoncard.show = false;
};

Prefab.wizard1Cancel = function(widget, steps) {
    Prefab.onCancel();
};

Prefab.wizardstepPricePlanNext = function(widget, currentStep, stepIndex) {
    if (!Prefab.selectedPlan) {
        Prefab.Actions.nta_selectPlanWarn.invoke();
        return false;
    }
};

Prefab.PhonePricePlansMobilePlanchange = function($event, $data) {
    Prefab.selectedPlan = $data;
};

Prefab.wizardstepPlansMobileNext = function(widget, currentStep, stepIndex) {
    if (!Prefab.selectedPlan) {
        Prefab.Actions.nta_selectPlanWarn.invoke();
        return false;
    }
};

Prefab.listSimTypesMobileSelect = function(widget, $data) {
    Prefab.selectedSim = $data.simType;
};


Prefab.wsAddOnsListonSuccess = function(variable, data) {
    Prefab.Variables.stvMobileAddons.dataSet = data;
    Prefab.Variables.stvMobileAddons.dataSet = Prefab.Variables.stvMobileAddons.dataSet.map(item => {
        item.isActive = false;
        return item;
    });
};

Prefab.listMobileAddonCategoriesSelect = function(widget, $data) {
    Prefab.Variables.stvCurrentMobileAddons.dataSet = Prefab.Variables.stvMobileAddons.dataSet.filter(item => item.categoryId == $data.id);
    Prefab.Widgets.stvCurrentMobileAddonsList1.selecteditem = Prefab.Variables.stvMobileAddons.dataSet.filter(item => item.isActive && item.categoryId == $data.id);
};

Prefab.dialogOrderSummaryMobileOpened = function($event, widget) {
    Prefab.Variables.stvSelectedMobileAddons.dataSet = Prefab.Variables.stvMobileAddons.dataSet.filter(item => item.isActive);
};

Prefab.stvCurrentMobileAddonsList1Tap = function($event, widget) {
    Prefab.Variables.stvMobileAddons.dataSet.forEach(item => {
        if (item.categoryId === Prefab.Widgets.stvCurrentMobileAddonsList1.selecteditem[0].categoryId) {
            item.isActive = Prefab.Widgets.stvCurrentMobileAddonsList1.selecteditem.some(selectedItem => selectedItem.id === item.id);
        }
    });
};

Prefab.stvCurrentMobileAddonsList1Beforedatarender = function(widget, $data) {
    let data = Prefab.Variables.stvMobileAddons.dataSet.filter(item => item.isActive && item.categoryId == Prefab.Widgets.listMobileAddonCategories.selecteditem.id);
    Prefab.Widgets.stvCurrentMobileAddonsList1.selecteditem = Prefab.Variables.stvMobileAddons.dataSet.filter(item => item.isActive && item.categoryId == Prefab.Widgets.listMobileAddonCategories.selecteditem.id);
};
