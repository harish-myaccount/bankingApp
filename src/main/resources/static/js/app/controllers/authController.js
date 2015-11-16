angular.module('mainApp').controller('authController',['$scope','growl','Authentication',function($scope,growl,Authentication){

	$scope.username='';
	$scope.password='';
	
	$scope.login = function(){
		Authentication.login({username:$scope.username,password:$scope.password}).then(function(response){
			console.log(response);
		});
	}
}]);