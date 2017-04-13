/**
 * Created by Oisín on 3/29/2017.
 */
angular.module('app').controller("AppController", function ($scope, $http, $location, $cookies, UserState, $cookieStore) {
    var vm=this;
    vm.itemCount=0;
    vm.user = $cookies.getObject("user");
    // debugger;

    UserState.subscribe(function (notification) {
        //set the current user;
        vm.user = $cookies.getObject("user");

        //the above will cause the navbar to be displayed if the current user stored in the cookies is not null
        debugger;
    });

    vm.logout=function(){
        //trigger subject to notify subscribers to carry out any last minute changes before logout
        $location.path("/");
        $cookieStore.remove("user");
        UserState.notify(false);
    }



});
