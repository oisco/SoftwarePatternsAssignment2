angular.module('app').controller("RegisterController", function ($scope,$http, $location,User) {

    var vm=this;

    vm.username = "";
    vm.password = "";
    vm.password2="";

    vm.Register = function () {
        if(passwordMatches()){
            var url="";
            if(vm.isAdmin){
                url="/user/admin/add"

            }
            else {
                url="/user/customer/add"
            }

            var user=new User(vm.username,vm.password);
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
        if(vm.password===vm.password2)
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
