angular.module('app').controller("ProductsController", function ($window,$scope,$http, $location) {

    var vm=this;
    vm.products=[];
    vm.isAdmin=$window.sessionStorage.isAdmin;

    var url="/products/all"
    var productsPromise=$http.get(url);
    productsPromise.then(function (response) {
        vm.products=response.data;
        debugger;
    })

    vm.gotToAddProduct=function () {
        $location.path("AddProduct");

    }

//take index as a param for updating the UI
    vm.removeProduct=function (product,index) {
        var url="/products/remove/"+product.id;
        debugger;
        $http.delete(url).success(function(){
            vm.products.splice(index, 1)
            });
    }
});
