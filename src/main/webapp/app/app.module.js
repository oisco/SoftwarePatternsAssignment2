(function(){
    'use strict';
    var app=angular.module('app',["ngRoute"]);

    app.config(function($routeProvider) {
        $routeProvider
            .otherwise({
                templateUrl : "/templates/Home.html",
                controller : "HomeController as vm"
            })
    });


})();


