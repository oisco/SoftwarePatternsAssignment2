/**
 * Created by Oisín on 3/29/2017.
 */
angular.module('app').controller("AppController", function ($scope, $http, $location, $cookies, UserState) {
    var vm=this;
    vm.itemCount=0;
    vm.user = $cookies.getObject("user");
    // debugger;

    UserState.subscribe(function (notification) {
        //hide navbar
        vm.loggedIn =notification;
        vm.user.loggedIn = vm.loggedIn;
        //update user login status
        $cookies.putObject("user", vm.user);
    });

    vm.logout=function(){
        //trigger subject to notify subscribers to carry out any last minute changes before logout
        $location.path("/");
        UserState.notify(false);
    }



});
