angular.module('app').controller("OrderController", function ($http, $cookies) {

    var vm=this;
    var userId = $cookies.getObject("user").userId;

    var url="/orders/"+userId;
    var ordersPromise=$http.get(url);
    ordersPromise.then(function (response) {
        vm.orders=response.data;
        debugger;
    })


});
