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

Prefab.dialogESIMActivateOpened = function($event, widget) {
    Prefab.Widgets.containerESIMInstructions.show = true;
    Prefab.Widgets.containerESIMDetection.show = false;
    Prefab.Widgets.containerESIMFinish.show = false;
};

Prefab.pictureESIMQRCodeClick = function($event, widget) {
    Prefab.Widgets.containerESIMInstructions.show = false;
    Prefab.Widgets.containerESIMDetection.show = true;
    Prefab.Widgets.containerESIMFinish.show = false;
};

Prefab.containerESIMDetectionClick = function($event, widget) {
    Prefab.Widgets.containerESIMInstructions.show = false;
    Prefab.Widgets.containerESIMDetection.show = false;
    Prefab.Widgets.containerESIMFinish.show = true;
};

Prefab.dialogActivateEsimMoileOpened = function($event, widget) {
    Prefab.Widgets.containerEsimDetectionMobile.show = true;
    Prefab.Widgets.containerActivationFinishMobile.show = false;
};

Prefab.containerEsimDetectionMobileClick = function($event, widget) {
    Prefab.Widgets.containerEsimDetectionMobile.show = false;
    Prefab.Widgets.containerActivationFinishMobile.show = true;
};

Prefab.button9Click = function($event, widget) {
    Prefab.Variables.svUpdateSimActivatedStatusMobile.invoke({
        inputFields: {
            "id": Prefab.currentMobileOrder.phoneOrders.id,
            "PhoneOrders": {
                "isSimActivated": true
            }
        }
    });
};

Prefab.button7Click = function($event, widget, item, currentItemWidgets) {
    Prefab.currentMobileOrderId = item.id
    Prefab.currentMobileOrder = item;
};
