/**
 * Created by daviD on 20/05/2015.
 */

var PersonService = function ($http){
        var service = {};

        service.getPersons = function (callback) {
            $http.get('rest/personService/getPersons').success(callback);
        }

        service.getPerson = function (id, callback) {
            $http.get('rest/personService/getPerson/'+id).success(callback);
        }

        service.savePerson = function (person, callback){
            $http.post('rest/personService/postPerson', person).success(callback);
        }

        return service;
}

angular.module('app').factory('personService',['$http', PersonService ]);
