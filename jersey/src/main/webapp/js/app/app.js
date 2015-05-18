/**
 * Created by daviD on 18/05/2015.
 */
angular.module('app', ['ngRoute', 'ui.bootstrap'] );

//List Controller
appModule.controller('ListController', function($scope, $http, $location){
	$scope.persons = [];
	
	function onSuccess(data, status, headers, config){
		$scope.persons = data;
	}
	
	$scope.viewProfile = function(_id){
		console.log(_id);
		$location.path("/profile/"+_id);
	}
	
	$http.get('rest/personService/getPersons').success(onSuccess);
});

appModule.filter('skillInfo', ['$sce', function($sce){
	var result = function(person){
		var output = '';
		angular.forEach(person.personSkills, function(personSkill) {
			var html;
			// LOW
			if(personSkill.level === 1){
				html = '<span class="label label-default">'+personSkill.skill.name+'</span> ';
			}
			// MEDIUM
			if(personSkill.level === 2){
				html = '<span class="label label-primary">'+personSkill.skill.name+'</span> ';
			}
			// HIGH
			if(personSkill.level === 3){
				html = '<span class="label label-success">'+personSkill.skill.name+'</span> ';
			}
			output += html;
		});
		return $sce.trustAsHtml(output);
	};
	return result;
}]);

// Detail Controller
appModule.controller('DetailController', function($scope, $routeParams, $http, $location, $modal){

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
});

appModule.controller('ModalInstanceController', function ($scope, $modalInstance, personSkill){

	$scope.personSkill = personSkill;

	$scope.setLevel = function(level){
		$scope.personSkill.level = level;
		$modalInstance.close(personSkill);
	};

});