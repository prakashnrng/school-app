'use strict';

angular.module('myApp').controller('UserController',['$scope','UserService',function($scope,UserService){
	
	var self=this;
	self.user={ssoId:'',password:'',rememberme:''};
	self.users=[];
	
	self.submit=submit;
	
	function submit(){
		if(self.user.id==null){
			console.log('saving new user',self.user);
			UserService.loginSubmitForm().then(
					function(response){
						console.log('SUCCESS');
						//window.location.href="http://localhost:8081/springmvcsecurity/userslist1";
				
			},function(errResponse){
				console.error('error in controller');
				alert('error in controller');
				
			}		
			);
				
			}
			//createUser(self.user);
		}
	
	
}]);