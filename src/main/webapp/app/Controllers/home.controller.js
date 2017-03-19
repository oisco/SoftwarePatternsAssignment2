angular.module('app').controller("HomeController", function ($scope,$http, $location) {

    var vm=this;

    // var url="/user/login"
    // var eventsPromise=$http.get(url);
    // eventsPromise.then(function (response) {
    //     vm.events=response.data;
    //
    // })

    vm.goToRegister = function () {
        $location.path("Register");
    };
});
