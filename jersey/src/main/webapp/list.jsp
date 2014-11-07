<div ng-controller="ListController">
	  
	<div ng-repeat="person in persons">
		<li> <a ng-href="#/detail/{{person.id}}">{{person.name}}</a></li>
	</div>
		
</div>