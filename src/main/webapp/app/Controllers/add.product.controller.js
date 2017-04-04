angular.module('app').controller("AddProductController", function ($scope,$http, $location,$window) {
    var vm=this;
   //
   //  vm.product=null;
   //
   // vm.submit=function () {
   //  vm.product;
   // debugger;
   // }

    vm.createProduct=function(product) {

        if($scope.addProductForm.$valid)
        {
            var url="/products/add"
            $http({
                method: 'POST',
                url: url,
                data: product,
                headers: {'Content-Type': 'application/json'}
            }).success(function(data) {
                if (data == "") {
                    alert("product created");
                    $location.path("Products")
                }
            });
        }

    }

});
