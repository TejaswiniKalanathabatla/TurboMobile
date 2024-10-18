/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
};

Page.ProductDetails1Continue = function($event, $data) {
    var pageBreadCrumb = App.Variables.stvBreadcrumbDataset.getData();
    debugger
    pageBreadCrumb[0].children[0].children[1].label = Page.Widgets.ProductDetails1.productvariant.phone.company + ' ' + Page.Widgets.ProductDetails1.productvariant.phone.name;
    Page.Actions.nav_goto_shopPhones.invoke();
};
