angular.module('app').controller("CheckoutController", function (productService,$http, $location,$window) {

    var vm=this;
    vm.address=null;
    vm.paymentType=null;
    vm.order=productService.getCart();
    vm.total=productService.total();

    var userId=$window.sessionStorage.userId;

        //request the users address from server
    var url="/user/"+userId+"/address";
    var addressPromise=$http.get(url);
    addressPromise.then(function (response) {
            vm.address=response.data;
        });

    vm.saveOrder=function () {
        vm.order
        vm.address;
        vm.paymentType;
         var params=[vm.order,vm.address,vm.paymentType,userId];
        debugger
        var url="orders/add";
        $http({
            method: 'POST',
            url: url,
            data:params,
            headers: {'Content-Type': 'application/json'}
        });
    }
});
