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
            .when("/CustHome", {
                templateUrl : "templates/CustomerHome.html",
            })
            .otherwise({
                templateUrl : "/templates/Login.html",
                controller : "HomeController as vm"
            })
    });

    app.factory('User', function($http) {

        var User = function (username, password) {
            this.username = username;
            this.password = password;
        }

        return User;
    });



})();


