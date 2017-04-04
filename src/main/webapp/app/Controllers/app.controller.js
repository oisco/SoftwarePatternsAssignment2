/**
 * Created by Oisín on 3/29/2017.
 */
angular.module('app').controller("AppController", function ($scope, $http, $location, $window, User) {

    var vm=this;

    $scope.$on('$locationChangeStart', function(event) {
        console.log("APP CONTROLLER IS ALIVE", event);

        //change to cookies maybe try and change to observer
        vm.loggedIn ="true"=== $window.sessionStorage.loggedIn;
        vm.isAdmin = $window.sessionStorage.isAdmin;
        vm.username = $window.sessionStorage.username; // angular watchers
    });

});
