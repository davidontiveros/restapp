/**
 * Created by daviD on 18/05/2015.
 */

/*
angular.module('myApp.controllers').controller('Ctrlr1', ['$scope', '$http', function($scope, $http){

}]);
*/
var PersonListController = function($scope, $location, personService) {

    $scope.persons = [];

    function onSuccess(data) {
        $scope.persons = data;
    }

    $scope.viewProfile = function (_id) {
        console.log(_id);
        $location.path("/profile/" + _id);
    }

    personService.getPersons(onSuccess);
}

angular.module('app').controller('PersonListController', ['$scope', '$location', 'personService', PersonListController]);

/*
angular.module('app').controller('PersonListController', ['$scope', '$http', function($scope, $http){

    $scope.persons = [];

    function onSuccess(data, status, headers, config){
        $scope.persons = data;
    }

    $scope.viewProfile = function(_id){
        console.log(_id);
        $location.path("/profile/"+_id);
    }

}]);
*/