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
	when('/profile/:id', {
		controller: 'DetailController', 
		templateUrl: '/jsp/profile.jsp'
	}).
	otherwise({
		redirectTo: '/list'
	});
}

//Set up Route Configuration
appModule.config(routeConfig);

//List Controller
appModule.controller('ListController', function($scope, $http){
	$scope.persons = [];
	function onSuccess(data, status, headers, config){
		$scope.persons = data;
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
appModule.controller('DetailController', function($scope, $routeParams, $http){	
	function onSuccess(data, status, headers, config){
		$scope.person = angular.extend(new Person(), data);
	}
	$http.get('rest/personService/getPerson/'+$routeParams.id).success(onSuccess);
});