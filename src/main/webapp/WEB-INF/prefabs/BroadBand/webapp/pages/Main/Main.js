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
var VALIDATOR = (App.getDependency('CONSTANTS') || {}).VALIDATOR || {};
//var VALIDATOR = App.getDependency('CONSTANTS').VALIDATOR;

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
    Prefab.selectedPlan = undefined;
};

Prefab.buttonBrowsePlansClick = function($event, widget) {
    // //Reset to first step
    // Prefab.Widgets.wizardBroadband.steps.forEach((item) => {
    //     if (Prefab.Widgets.wizardBroadband.hasPrevStep) {
    //         Prefab.Widgets.wizardBroadband.prev();
    //     }
    // });
    containersShowHide(true);
};

Prefab.wizardBroadbandCancel = function(widget, steps) {
    containersShowHide(false);
    resetWizardBroadband();
};

function containersShowHide(show) {
    Prefab.Widgets.containerCoverage.show = !show;
    Prefab.Widgets.containerWizard.show = show;
}


Prefab.buttonRemoveClick = function($event, widget, item, currentItemWidgets) {
    addAndRemovedCartButtons(false, true, false);
    Prefab.selectedPlanId = undefined;
    resetListWidget();
};

Prefab.buttonAddClick = function($event, widget, item, currentItemWidgets) {
    addAndRemovedCartButtons(true, false, true);
    Prefab.selectedPlanId = item.id;
};

Prefab.buttonAddPlanMobileClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Widgets.listPlansMobile.itemWidgets.forEach(currItem => {
        currItem.buttonAddPlanMobile.disabled = true;
    });

    currentItemWidgets.buttonAddPlanMobile.show = false;
    currentItemWidgets.buttonRemovePlanMobile.show = true;
    Prefab.selectedPlanId = item.id;
    Prefab.selectedPlan = item;
};

Prefab.buttonRemovePlanMobileClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Widgets.listPlansMobile.itemWidgets.forEach(currItem => {
        currItem.buttonAddPlanMobile.disabled = false;
    });

    currentItemWidgets.buttonAddPlanMobile.show = true;
    currentItemWidgets.buttonRemovePlanMobile.show = false;
    Prefab.selectedPlanId = undefined;
    Prefab.selectedPlan = undefined;
};

function addAndRemovedCartButtons(removeShowVal, addShowVal, addDisableVal) {
    Prefab.Widgets.GetBroadbandPlanList1.getWidgets('buttonRemove').forEach((item) => {
        if (item.context.item.id === Prefab.Widgets.GetBroadbandPlanList1.selecteditem.id) {
            item.show = removeShowVal;
        } else {
            item.show = false;
        }
    });

    Prefab.Widgets.GetBroadbandPlanList1.getWidgets('buttonAdd').forEach((item) => {
        if (item.context.item.id === Prefab.Widgets.GetBroadbandPlanList1.selecteditem.id) {
            item.show = addShowVal;
        } else {
            item.disabled = addDisableVal;
        }
    });

    Prefab.Widgets.GetBroadbandPlanList1.listItems._results.forEach((listitem) => {
        if (listitem.item.id === Prefab.Widgets.GetBroadbandPlanList1.selecteditem.id) {
            listitem.disableItem = false;
        } else {
            addDisableVal ? listitem.disableItem = addDisableVal : listitem.disableItem = false;
        }
    });
}

Prefab.wizardstepSummaryLoad = function(widget, stepIndex) {
    Prefab.Variables.stvSelectedProduct.dataSet = [];
    Prefab.Variables.stvSelectedProduct.addItem(Prefab.Widgets.GetBroadbandPlanList1.selecteditem);
    Prefab.Variables.stvSelectedProduct.addItem(Prefab.Variables.stvInstallationKitDetails.dataSet);
};

Prefab.anchorViewDetailsClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Widgets.wizardBroadband.prev(); //$("[name='nextBtn_wizardBroadband']").click();
};

Prefab.anchorEditClick = function($event, widget, item, currentItemWidgets) {
    Prefab.Widgets.wizardBroadband.prev();
};

