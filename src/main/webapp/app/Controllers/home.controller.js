angular.module('app').controller("HomeController", function ($scope,$http, $location,$window) {
    var vm=this;

    $scope.init = function(){

        var i=true;
        $scope.loggedIn = $window.sessionStorage.loggedIn;
        $scope.isAdmin = $window.sessionStorage.isAdmin;
        $scope.username = $window.sessionStorage.username;
    };

    $scope.init();
});
