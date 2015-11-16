angular.module('mainApp').service('Authentication', function($http){

	this.login=function(credentials){
		return $http.post('/login',credentials);
	}

});