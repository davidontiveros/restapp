/**
 * Created by daviD on 18/05/2015.
 */
angular.module('app').controller('PersonDetailController',
    ['$scope', '$http', '$routeParams', '$location', '$modal', function($scope, $http, $routeParams, $location, $modal){

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
            $http.get('rest/skillService/getSkills/').success(onSkillsLoaded);
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
                controller: 'ModalInstanceController',
                resolve: {
                    personSkill: function(){
                        return personSkill;
                    }
                }
            });
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
            $http.post('rest/personService/postPerson', $scope.person).success(redirectToList);
        }

        if($routeParams._id){
            isNew = false;
            $http.get('rest/personService/getPerson/'+$routeParams._id).success(onPersonLoaded);
        }
}]);