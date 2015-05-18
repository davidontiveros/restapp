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

    <div class="form-group">
      <label>Skills</label>
      <input type="text" ng-model="skillSelector" typeahead="skill as skill.name for skill in availableSkills | filter:$viewValue"
             typeahead-on-select="onSkillSelected($model, $label)" class="form-control" placeholder="type to search for a skill">
    </div>
    <div class="panel panel-default">
      <div class="panel-body well" style="margin: 0px;">
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
                      ng-class="{'btn-default': personSkill.level===-1, 'btn-warning': personSkill.level===1, 'btn-info': personSkill.level===2, 'btn-success': personSkill.level===3} "
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


        <button class="btn btn-default" ng-click="isCollapsed = !isCollapsed">Toggle collapse</button>
        <div collapse="isCollapsed">
          <div class="well well-lg">Some content</div>
        </div>
        -->
    </div>
  </div>

  <button ng-click="save()" class="btn btn-sm btn-primary">Save</button>
</form>

  <!-- Modal to edit -->

    <script type="text/ng-template" id="editSkillModal.html">
      <div class="modal-header">
        <label>Select level of knowledge for <u>{{personSkill.skill.name}}</u></label>
      </div>
      <div class="modal-body" style="padding-bottom: 40px; padding-top: 30px;">
        <!--{{personSkillChanges.level}}-->
        <div class="btn-group btn-group-justified" role="group">
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-warning" ng-click="setLevel(1)">Low</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-info" ng-click="setLevel(2)">Medium</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-success" ng-click="setLevel(3)">High</button>
          </div>
        </div>
      </div>
    </script>

    <!--
    <div class="modal-footer" style="text-align: left;">
      <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Cancel</button>
      <button type="button" class="btn btn-sm btn-primary">Save</button>
      <button type="button" class="btn btn-sm btn-danger">Delete</button>
    </div>
    -->


</div>