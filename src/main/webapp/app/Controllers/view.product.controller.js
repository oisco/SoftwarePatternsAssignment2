angular.module('app').controller("ViewProductController", function ($http,$window, $location,productService) {
    var vm=this;
    vm.isAdmin=$window.sessionStorage.isAdmin;
    vm.product=productService.getProductToView();
    debugger;

    vm.goToEditProduct=function () {
        productService.viewProduct(vm.product);
        $location.path("EditProduct/"+vm.product.id);
    }
    vm.removeProduct=function () {
        var url="/products/remove/"+vm.product.id;
        $http.delete(url).success(function(){
            vm.products.splice(index, 1)
        }).success(function (data) {
            if (data == "") {
                alert("product removed");
                $location.path("Products")
            }
        });
    }

    vm.addToCart=function () {
        vm.product.stockLevel--;
        productService.addProduct(vm.product);
        alert("product added to cart");

    }

});
