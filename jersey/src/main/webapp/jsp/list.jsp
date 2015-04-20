<style>
.table-container{
	padding-top: 10px;
}
.table{	
	
}
.table tbody tr td{
	text-align: center;
}
.table th{
	text-align: center;
}
.table tbody tr td.skills{
	text-align: left;
}
.table th.skills{
	text-align: left;
}
h2{
 padding-bottom: 10px;
}

.label{

}
</style>

<h2 class="text-left">List</h2>

<div class="col-lg-8 text-left form-group">
	<input class="form-control" placeholder="search text" ng-model="filterText">
</div>

<div class="col-lg-8 table-container">
	<table class="table table-striped" ng-controller="ListController">
	<thead>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th class="skills">Skills</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="person in persons | filter: filterText">
			<td>{{person.id}}<a ng-href="#/profile/{{person.id}}"></a></td>
			<td>{{person.name}}<a ng-href="#/profile/{{person.id}}"></a></td>
			<td class="skills"><h4 ng-bind-html="person | skillInfo"></h4></td>
		</tr>
	</tbody>
</table>
</div>

