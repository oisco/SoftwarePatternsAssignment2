angular.module('app').controller("EditProductController", function (productService,$http, $location) {

    var vm=this;
    vm.product=productService.getProductToView();

    vm.updateProduct=function(){
        vm.product;
        debugger;
        var url="/products/update";
        $http({
            method: 'PUT',
            url: url,
            data: vm.product,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            if (data == "") {
                alert("product updated");
                $location.path("Products")
            }
        });
    }


});
