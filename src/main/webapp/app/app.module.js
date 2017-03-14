(function(){
    'use strict';
    var app=angular.module('app',["ngRoute"]);

    app.config(function($routeProvider) {
        $routeProvider
            .when("/viewProducts/all", {

            })
            .otherwise({
                templateUrl : "/templates/Login.html",
                controller : "HomeController as vm"
            })
    });


})();


