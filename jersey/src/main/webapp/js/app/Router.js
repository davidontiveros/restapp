/**
 * Created by daviD on 18/05/2015.
 */
// Router Configuration
function routeConfig($routeProvider){
    $routeProvider.
        when('/list', {
            controller: 'ListController',
            templateUrl: 'jsp/list.jsp'
        }).
        when('/profile/:_id', {
            controller: 'DetailController',
            templateUrl: 'jsp/profile.jsp'
        }).
        when('/profile', {
            controller: 'DetailController',
            templateUrl: 'jsp/profile.jsp'
        }).
        otherwise({
            redirectTo: '/list'
        });
}

angular.module('app', ['ngRoute']).config(
    routeConfig()
);
