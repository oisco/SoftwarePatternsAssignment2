angular.module('app').controller("CheckoutController", function (productService, $http, $location, $cookies) {

    var vm=this;
    vm.address=null;
    vm.paymentType=null;
    vm.order=productService.getCart();
    vm.total=productService.total();

    var userId = $cookies.getObject("user").userId;

        //request the users address from server
    var url="/user/"+userId+"/address";
    var addressPromise=$http.get(url);
    addressPromise.then(function (response) {
            vm.address=response.data;
        });

    vm.saveOrder=function () {
         var params=[vm.order,vm.address,vm.paymentType,userId];
        var url="orders/add";
        $http({
            method: 'POST',
            url: url,
            data:params,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            if (data == "") {
                alert("Your order is on its way");
                productService.clearCart();
                $location.path("MyCart");
            }
        });
    }
});
