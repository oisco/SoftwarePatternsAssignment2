angular.module('app').controller("ProductsController", function ($window,$scope,$http, $location, productService) {

    var vm=this;
    vm.products=[];
    vm.isAdmin=$window.sessionStorage.isAdmin;

    var url="/products/all"
    var productsPromise=$http.get(url);
    productsPromise.then(function (response) {
        vm.products=response.data;
    })

    vm.gotToAddProduct=function () {
        $location.path("AddProduct");
    }

    vm.goToViewProduct=function (product) {
        productService.viewProduct(product);
        $location.path("ViewProduct/"+product.id);
    }

});
