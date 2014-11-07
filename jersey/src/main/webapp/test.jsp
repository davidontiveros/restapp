<!DOCTYPE html>
<html ng-app='myApp' >

<head>
	<script src="js/libs/angular.min.js.map"></script>	
	<script src="js/libs/angular.min.js"></script>
	<script src="js/libs/angular-route.js"></script>
	
	<script src="js/app/app.js"></script>
	<link   href="css/styles.css" rel="stylesheet" type="text/css"/>
	
	<title>Angular + Jersey restapp</title>	
</head>

<body>
    <h1>Angular JS</h1>
    
    <h3>-Main Controller-</h3>
	<div ng-controller="MainController as main">	
			
		<b>Iteration:</b>
		<div ng-repeat="string in main.stringarray">
			<li>{{string}} -- <i>is first? {{$first}}, is middle? {{$middle}}, is last? {{$last}}</i></li>
		</div>
		
		<br><hr>		
		<b>Input (data binding): </b>
		<br><input type="text" ng-model="main.inputText"/>
		<br>->{{main.inputText}}
		
		<br><hr>
		<b>Form submit: </b>
		<form ng-submit="main.submitForm()">
			<input type="number" ng-model="main.form.number" ng-change="main.addOne()"/>
			<input type="submit"/>
		</form>
		
		<br><hr>
		<div ng-class="{green: main.flag}">
			<b>Show/Hide, CSS Class:</b>
			<br>
			<input type="checkbox" ng-model="main.flag"  />
			<br>
			<i ng-show="main.flag">Flag turned on</i>
		</div>
		
		
		<br><hr>
		<b>using Custom Factory service + using Custom Filter </b>
		
		<div ng-repeat="person in main.persons">
			{{person | personalInfo}}   
		</div>
		
		<br><hr>
		Ng View (Router)
		<div ng-view>
		</div>
	</div>
	
</body>

</html>