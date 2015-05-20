/**
 * Created by daviD on 18/05/2015.
 */

var PersonDetailController = function($scope, $http, $routeParams, $location, $modal, personService, skillService){

    $scope.isCollapsed = true;

    $scope.person = {};
    $scope.personChanges = {};
    var isNew = true;

    $scope.availableSkills = [];

    function onSkillsLoaded(data){
        console.log(data);
        $scope.availableSkills = data;
    }

    function onPersonLoaded(data, status, headers, config){
        angular.extend($scope.personChanges, data);
        skillService.getSkills(onSkillsLoaded);
    }

    $scope.onSkillSelected = function (model){
        var newPersonSkill = {level: -1, skill: model};
        $scope.skillSelector = '';
        $scope.personChanges.personSkills.push(newPersonSkill);
    };

    function redirectToList(){
        $location.path("/list")
    }

    $scope.editSkill = function(personSkill){

        var modalInstance = $modal.open({
            templateUrl: 'editSkillModal.html',
            controller: 'SkillEditModalController',
            resolve: {
                personSkill: function(){
                    return personSkill;
                },
                modalInstance: function(){
                    return modalInstance;
                }
            }
        });
        // on close do something?
        modalInstance.result.then(function (personSkill) {
        });
    };

    $scope.save = function(){
        if(isNew){
        }
        else{
        }
        angular.extend($scope.person, $scope.personChanges);
        console.log($scope.person);
        personService.savePerson($scope.person, redirectToList);
    }

    if($routeParams._id){
        isNew = false;
        personService.getPerson($routeParams._id, onPersonLoaded);
    }
}

angular.module('app').controller('PersonDetailController',
    ['$scope', '$http', '$routeParams', '$location', '$modal', 'personService', 'skillService', PersonDetailController]);