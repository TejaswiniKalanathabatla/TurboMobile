/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */

var DialogService = App.getDependency('DialogService');
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};

Partial.anchor2Click = function($event, widget) {
    Partial.Widgets.CommonLoginDialog.close();
    Partial.Widgets.dialogRegister.open();
};

Partial.anchor6Click = function($event, widget) {
    Partial.Widgets.dialogRegister.close();
    Partial.Widgets.CommonLoginDialog.open();
};