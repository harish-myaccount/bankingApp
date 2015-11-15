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

	$stateProvider.state('index', {
		url : '/',
		template : "public-tmpl.html"
	});

	// HOME STATES AND NESTED VIEWS ========================================

});
