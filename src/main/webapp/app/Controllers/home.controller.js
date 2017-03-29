angular.module('app').controller("HomeController", function ($scope,$http, $location,User) {

    var vm=this;


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
            debugger;
            if(data==""){
                alert("Incorrect username/password");
            }
            else {
                //set the user here
                //check here if user is cust or admin and update the top tabs to reflect
                $location.path("CustHome");
                debugger;
            }

        }).error(function () {

        })
        ;
    }

    vm.goToRegister = function () {
        $location.path("Register");
    };
});
