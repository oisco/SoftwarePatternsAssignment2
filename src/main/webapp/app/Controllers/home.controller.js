angular.module('app').controller("HomeController", function ($scope, $http, $location, $cookies) {
    var vm=this;
    vm.user = $cookies.getObject("user");
});
