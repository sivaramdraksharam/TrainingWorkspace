(function(){
	'use strict';
	
	angular
		.module('app.model',[])
		.factory('UserService',UserService);
		
	function UserService($http){
		const SERVICE_URL = "http://localhost:8080/bookmark";
		
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
			authenticateUser : authenticateUser,
			getUserBookmark: getUserBookmark,
			markKidFriendly : markKidFriendly
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
		
		function getUserBookmark(){
			var userId = sessionModel.id;
			console.log(sessionModel);
			
				return $http.get(SERVICE_URL+"/user/getUserBookmark/"+userId)
				.then(successCallback)
				.catch(errorCallback);

				function successCallback(data){
					console.log(data);
					return data.data;
				}					
				function errorCallback(error){
	
				}			
		}
		function markKidFriendly(bookmarkId){
			var userId = sessionModel.id;
			var requestObj = {
					userId : userId.toString(),
					bookmarkId : bookmarkId.toString()
				}
			console.log(requestObj);
				
			return $http({
					method : 'POST',
					url : SERVICE_URL+'/user/setKidFriendlyStatus',
					headers: {
						"content-type": "application/json"
					},	
					data : JSON.stringify(requestObj)
				}).then(function(data){
					console.log("data",data);
					return data.data;
				})
		}
		
	}	
})();