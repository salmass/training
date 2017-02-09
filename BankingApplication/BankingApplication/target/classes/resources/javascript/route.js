/**
 * 
 */
App.config(['$routeProvider', function($routeProvider){
     
	 $routeProvider
     
    .when('/Account', {
         templateUrl: 'resources/views/Account.Html',
         controller : "AccountCtrl"
        
     })
     .when('/AddReceipients', {
         templateUrl: 'resources/views/AddReceipients.Html',
         controller:"AddReceipientsCtrl"
        
     })
     .when('/Transfers', {
         templateUrl: 'reources/views/Transfers.Html',
         controller : "TransfersCtrl"
        
     })
     .othrewise({
     templateUrl: 'reources/views/HomePage.Html',
     controller : "mainCtrl"
       });
}]);

//Controller
App.controller("AccountCtrl", function ($scope,HeaderService) {
	HeaderService.getAccountData().then(function(data){
		var j=data;
		$scope.data=JSON.parse(j.data);
		$scope.user=JSON.parse($scope.data.accountdatas);
	});
	$scope.message="welcome to account page";
});
App.controller("TransfersCtrl", function ($scope) {
	$scope.message="Transfer Money";
    });
App.controller("AddReceipientsCtrl",function($scope){
	$scope.message="Add Receipients for tranfer";
});
App.controller("mainCtrl",function($scope){
	$scope.message="This is home page";
});

    