//To add primary address
Prefab.IsAddressSameAsPrimaryClick = function($event, widget) {
    if (Prefab.Widgets.IsAddressSameAsPrimary_formWidget.datavalue) {} else {
        Prefab.Widgets.UserAddressDetailsForm1.formdata = [];
        Prefab.Widgets.UserAddressDetailsForm1.formdata = Prefab.Variables.wsGetUserAddressDetails.dataSet.content[0];
    }
};

//To get the toal of specific columnName from an array 
Prefab.getSubTotal = function(selectedProduct) {
    return selectedProduct.reduce((accumulator, currentValue) => accumulator + currentValue['price'], 0);
};


//reset the wizard on cancel
function resetWizardBroadband() {
    Prefab.Widgets.stvCoverageForm1 ? Prefab.Widgets.stvCoverageForm1.formWidgets.zipcode.datavalue = '' : '';
    Prefab.Widgets.UserAddressDetailsForm1 ? Prefab.Widgets.UserAddressDetailsForm1.reset() : '';
    Prefab.Widgets.stvPaymentFormFieldDetailsForm1 ? Prefab.Widgets.stvPaymentFormFieldDetailsForm1.reset() : '';
    // resetListWidget();
}

function resetListWidget() {
    Prefab.Widgets.GetBroadbandPlanList1.selecteditem = '';

    Prefab.Widgets.GetBroadbandPlanList1.getWidgets('buttonRemove').forEach((removeButtionItem) => {
        removeButtionItem.show = false;
    });

    Prefab.Widgets.GetBroadbandPlanList1.getWidgets('buttonAdd').forEach((addButtionItem) => {
        addButtionItem.show = true;
        addButtionItem.disabled = false;
    });

    Prefab.Widgets.GetBroadbandPlanList1.listItems._results.forEach((listitem) => {
        listitem.disableItem = false;
    });
}

//adding randomNumber, getCurrentDateTime on before update to avoid infinite loop
Prefab.swCreateOrderonBeforeUpdate = function(variable, inputData, options) {
    inputData.Orders.orderId = getRandomOrderId();
    inputData.Orders.createdAt = getCurrentDateTime();
    inputData.Orders.deliveryDate = getDeliveryDate();
};

//creating broadband order on sucessfull creation of an order
Prefab.swCreateOrderonSuccess = function(variable, data) {
    createBroadBand(data);
};

function createBroadBand(data) {
    var sv = Prefab.Variables.swcreateBroadbandOrder;
    sv.invoke({
        "inputFields": {
            "BroadbandOrders": {
                "broadbandPlanId": Prefab.selectedPlanId,
                "orderId": data.id
            }
        }
    }, function(data) {
        Prefab.Widgets.dialogConfirmOrder.close();
        Prefab.Widgets.dialogPaymentSucess.open();
    }, function(error) {
        console.log("error", error);
    });
}

//Invoking call back events (on view & continue shopping)
Prefab.buttonContinueShoppingClick = function($event, widget) {
    Prefab.onContinueshopping(Prefab.Variables.stvSelectedProduct.dataSet);
};

Prefab.buttonViewOrdersClick = function($event, widget) {
    Prefab.onVieworder(Prefab.Variables.stvSelectedProduct.dataSet);
};


//to get randomNumber for to create an order
function getRandomOrderId() {
    if (Prefab.Variables.swGetOrders.dataSet || Prefab.Variables.swGetOrders.dataSet.length > 0) {
        const columnValues = Prefab.Variables.swGetOrders.dataSet.map(obj => obj['order_id']);
        let randomNumber;

        do {
            randomNumber = Math.floor(Math.random() * 9000000) + 1000000;
        } while (columnValues.includes(randomNumber));

        return randomNumber;
    }
}

//common function to get current date & time 
function getCurrentDateTime() {
    return new Date().getTime(); //moment().format('YYYY-MM-DD HH:mm:ss');
}
//common function to get current date + 5days 
function getDeliveryDate() {
    return moment().add(5, 'days').toDate().getTime();
}

Prefab.form_field35Click = function($event, widget) {
    Prefab.Widgets.AddressControllerForm1.formdata = [];
    Prefab.Widgets.AddressControllerForm1.formdata = Prefab.Variables.wsGetUserAddressDetails.dataSet.content[0];
};
