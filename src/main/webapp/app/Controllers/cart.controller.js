angular.module('app').controller("MyCartController", function (productService,$http, $location) {

    var vm=this;
    vm.products=productService.getCart();
    vm.total = productService.total();

    vm.removeProduct=function (product) {
        productService.removeProduct(product);
        vm.total = productService.total();
        alert("Product removed");
    }
    vm.goToCheckout=function(){
        $location.path("Checkout");

    }


});
