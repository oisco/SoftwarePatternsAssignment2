(function(){
    'use strict';
    var app = angular.module('app', ["ngRoute", 'ngCookies']);
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
            .when("/AllOrders", {
                templateUrl: "templates/AllOrders.html",
                controller: "ViewAllOrdersController as vm",
            })
            .when("/ViewOrder/:id", {
                templateUrl: "templates/ViewOrder.html",
                controller: "ViewOrderController as vm",
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
            .when("/Checkout", {
                templateUrl : "templates/Checkout.html",
                controller : "CheckoutController as vm",
            })
            .when("/MyOrders", {
                templateUrl : "templates/MyOrders.html",
                controller : "OrderController as vm",
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
        };
        return User;
    });

    //general product functionality to be reused throughout controllers by users
    app.service('productService', function() {
        var cart = [];
        var productToView;

        var removeProduct=function (prod) {
            cart.splice(cart.indexOf(prod),1);
        };

        var addProduct = function(prod) {
            cart.push(prod);
        };

        var clearCart = function () {
            cart = [];
        };
        //below two functions are for passing products between controllers
        var viewProduct = function(prod) {
            productToView=prod;
        };

        var getProductToView=function(){
            return productToView;
        };

        var total = function () {
            var cost=0;
            for(var i = 0; i < cart.length; i++){
                cost += (cart[i].price );
            }
            return cost;
        };

        var getCart = function(){
            return cart;
        };

        return {
            addProduct: addProduct,
            getCart: getCart,
            viewProduct:viewProduct,
            getProductToView:getProductToView,
            removeProduct:removeProduct,
            total: total,
            clearCart: clearCart
        };

    });

    //used for product ratings
    app.directive('starRating', function () {
        return {
            restrict: 'A',
            template: '<ul class="rating">' +
            '<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">' +
            '\u2605' +
            '</li>' +
            '</ul>',
            scope: {
                ratingValue: '=',
                max: '=',
                onRatingSelected: '&'
            },
            link: function (scope, elem, attrs) {

                var updateStars = function () {
                    scope.stars = [];
                    for (var i = 0; i < scope.max; i++) {
                        scope.stars.push({
                            filled: i < scope.ratingValue
                        });
                    }
                };

                scope.toggle = function (index) {
                    scope.ratingValue = index + 1;
                    scope.onRatingSelected({
                        rating: index + 1
                    });
                };

                scope.$watch('ratingValue', function (oldVal, newVal) {
                    if (newVal) {
                        updateStars();
                    }
                });
            }
        }
    });

    //factory below uses observer pattern to notify controllers when the user logs out to --1. hide navbar 2. clear cart
    app.factory('UserState', function () {
        var _subscribers = [];

        return {
            //add a subscriber
            subscribe: function (cb) {
                _subscribers.push(cb);
            },
            notify:function(toNotify) {
                // notify all subscribers
                angular.forEach(_subscribers, function (cb) {
                    cb(toNotify);
                });
            }
        };

    })

})();


