/**
 * Created by Oisín on 3/29/2017.
 */
angular.module('app').controller("AppController", function ($scope, $http, $location, $window, UserState) {
    var vm=this;
    vm.itemCount=0;

    UserState.subscribe(function (notification) {
        vm.loggedIn =notification;
        $window.sessionStorage.loggedIn =notification;
        vm.isAdmin = $window.sessionStorage.isAdmin;
        vm.username = $window.sessionStorage.username;
    });

    vm.logout=function(){
        //trigger subject to notify subscribers to carry out any last minute changes before logout
        $location.path("/")
        UserState.notify(false);
    }



});
