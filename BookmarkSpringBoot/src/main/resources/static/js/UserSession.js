(function(){
	'use strict';
	
	angular
		.module('app.model',[])
		.factory('UserService',UserService);
		
	function UserService($http){
		const SERVICE_URL = "http://localhost:8081";
		
		var sessionModel ={
			sessionAlive: false,
			firstName : "",
			lastName : "",
			gender : "",
			email : "",
			userType : "",
			id : 0
		}
		
		var service = {
			getUserSession : getUserSession,
			setUserSession : setUserSession,
			authenticateUser : authenticateUser
		}
		
		return service;
		////////
		function getUserSession(){
			return sessionModel;
		}
		
		function setUserSession(sessionObj){
			sessionModel = sessionObj;
		}
		
		function authenticateUser(userId,password){
			var requestObj = {
				id :userId,
				password:password 
			}
			console.log(requestObj);
			
			return $http({
				method : 'POST',
				url : SERVICE_URL+'/user/validateUser',
				headers: {
					"content-type": "application/json"
				},	
				data : JSON.stringify(requestObj)
			}).then(function(data){
				console.log("data",data);
				if(data.data.validFlag){
					var userObj = data.data.userDetail;	
					userObj.sessionAlive = true;
					setUserSession(userObj);
				}	
				return data.data;
			})
		}
		
	}	
})();