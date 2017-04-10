angular.module('app').controller("MyCartController", function (productService,$http, $location) {

    var vm=this;
    vm.products=productService.getCart();
    vm.getTotal = function(){
        var total = 0;
        for(var i = 0; i < vm.products.length; i++){
            total += (vm.products[i].price );
        }
        return total;
    }

    vm.removeProduct=function (product) {
        productService.removeProduct(product);
        alert("Product removed");
    }
    vm.goToCheckout=function(){
        $location.path("Checkout");

    }


});
