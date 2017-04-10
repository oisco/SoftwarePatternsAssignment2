angular.module('app').controller("CheckoutController", function (productService,$http, $location) {

    var vm=this;
    vm.order=productService.getCart();

    vm.getUsersAddress=function () {
        //request the users address from server
    }




});
