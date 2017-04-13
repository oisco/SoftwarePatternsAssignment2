angular.module('app').controller("ViewProductController", function ($http, $cookies, $location, productService) {
    var vm=this;

    //average rating
    vm.rating = 2;
    var totalRating = 0;
    var setAverageRating = function () {
        vm.product;
        vm.product = productService.getProductToView();
        for (var i = 0; i < vm.product.comments.length; i++) {
            totalRating += vm.product.comments[i].rating;
        }
        vm.rating = (totalRating / vm.product.comments.length);
        debugger;
    };

    vm.setRating = function (rating) {
        //for users review rating
        vm.comment.rating = rating;
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
        //transient user id used to set the user once the request arrives as the server
        vm.comment.userId = vm.user.userId;
        vm.comment.comment = "'" + vm.comment.comment + "' - " + vm.user.username; //comment label
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
                document.getElementById("comment").setAttribute("readonly", "true");
                // vm.comment.comment="";
            }
        });
    };

    setAverageRating();
    vm.user = $cookies.getObject("user");
    vm.comment = {
        comment: "",
        rating: 1//default rating
    };



});
