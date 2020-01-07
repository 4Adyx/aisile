/**
 * 
 */
app.controller('loginController',function($scope,$controller,loginService){

	$scope.getName=function(){
		loginService.getName().success(function(a){
			$scope.loginName=a.loginName;
		});
	}
})