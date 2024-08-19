import CoreRouter = require("ojs/ojcorerouter");
  import ModuleRouterAdapter = require("ojs/ojmodulerouter-adapter");
  import KnockoutRouterAdapter = require("ojs/ojknockoutrouteradapter");
  import UrlParamAdapter = require("ojs/ojurlparamadapter");
  import ArrayDataProvider = require("ojs/ojarraydataprovider");
  import * as ko from "knockout";
  import { whenDocumentReady } from "ojs/ojbootstrap";
  import "ojs/ojknockout";
  import "ojs/ojnavigationlist";
  import "ojs/ojmodule-element";
  
  class ViewModel {
    // Define the routes
    private readonly routes = [
      { path: "", redirect: "incidents" }, // Default route redirects to 'incidents'
      { path: "dashboard", detail: { label: "Dashboard" } },
      { path: "incidents", detail: { label: "Incidents" } },
      { path: "customers", detail: { label: "Customers" } },
      { path: "about", detail: { label: "About" } },
      { path: "welcome", detail: { label: "welcome" } },
      
    ];
  
    // Create ADP with partial array, excluding first redirect route
    readonly dataProvider = new ArrayDataProvider(this.routes.slice(1), {
      keyAttributes: "path",
    });
  
    // Create the router with the routes
    private readonly router = new CoreRouter(this.routes, {
      urlAdapter: new UrlParamAdapter(),
    });
  
    // Create ModuleRouterAdapter instance
    readonly module = new ModuleRouterAdapter(this.router, {
      viewPath: "views/corerouter/child/",
      viewModelPath: "viewModels/corerouter/child/",
    });
  
    // Create an observable to react to the current router state path
    readonly selection = new KnockoutRouterAdapter(this.router);
  
    constructor() {
      // Synchronize the router, causing it to go to its default route
      this.router.sync();
    }
  }
  
  whenDocumentReady().then(() => {
    ko.applyBindings(
      new ViewModel(),
      document.getElementById("routing-container")
    );
  });