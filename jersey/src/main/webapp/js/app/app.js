var appModule = angular.module('app', ['ngRoute']);

function Person()
{
	/*
	var id;
	var name;
	var lastname;
	var age;
	var weight;
	*/
}

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
appModule.controller('DetailController', function($scope, $routeParams, $http, $location){
	
	$scope.person = {};
	$scope.personChanges = {};
	var isNew = true;
	
	function onPersonLoaded(data, status, headers, config){
		angular.extend($scope.personChanges, data);
	}
	
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