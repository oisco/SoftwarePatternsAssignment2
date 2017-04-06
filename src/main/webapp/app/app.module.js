(function(){
    'use strict';
    var app=angular.module('app',["ngRoute"]);
    app.config(function($routeProvider) {
        $routeProvider
            .when("/Register", {
                templateUrl : "templates/Register.html",
                controller : "RegisterController as vm"
            })
            .when("/Home", {
                templateUrl : "templates/Home.html",
                controller : "HomeController as vm",
            })
            .when("/Products", {
                templateUrl : "templates/ViewAllProducts.html",
                controller : "ProductsController as vm",
            })
            .when("/AddProduct", {
                templateUrl : "templates/AddProduct.html",
                controller : "AddProductController as vm",
            })
            .when("/EditProduct/:id", {
            templateUrl : "templates/EditProduct.html",
            controller : "EditProductController as vm",
            })
            .when("/ViewProduct/:id", {
                templateUrl : "templates/ViewProduct.html",
                controller : "ViewProductController as vm",
            })
            .when("/MyCart", {
                templateUrl : "templates/MyCart.html",
                controller : "MyCartController as vm",
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

    //general product functionality to be reused throughout controllers by users
    app.service('productService', function() {
        var cart = [];
        var productToView;

        var addProduct = function(prod) {
            cart.push(prod);
        };

        //below two functions are for passing products between controllers
        var viewProduct = function(prod) {
            productToView=prod;
            debugger;
        };

        var getProductToView=function(){
            return productToView;
        }

        var getCart = function(){
            return cart;
        };

        return {
            addProduct: addProduct,
            getCart: getCart,
            viewProduct:viewProduct,
            getProductToView:getProductToView
        };

    });

})();


