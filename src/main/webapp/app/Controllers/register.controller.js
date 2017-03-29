angular.module('app').controller("RegisterController", function ($scope,$http, $location,User) {

    var vm=this;

    // var username;
    // var password;

    vm.Register = function () {
        if(passwordMatches()){
            this.username=document.getElementById("username").value;
            this.password=document.getElementById("password").value;
            var url="";
            if(document.getElementById("isAdmin").checked){
                url="/user/admin/add"

            }
            else {
                url="/user/customer/add"
            }

            var user=new User(this.username,this.password);

            $http({
                method: 'POST',
                url: url,
                data: user,
                headers: {'Content-Type': 'application/json'}
            });

            alert("User created");
            goToLogin();
        }
    };

    //check to see if username is taken aand both passwords fields match
     passwordMatches=function() {
        if(document.getElementById("password").value==document.getElementById("password2").value)
        {
            return true;
        }else {
            alert("Please ensure both passwords match")
            return false;
        }
    }

    goToLogin = function () {
        $location.path("/");
    };


});
