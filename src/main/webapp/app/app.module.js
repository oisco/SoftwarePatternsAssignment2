(function(){
    'use strict';
    var app=angular.module('app',["ngRoute"]);
    // var loggedIn = false;
    app.config(function($routeProvider) {
        $routeProvider
            .when("/viewProducts/all", {

            })
            .when("/Register", {
                templateUrl : "templates/Register.html",
                controller : "RegisterController as vm"
            })
            .when("/CustHome", {
                templateUrl : "templates/Home.html",
                controller : "HomeController as vm",
            })
            .when("/Products", {
                templateUrl : "templates/ViewAllProducts.html",
                controller : "ProductsController as vm",
            })
            .otherwise({
                templateUrl : "/templates/Login.html",
                controller : "LoginController as vm"
            })

    });

    app.factory('User', function() {

        var User = function (username, password) {
            this.username = username;
            this.password = password;
        }

        return User;
    });



})();


