(function(){
	'use strict';
	angular
		.module('starter.controllers')
		.controller('HomeController',HomeController);
	
	function HomeController($scope, BookmarkService, UserService, $ionicModal, $state){
		$scope.dashData = {}
		$scope.loginData = {}
		$scope.loginData.errorMsg = '';
		$scope.session = {}
		$scope.session.isAlive = false;
		var proceedtoBookmark = false;
		activate();
		
		//////////////////////////
		
		function activate(){
			console.log("Home Controller");
			// Create the login modal that we will use later
			$ionicModal.fromTemplateUrl('templates/login.html', {
				scope: $scope
			}).then(function(modal) {
				$scope.modal = modal;
			});
			getDashBoardData();	
		}
		
		
		function getDashBoardData(){
			BookmarkService.getRecentBookmarks().then(function(data){
				console.log(data);
				$scope.dashData.books = data.books;	
				$scope.dashData.movies = data.movies;	
				$scope.dashData.weblinks = data.weblinks;
					
			});
		}
		
		$scope.saveBookmark = function(id){
			console.log("Bookmarked item "+id);
			console.log("session ",UserService.getUserSession());
			var sessionObj = UserService.getUserSession();
			if(sessionObj.sessionAlive){
				
			}else{
				$scope.modal.show();
			}
		}
		
		
		// Triggered in the login modal to close it
		$scope.closeLogin = function() {
			$scope.modal.hide();
		};

		// Open the login modal
		$scope.login = function() {
			$scope.modal.show();
		};
		
		$scope.doLogin = function(){
			console.log($scope.loginData);
			UserService.authenticateUser($scope.loginData.userID,$scope.loginData.password).then(function(data){
				if(data.validFlag){
					console.log("session ",UserService.getUserSession());
					$scope.closeLogin();
					redrawScreen();	
				}else{
					$scope.loginData.errorMsg = data.responseMsg;	
				}
			});
		}
		
		function redrawScreen(){
			var userObj = UserService.getUserSession();
			$scope.session.username = userObj.firstName+" "+userObj.lastName
			$scope.session.isAlive = userObj.sessionAlive;	
		}
		
		$scope.browse = function(type){
			console.log(type);
			$state.go('app.single',{"bookmarkType" : type});
		}
		
	}
	
})();