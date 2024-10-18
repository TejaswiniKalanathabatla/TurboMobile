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

Page.PhonesList1Selectphone = function($event, $data) {
    var pageBreadCrumb = App.Variables.stvBreadcrumbDataset.getData();
    if (_.includes(pageBreadCrumb[0].children[0].children[0].label, "?")) {
        pageBreadCrumb[0].children[0].children[0].label = Page.Widgets.PhonesList1.getselectphonedetails().company + ' ' + Page.Widgets.PhonesList1.getselectphonedetails().name;
    }
    Page.Actions.goToPage_ProductDetails.invoke();
};
