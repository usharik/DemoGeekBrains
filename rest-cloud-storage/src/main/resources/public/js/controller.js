var app = angular.module('myApp', []);

app.directive('myDirective', function(httpPostFactory) {
  return {
    restrict: 'A',
    link: function(scope, element, attr) {
      element.bind('change', function() {
        var formData = new FormData();
        formData.append('file', element[0].files[0]);
        var fileObject = element[0].files[0];
        httpPostFactory('rest/v1/file/path/' + fileObject.name, formData, function (callback) {
            console.log(callback);
            scope.$root.$broadcast("newFile", "");
        });
      });
    }
  };
});

app.factory('httpPostFactory', function($http) {
  return function(file, data, callback) {
    $http({
      url: file,
      method: "POST",
      data: data,
      headers: {
        'Content-Type': 'application/octet-stream'
      }
    }).then(function(response) {
      callback(response);
    });
  };
});

app.controller('FileList', function ($scope, $rootScope, $http) {

    function loadFiles() {
        $http
            .get('/rest/v1/file/all')
            .then(function successCallback(response) {
                $scope.files = response.data;
                $scope.files.forEach(function(file) {
                    file.fileUrl = "/rest/v1/file/path/" + encodeURI(file.fileName);
                });
            }, function errorCallback(response) {
                console.log(response);
            });
    }

    loadFiles();

    $rootScope.$on("newFile", loadFiles);
});