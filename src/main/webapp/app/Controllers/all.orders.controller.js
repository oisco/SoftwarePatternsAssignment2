angular.module('app').controller("ViewAllOrdersController", function ($scope, $http, $location) {
    var vm = this;
    vm.orders = [];

    var url = "orders/all";
    var ordersPromise = $http.get(url);
    ordersPromise.then(function (response) {
        vm.orders = response.data;
    });


    vm.viewOrder = function (id) {
        $location.path("ViewOrder/" + id);
    }


});
