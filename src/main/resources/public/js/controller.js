var App = angular.module('App', []);

App.controller('PersonListCtrl', function ($scope, $http) {

    function loadPersons() {
        $http
             .get('/v1/person/all')
             .then(function successCallback(response) {
                 $scope.personList = response.data;
             }, function errorCallback(response) {
                 console.log(response.data.message);
             });
    };

    loadPersons();

    $scope.addPerson = function () {
        $http
            .post('/v1/person/create', { 'fullName': $scope.fullName, 'dateOfBirth': $scope.dateOfBirth })
            .then(function successCallback(response) {
                console.log(response);
                loadPersons();
            }, function errorCallback(response) {
                console.log(response);
                alert(response.data.message);
            });
    };
});