'use strict';

angular.module('myApp').factory('UserService',['$http','$q',function($http,$q){
	 
	var uri="http://localhost:9292/login";
	var factory={
			
			loginSubmitForm:loginSubmitForm
	
	}
	return factory;
	
	function loginSubmitForm(){
		console.log('UserService->loginSubmitForm');
		var defer=$q.defer();
		$http.get(uri).then(function(response){
			console.log('UserService->loginSubmitForm->response success')
			defer.resolve(response.data);
		},function(errResponse){
			console.error('error ');
			defer.reject(errResponse);
		}
		);
		return defer.promise;
		
	}
	
}]);