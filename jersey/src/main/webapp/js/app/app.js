/**
 * Created by daviD on 18/05/2015.
 */
angular.module('app', ['ngRoute', 'ui.bootstrap']).config(

	function ($routeProvider) {
		$routeProvider.
			when('/list', {
				controller: 'PersonListController',
				templateUrl: 'jsp/list.jsp'
			}).
			when('/profile/:_id', {
				controller: 'PersonDetailController',
				templateUrl: 'jsp/profile.jsp'
			}).
			when('/profile', {
				controller: 'PersonDetailController',
				templateUrl: 'jsp/profile.jsp'
			}).
			otherwise({
				redirectTo: '/list'
			});
	}
);