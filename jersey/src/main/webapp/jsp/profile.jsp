<div ng-controller="DetailController">

  <form>
    <div class="form-group">
      <label>Name</label>
      <input ng-model="personChanges.name" type="text" class="form-control" placeholder="Enter name"/>
    </div>
    <div class="form-group">
      <label>Lastname</label>
      <input ng-model="personChanges.lastname" type="text" class="form-control" placeholder="Enter lastname"/>
    </div>

    <label>Skills</label>
    <div class="panel panel-default">
      <div class="panel-body">

        <div class="btn-group">
          <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
            Java <span class="caret"></span>
          </button>
          <ul class="dropdown-menu small" role="menu">
            <li><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove-circle"></span></a></li>
          </ul>
        </div>

        <!-- THIS -->
          <div class="btn-group">
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Java</button>
            <button type="button" class="btn btn-danger dropdown-toggle" aria-expanded="false">
              <span class="glyphicon glyphicon-remove-circle"></span>
            </button>


            <!--
            <button type="button" class="btn btn-success dropdown-toggle" aria-expanded="false">
              <span class="glyphicon glyphicon-remove-circle"></span>
            </button>

            <button type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </button>
            -->

          </div>

          <div class="btn-group">
            <button type="button" class="btn btn-info">PHP</button>
          </div>

          <div class="btn-group">
            <button type="button" class="btn btn-warning">.Net</button>
          </div>

      </div>

    </div>

    <button ng-click="save()" class="btn btn-default">Save</button>
  </form>

</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        Modal title
      </div>
      <div class="modal-body">
        Modal Body
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>