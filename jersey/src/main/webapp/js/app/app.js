var appModule = angular.module('app', ['ngRoute']);

function Person()
{
	var id;
	var name;
	var lastname;
	var age;
	var weight;
}

// Router Configuration
function routeConfig($routeProvider){
	$routeProvider.
	when('/list', {
		controller: 'ListController', 
		templateUrl: 'list.jsp'
	}).
	when('/detail/:id', {
		controller: 'DetailController', 
		templateUrl: 'detail.jsp'
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

// Detail Controller
appModule.controller('DetailController', function($scope, $routeParams, $http){	
	function onSuccess(data, status, headers, config){
		$scope.person = angular.extend(new Person(), data);
	}
	$http.get('rest/personService/getPerson/'+$routeParams.id).success(onSuccess);
});