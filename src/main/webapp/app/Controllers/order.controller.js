angular.module('app').controller("OrderController", function ($http, $window) {

    var vm=this;
    var userId=$window.sessionStorage.userId;

    var url="/orders/"+userId;
    var ordersPromise=$http.get(url);
    ordersPromise.then(function (response) {
        vm.orders=response.data;
        debugger;
    })


});
