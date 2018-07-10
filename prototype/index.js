var myApp = angular.module('app',[]);

myApp.controller('NavCtrl', function ($scope) {
    $scope.setParmeter = function (parameter) {
        sessionStorage.setItem("item", parameter);
    };
    
})