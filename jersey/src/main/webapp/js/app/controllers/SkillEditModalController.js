/**
 * Created by daviD on 18/05/2015.
 */
angular.module('app').controller('SkillEditModalController', ['$scope', '$http', function($scope, $http){

    $scope.personSkill = personSkill;

    $scope.setLevel = function(level){
        $scope.personSkill.level = level;
        $modalInstance.close(personSkill);
    };

}]);