/**
 * 
 */
var myAppModule = angular.module('myApp', ['ngRoute']);


// Router Configuration
function routeConfig($routeProvider){
	$routeProvider.
	when('/detail', {
		controller: 'MainController', 
		templateUrl: 'detail.jsp'
	}).
	when('/list', {
		controller: 'MainController', 
		templateUrl: 'list.jsp'
	}).
	otherwise({
		redirectTo: '/list'
	});
}

//Set up Route Configuration
myAppModule.config(routeConfig);

// Main Controller for myAppModule
myAppModule.controller('MainController', function(Persons){
	this.flag = true;
	this.stringarray = ['One', 'Two', 'Three'];
			
	this.submitForm = function(){
		console.log('form.number: '+this.form.number);
		console.log('preventing form submission');
		return false;
	};
	
	this.addOne = function(){
		console.log('before .. '+this.form.number);
		this.form.number++;
		console.log('after .. '+this.form.number);
	};	
		
	// using factory service..
	this.persons = Persons.query();
});

//Module Factory service that returns a list of persons
myAppModule.factory('Persons', function(){
	var persons = {};
	persons.query = function(){
		return [{firstname: 'David', lastname: 'Ontiveros', email: 'dontiveros@gmail.com'},
		        {firstname: 'Juan', lastname: 'Perez', email: 'jperez@gmail.com'},
		        {firstname: 'Pedro', lastname: 'Saenz', email: 'psaenz@gmail.com'}];
	};
	return persons;
});


myAppModule.filter('personalInfo', function(){
	
	var result = function(person){
		return person.firstname +', '+person.lastname+' - email: '+person.email+'';
	};
	return result;
	
});
