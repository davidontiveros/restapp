<!DOCTYPE html>
<html lang="en" ng-app='app'>
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 	
 	<link   href="css/styles.css" rel="stylesheet" type="text/css"/>   
    
    <script src="js/libs/angular.min.js.map"></script>	
	<script src="js/libs/angular.min.js"></script>
	<script src="js/libs/angular-route.js"></script>
	
	<script src="js/app/app.js"></script>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/libs/jquery-1.10.2.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
    <title>app demo</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

	<!-- menu here -->
	<div ng-include="'jsp/navbar.jsp'">

	<div class="container">

	<style>
		.starter-template{
			padding-top: 10px;
		}
	</style>
      <div class="starter-template">
        <!--  <p class="lead">bootstrap + angular.js + jersey example</p> -->
        
        <!-- here is were all html template are injected by angular router -->
        <div ng-view></div>
        
      </div>

    </div>
    
  </body>
</html>
