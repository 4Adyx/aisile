/**
 * 
 */
app.controller('sellerController',function($scope,$controller,sellerService){
	$controller('baseController',{$scope:$scope});
	$scope.searchEntity={};
	$scope.entity={};
	$scope.search=function(page,rows){
		sellerService.search(page,rows,$scope.searchEntity).success(
				function(a){
					$scope.list=a.rows;	
					$scope.paginationConf.totalItems=a.total;
				});	
		}
	$scope.save=function(){
		sellerService.add($scope.entity).success(
				function(a){
				if(a){
					$scope.reloadList();
				}else{
					alert("编辑失败!")
				}
		});
	}
	$scope.show=function(id){
		sellerService.show(id).success(
				function(a){
					console.log(a);
					$scope.entity=a;
				
		});
	}
	$scope.del=function(){
		sellerService.del($scope.ids).success(
				function(a){
						if(a){
							$scope.reloadList();
						}
				
		});
	}
	$scope.addTableRow=function(){
		
		$scope.entity.specificationOptionList.push({});
	}
	$scope.deleTableRow=function(index){			
		$scope.entity.specificationOptionList.splice(index,1);//删除			
	} 
	$scope.updateStatus=function(id,status){
		sellerService.updateStatus(id,status).success(function(a){
			$scope.reloadList();
		})
	}
})