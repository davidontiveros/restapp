<div ng-controller="DetailController">

<form>
  <div class="form-group">
    <label>Name</label>
    <input ng-model="personChanges.name" type="text" class="form-control" placeholder="Enter name">
  </div>
  <div class="form-group">
    <label>Lastname</label>
    <input ng-model="personChanges.lastname" type="text" class="form-control" placeholder="Enter lastname">
  </div>
  <button ng-click="save()" class="btn btn-default">Save</button>
</form>