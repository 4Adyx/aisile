/**
 * 
 */
app.controller('brandController',function($scope,$controller,brandService){
	$controller('baseController',{$scope:$scope});
	$scope.searchEntity={};
	$scope.search=function(page,rows){
		brandService.search(page,rows,$scope.searchEntity).success(
				function(a){
					$scope.list=a.rows;	
					$scope.paginationConf.totalItems=a.total;
				});	
		}
	$scope.findByPage=function(page,rows){
		brandService.findByPage(page,rows).success(
				function(a){
					$scope.list=a.rows;	
					$scope.paginationConf.totalItems=a.total;
				});	
		}
	$scope.findAll=function(){
		brandService.findBrandList().success(
				function(a){
					$scope.list=a;	
				});	
		}
	$scope.save=function(){
		var da=/^[A-Z]$/;
		var myReg = /^[a-zA-Z0-9_]{0,}$/;
		if(!myReg.test($scope.entity.name)){
			if(!da.test($scope.entity.firstChar)){
				brandService.add($scope.entity).success(
						function(a){
						if(a){
							$scope.reloadList();
						}else{
							alert("编辑失败!")
						}
				});
			}
			alert("首字母必须是单个大写字母!");
		}
		alert("姓名必须是中文");
	}
	$scope.show=function(id){
		brandService.show(id).success(
				function(a){
					console.log(a);
					$scope.entity=a;
				
		});
	}
	$scope.del=function(){
		brandService.del($scope.ids).success(
				function(a){
						if(a){
							$scope.reloadList();
						}
				
		});
	}
})