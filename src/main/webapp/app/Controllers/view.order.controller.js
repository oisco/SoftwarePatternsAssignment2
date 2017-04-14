angular.module('app').controller("ViewOrderController", function ($scope, $http, $routeParams) {
    var vm = this;
    vm.order = null;

    function getOrder(id) {
        var url = "orders/view/" + id;
        var ordersPromise = $http.get(url);
        ordersPromise.then(function (response) {
            vm.order = response.data;
        });
    }

    getOrder($routeParams.id);

});
