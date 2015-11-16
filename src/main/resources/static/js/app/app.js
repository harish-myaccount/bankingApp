/**
 * angular main page
 * 
 */

var mainApp = angular.module('mainApp', [ 'ui.router', '720kb.datepicker',  'angular-growl', 'ui.grid', 'angular-loading-bar',
		'ui.grid.exporter', 'ui.grid.edit', 'ui.grid.resizeColumns', 'ui.grid.selection',  'ngDialog', 'ngUnderscore',
		'ui.grid.expandable' ]);

mainApp.config(function($stateProvider, $urlRouterProvider, ngDialogProvider) {

	ngDialogProvider.setDefaults({
		className : 'ngdialog-theme-default',
		showClose : true,
		closeByDocument : true,
		closeByEscape : true
	});

	$urlRouterProvider.otherwise('/');

	var root = $stateProvider.state('app', {
		url : '/',
		template:'<div ui-view />'
	});
	// HOME STATES AND NESTED VIEWS ========================================


	root.state('app.user',{
		url:'user',
		template:'<div ui-view></div>'
	}).state('app.user.accounts',{
		url:'/accounts',
		template:"public-tmpl.html"
	});

});


mainApp.run(['$rootScope', '$state', 'Authentication', function($rootScope, $state, Authentication) {
  $rootScope.$on('$stateChangeStart', function(e, to) {
    var role;
   

    });
  
}]);
