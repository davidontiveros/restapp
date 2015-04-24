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
        <!--
        <div class="btn-group">
          <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
            Java <span class="caret"></span>
          </button>
          <ul class="dropdown-menu small" role="menu">
            <li><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove-circle"></span></a></li>
          </ul>
        </div>
        -->

        <!-- THIS -->
          <div class="btn-group" ng-repeat="personSkill in personChanges.personSkills" style="padding-right: 10px;">
              <button type="button" class="btn" data-toggle="modal"
                      ng-class="{'btn-warning': personSkill.level===1, 'btn-info': personSkill.level===2, 'btn-success': personSkill.level===3} "
                      ng-click="editSkill(personSkill);">
                <b>{{personSkill.skill.name }}</b>
              </button>
            <!--
              <button type="button" class="btn btn-danger dropdown-toggle" aria-expanded="false">
                <span class="glyphicon glyphicon-remove-circle"></span>
              </button>
              -->
          </div>
            <!--
            <button type="button" class="btn btn-success dropdown-toggle" aria-expanded="false">
              <span class="glyphicon glyphicon-remove-circle"></span>
            </button>

            <button type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </button>
            -->
        <!--
        <div class="btn-group">
          <button type="button" class="btn btn-info">PHP</button>
        </div>

        <div class="btn-group">
          <button type="button" class="btn btn-warning">.Net</button>
        </div>
        -->

    </div>
  </div>

  <button ng-click="save()" class="btn btn-sm btn-primary">Save</button>
</form>


    <!-- Modal to edit -->
    <div class="modal fade" id="editSkillModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <label>select level of knowledge for <u>{{personSkillChanges.skill.name}}</u></label>
          </div>
          <div class="modal-body">
            <!--{{personSkillChanges.level}}-->
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">Low</button>
                  </div>
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">Medium</button>
                  </div>
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">High</button>
                  </div>
                </div>
          </div>
          <!--
          <div class="modal-footer" style="text-align: left;">
            <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Cancel</button>
            <button type="button" class="btn btn-sm btn-primary">Save</button>
            <button type="button" class="btn btn-sm btn-danger">Delete</button>
          </div>
          -->
        </div>
      </div>
    </div>


</div>