/**
 * Created by daviD on 20/05/2015.
 */

var SkillService = function ($http){
    var service = {};

    service.getSkills = function (callback) {
        $http.get('rest/skillService/getSkills/').success(callback);
    }

    return service;
}

angular.module('app').factory('skillService',['$http', SkillService ]);
