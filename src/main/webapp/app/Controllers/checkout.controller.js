angular.module('app').controller("CheckoutController", function (productService,$http, $location,$window) {

    var vm=this;
    vm.address=null;
    vm.order=productService.getCart();
    vm.total=productService.total();

    var userId=$window.sessionStorage.userId;

        //request the users address from server
        var url="/user/"+userId+"/address";
        var addressPromise=$http.get(url);
        addressPromise.then(function (response) {
            vm.address=response.data;
        })



});
