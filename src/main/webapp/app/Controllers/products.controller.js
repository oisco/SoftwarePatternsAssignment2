angular.module('app').controller("ProductsController", function ($window,$scope,$http, $location) {

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

    vm.goToEditProduct=function (id) {
        $location.path("EditProduct/"+id);
    }

    vm.goToViewProduct=function (id) {
        $location.path("ViewProduct/"+id);
    }

//take index as a param for updating the UI
    vm.removeProduct=function (product,index) {
        var url="/products/remove/"+product.id;
        $http.delete(url).success(function(){
            vm.products.splice(index, 1)
            });
    }
});
