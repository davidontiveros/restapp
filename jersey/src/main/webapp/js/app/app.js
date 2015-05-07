var appModule = angular.module('app', ['ngRoute', 'ui.bootstrap'] );

// Router Configuration
function routeConfig($routeProvider){
	$routeProvider.
	when('/list', {
		controller: 'ListController', 
		templateUrl: 'jsp/list.jsp'
	}).
	when('/profile/:_id', {
		controller: 'DetailController', 
		templateUrl: 'jsp/profile.jsp'
	}).
	when('/profile', {
		controller: 'DetailController', 
		templateUrl: 'jsp/profile.jsp'
	}).
	otherwise({
		redirectTo: '/list'
	});
}

//Set up Route Configuration
appModule.config(routeConfig);

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
	
	function onPersonLoaded(data, status, headers, config){
		angular.extend($scope.personChanges, data);

		$scope.availableSkills = [
			{ _id: "01", name: "PHP"},
			{ _id: "02", name: "Java"},
			{ _id: "03", name: ".Net"},
			{ _id: "04", name: "AngularJS"},
			{ _id: "05", name: "NodeJS"},
			{ _id: "06", name: "C++"},
			{ _id: "07", name: "C#"},
			{ _id: "08", name: "Design Patterns"},
			{ _id: "09", name: "Android"},
			{ _id: "10", name: "SQL"},
		];

		// add dummy skills by the moment ..
		var skillPHP = {
			"level" : 1,
			"skill" :
			{
				"_id" : "01",
				"name" : "PHP"
			}
		};
		var skillJava = {
			"level" : 3,
			"skill" :
			{
				"_id" : "02",
				"name" : "Java"
			}
		};
		var skillNet = {
			"level" : 2,
			"skill" :
			{
				"_id" : "03",
				"name" : ".Net"
			}
		};
		var dummySkills = [skillPHP, skillJava, skillNet];
		//$scope.personChanges.personSkills = dummySkills;
		$scope.personChanges.personSkills = [];
		//console.log($scope.personChanges);
		//$scope.personSkills = dummySkills;
	}

	$scope.onSelectedSkill = function (model){
		console.log(model);
		var newPersonSkill = {level: -1, skill: model};
		$scope.skillSelector = '';
		$scope.personChanges.personSkills.push(newPersonSkill);
	};

	function redirectToList(){
		$location.path("/list")
	}
	
	$scope.test = function(){
		console.log($scope.personChanges);
		angular.extend($scope.person, $scope.personChanges);
		console.log($scope.person);
		//$http.post('rest/testService/', {dbname:"david"});
		//$http.post('rest/personService/postPerson', $scope.person);
	};

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
		/*
		console.log('personSkill '+personSkill.skill.name);
		$scope.personSkillChanges = {};
		angular.extend($scope.personSkillChanges, personSkill);
		console.log('personSkillChanges '+$scope.personSkillChanges.skill.name);
		$('#editSkillModal').modal();
		*/
	};
	
	$scope.save = function(){
		if(isNew){
		}
		else{
		}		
		angular.extend($scope.person, $scope.personChanges);
		console.log($scope.person);
		//$http.post('rest/personService/postPerson', $scope.person).success(redirectToList);
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