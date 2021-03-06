(function(){
	'use strict';
	angular
		.module('starter.controllers')
		.controller('BookmarkListCtrl',BookmarkListCtrl);
	
	function BookmarkListCtrl($scope, BookmarkService, UserService, $ionicModal,$stateParams){
		$scope.list = {}
		$scope.list.bookmarkList = [];
		activate();
		
		function activate(){
			console.log($stateParams);
			getBookmarkListData();
		}
		
		function getBookmarkListData(){
			var type = $stateParams.bookmarkType;
			$scope.list.type = type;
			BookmarkService.getBookmarkOnType(type).then(function(data){
				console.log(data);
				$scope.list.bookmarkList = data;
				console.log(UserService.getUserSession());
				$scope.list.sessionData = UserService.getUserSession();	
			});
		}
	}	
	
})();