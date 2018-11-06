var app = angular.module('myApp', []);

app.directive('myDirective', function(httpPostFactory) {
  return {
    restrict: 'A',
    link: function(scope, element, attr) {
      element.bind('change', function() {
        var formData = new FormData();
        formData.append('file', element[0].files[0]);

        // optional front-end logging
        var fileObject = element[0].files[0];
        scope.fileLog = {
          'lastModified': fileObject.lastModified,
          'lastModifiedDate': fileObject.lastModifiedDate,
          'name': fileObject.name,
          'size': fileObject.size,
          'type': fileObject.type
        };
        scope.$apply();

        httpPostFactory('rest/v1/file/path/' + fileObject.name, formData, function (callback) {
            console.log(callback);
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
    }).success(function(response) {
      callback(response);
    });
  };
});