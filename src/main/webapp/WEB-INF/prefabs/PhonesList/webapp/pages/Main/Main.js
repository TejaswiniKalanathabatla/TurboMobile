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
        case "produclistdirection":
            if (Prefab.Widgets.PhoneslistList) {
                Prefab.Widgets.PhoneslistList.direction = Prefab.produclistdirection;
            }

            if (Prefab.Widgets.listPhonesMobile) {
                Prefab.Widgets.listPhonesMobile.direction = Prefab.produclistdirection;
            }
            break;
    }

};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    if (Prefab.Widgets.PhoneslistList) {
        Prefab.Widgets.PhoneslistList.direction = Prefab.produclistdirection;
    }

    if (Prefab.Widgets.listPhonesMobile) {
        Prefab.Widgets.listPhonesMobile.direction = Prefab.produclistdirection;
    }
};

Prefab.buttonSelectPhoneClick = function($event, widget, item, currentItemWidgets) {
    Prefab.onSelectphone(item);
};

/*
 * selectphonedetails: added this method as we are facing issu to bind selected as out-bound property onject
 */
Prefab.getselectphonedetails = function() {
    if (Prefab.Widgets.PhoneslistList) {
        return Prefab.Widgets.PhoneslistList.selecteditem;
    }

    if (Prefab.Widgets.listPhonesMobile) {
        return Prefab.Widgets.listPhonesMobile.selecteditem;
    }
};

Prefab.listPhonesMobileSelect = function(widget, $data) {
    Prefab.onSelectphone("", $data);
};
