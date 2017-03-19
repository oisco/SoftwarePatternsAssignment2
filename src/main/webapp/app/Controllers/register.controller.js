angular.module('app').controller("RegisterController", function ($scope,$http, $location) {

    var vm=this;
    // var username;
    // var password;

    vm.Register = function () {
    this.username=document.getElementById("username").value;
    this.password=document.getElementById("password").value;
        var user=new User(this.username,this.password);

        $http({
            method: 'POST',
            url: '/user/add',
            data: user,
            headers: {'Content-Type': 'application/json'}
        });

        alert("User created");
        goToLogin();
    };

    goToLogin = function () {
        $location.path("/");
    };
    var User =  function(username , password) {
        this.username = username;  this.password =  password;
    }

});
