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

    vm.checkout=function(){
        //
        // var url="/products/update";
        // $http({
        //     method: 'PUT',
        //     url: url,
        //     data: vm.product,
        //     headers: {'Content-Type': 'application/json'}
        // }).success(function (data) {
        //     if (data == "") {
        //         alert("product updated");
        //         $location.path("Products")
        //     }
        // });
    }


});
