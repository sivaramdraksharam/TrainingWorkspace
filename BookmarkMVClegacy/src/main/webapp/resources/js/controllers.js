angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout,UserService) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  // Form data for the login modal
  $scope.loginData = {};
	console.log("Controller 0");
  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/login.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeLogin = function() {
    $scope.modal.hide();
  };

  // Open the login modal
  $scope.login = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doLogin = function() {
    console.log('Doing login', $scope.loginData);
    UserService.authenticateUser($scope.loginData.userID,$scope.loginData.password).then(function(data){
		if(data.validFlag){
			console.log("session ",UserService.getUserSession());
			$scope.closeLogin();
		}else{
			$scope.loginData.errorMsg = data.responseMsg;	
		}
	});
    
  };
})

.controller('PlaylistsCtrl', function($scope,$ionicScrollDelegate,$http) {
	console.log("Controller Main");
	$http.get("/bookmark/getRecent").then(function(data){
		console.log(data);
	})
})
.controller('BrowseCntrl', function($scope, $stateParams,UserService) {
	console.log("Browes Controler")
	
	$scope.$on('$ionicView.enter', function(){
		loadBookmark();
	})
	
	function loadBookmark(){
		$scope.bookmarkList = [];
		UserService.getUserBookmark().then(function(data){
			console.log(data);
			$scope.bookmarkList = data;
		});
	}
	
	
})
.controller('PlaylistCtrl', function($scope, $stateParams) {
	var ans = JSON.parse($stateParams.playlistId);
	console.log("Controller Playlist %O",ans);
})

.directive('clickForOptions', ['$ionicGesture', function($ionicGesture) {
	return {
		restrict: 'A',
		link: function (scope, element, attrs) {
			$ionicGesture.on('tap', function(e){

				// Grab the content
				var content = element[0].querySelector('.item-content');

				// Grab the buttons and their width
				var buttons = element[0].querySelector('.item-options');

				if (!buttons) {
					console.log('There are no option buttons');
					return;
				}
				var buttonsWidth = buttons.offsetWidth;

				ionic.requestAnimationFrame(function() {
					content.style[ionic.CSS.TRANSITION] = 'all ease-out .25s';

					if (!buttons.classList.contains('invisible')) {
						console.log('close');
						content.style[ionic.CSS.TRANSFORM] = '';
						setTimeout(function() {
							buttons.classList.add('invisible');
						}, 250);				
					} else {
						buttons.classList.remove('invisible');
						content.style[ionic.CSS.TRANSFORM] = 'translate3d(-' + buttonsWidth + 'px, 0, 0)';
					}
				});		

			}, element);
		}
	};
}]);