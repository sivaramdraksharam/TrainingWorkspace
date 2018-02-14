(function(){
	'use strict';
	angular
		.module('starter.controllers')
		.controller('HomeController',HomeController);
	
	function HomeController($scope, BookmarkService, UserService, $ionicModal, $state,$ionicPopup,$rootScope){
		$scope.dashData = {}
		$scope.loginData = {}
		$scope.loginData.errorMsg = '';
		$rootScope.session = {}		
		$rootScope.session.isAlive = false;
		
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
		
		$scope.saveBookmark = function(bookmarkId){
			console.log(bookmarkId);
			console.log("session ",UserService.getUserSession());
			var sessionObj = UserService.getUserSession();
			if(sessionObj.sessionAlive){
				BookmarkService.addUserBookmark(sessionObj.id,bookmarkId).then(function(data){
					console.log(data);
					if(data.result){
							$ionicPopup.alert({
								title: 'Hi '+sessionObj.firstName,
								template: 'The item is adde to bookmark'
							});
					}
				})
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
			$rootScope.session.username = userObj.firstName+" "+userObj.lastName
			$rootScope.session.isAlive = userObj.sessionAlive;	
		}
		
		$scope.browse = function(type){
			console.log(type);
			$state.go('app.single',{"bookmarkType" : type});
		}
		
	}
	
})();