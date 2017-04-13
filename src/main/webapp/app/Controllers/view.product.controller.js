angular.module('app').controller("ViewProductController", function ($http, $cookies, $location, productService) {
    var vm=this;
    vm.comment = null;
    vm.product=productService.getProductToView();
    vm.user = $cookies.getObject("user");


    vm.rating = 0;
    vm.ratings = [{
        current: 5,
        max: 10
    }, {
        current: 3,
        max: 5
    }];

    vm.getSelectedRating = function (rating) {
        console.log(rating);
    };

    vm.goToEditProduct=function () {
        productService.viewProduct(vm.product);
        $location.path("EditProduct/"+vm.product.id);
    };
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
    };

    vm.addToCart=function () {
        vm.product.stockLevel--;
        productService.addProduct(vm.product);
        alert("product added to cart");

    };

    vm.postComment = function () {
        var url = "products/" + vm.product.id + "/comment";
        $http({
            method: 'POST',
            url: url,
            data: vm.comment,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            if (data == "") {
                alert("comment added");
                vm.product.comments.push(vm.comment);
            }
        });
    }

});
