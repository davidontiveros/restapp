/**
 * Created by daviD on 18/05/2015.
 */

var SkillEditModalController = function($scope, personSkill, $modalInstance){

    $scope.personSkill = personSkill;

    $scope.setLevel = function(level){
        $scope.personSkill.level = level;
        $modalInstance.close();
    };

}

angular.module('app').controller('SkillEditModalController', ['$scope','personSkill', '$modalInstance', SkillEditModalController]);