angular.module('app').controller("LoginController", function ($route, $scope, $window, $http, $location, User, UserState, $cookies) {

    var vm=this;
    // vm.loggedIn=false;
    // $window.sessionStorage.loggedIn=false;
    // $window.sessionStorage.isAdmin=false;
    // $cookies.put("loggedIn",true);



    vm.login=function() {
        var url = "/user/login";

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
                data;
                $location.path("Home");

                var isAdmin = false;
                if(data.userType=="Administrator"){
                    isAdmin = true;
                }
                var userDetails = {
                    userId: data.id,
                    isAdmin: isAdmin,
                    loggedIn: true,
                    username: data.username
                };

                $cookies.putObject("user", userDetails);
                debugger;

                //trigger observer
                UserState.notify(true);
            }

        }).error(function () {

        })
        ;
    };

    vm.goToRegister = function () {
        $location.path("Register");
    };
});
