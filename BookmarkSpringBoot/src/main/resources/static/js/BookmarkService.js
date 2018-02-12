(function(){
	'use strict';
	angular
		.module('app.service',[])
		.factory('BookmarkService',BookmarkService);
		
	function BookmarkService($http){
		const SERVICE_URL = "http://localhost:8081";
		
		var services = {
			getRecentBookmarks : getRecentBookmarks,
			getBookmarkOnType : getBookmarkOnType,
			getBookmarkDetail : getBookmarkDetail,
			addUserBookmark : addUserBookmark
		}
		
		return services;
		/////////////////////////
		
		function getRecentBookmarks(){
			return $http.get(SERVICE_URL+"/book/getAll")
						.then(successCallback)
						.catch(errorCallback);
			
			function successCallback(data){
				return data.data;
			}					
			function errorCallback(error){
				
			}					
		}
		
		function getBookmarkOnType(type){
			return $http.get(SERVICE_URL+"/book/getBookmarkByType/"+type)
						.then(successCallback)
						.catch(errorCallback);
			
			function successCallback(data){
				return data.data;
			}					
			function errorCallback(error){
				
			}	
		}
		
		function getBookmarkDetail(){
			
		}
		function addUserBookmark(){
			
		}
		
	}
	
})();	