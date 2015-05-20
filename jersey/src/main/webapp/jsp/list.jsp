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
.table th.skills{
	text-align: left;
}
.table tbody tr.personRow{
	cursor: pointer;
}
.table tbody tr td.skills{
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
	<table class="table table-striped" ng-controller="PersonListController">
	<thead>
		<tr>
			<th>Person</th>
			<th class="skills">Skills</th>
		</tr>
	</thead>
	<tbody>
		<tr class="personRow" ng-repeat="person in persons | filter: filterText" 
			ng-class="hoverRowClass" ng-mouseenter="hoverRowClass='success'" ng-mouseleave="hoverRowClass=''"
			ng-click="viewProfile(person._id);">
			<td>{{person.lastname +", "+person.name}}<a ng-href="#/profile/{{person.id}}"></a></td>			
			<td class="skills"><h4 ng-bind-html="person | SkillDetailFilter"></h4></td>
		</tr>
	</tbody>
</table>
</div>

