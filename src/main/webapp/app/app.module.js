(function(){
    'use strict';
    var app=angular.module('app',["ngRoute"]);

    app.config(function($routeProvider) {
        $routeProvider
            .when("/viewProducts/all", {

            })
            .when("/Register", {
                templateUrl : "templates/Register.html",
                controller : "RegisterController as vm"
            })
            .otherwise({
                templateUrl : "/templates/Login.html",
                controller : "HomeController as vm"
            })
    });


})();


