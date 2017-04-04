angular.module('app').controller("LoginController", function ($route, $scope,$window,$http, $location,User) {

    var vm=this;
    vm.loggedIn=false;
    $window.sessionStorage.loggedIn=false;
    $window.sessionStorage.isAdmin=false;

    vm.login=function() {
        var url="/user/login"

        this.username=document.getElementById("username").value;
        this.password=document.getElementById("password").value;
        var user=new User(this.username,this.password);
        $http({
            method: 'POST',
            url: url,
            data: user,
            headers: {'Content-Type': 'application/json'}
        }).success(function(data){
            if(data==""){
                alert("Incorrect username/password");
            }
            else {
                //set the user here
                data
                $location.path("Home");
                $window.sessionStorage.loggedIn=true;
                //check here if user is cust or admin and update the top tabs to reflect
                if(data.userType=="Administrator"){
                    $window.sessionStorage.isAdmin=true;
                }
                $window.sessionStorage.username=data.username;
                $window.sessionStorage.userId=data.id;
            }

        }).error(function () {

        })
        ;
    }

    vm.goToRegister = function () {
        $location.path("Register");
    };
});
