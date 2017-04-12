angular.module('app').controller("MyCartController", function (productService, $http, $location, UserState) {

    var vm=this;
    vm.products=productService.getCart();
    vm.total = productService.total();

    //subscribe to observer
    UserState.subscribe(function (notification) {
        //if login =false then clear the users cart
        if (!notification) {
            productService.clearCart();
            debugger
        }
    });

    vm.removeProduct=function (product) {
        productService.removeProduct(product);
        vm.total = productService.total();
        alert("Product removed");
    };
    vm.goToCheckout=function(){
        $location.path("Checkout");

    }


});
