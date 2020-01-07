/**
 * 
 */
app.service("sellerService",function($http){
	this.search=function(page,rows,searchEntity){
		return $http.post('../seller/search.do?Index='+page+'&pageSize='+rows,searchEntity);
	}
	this.show=function(id){
		return $http.get('../seller/show.do?id='+id);
	}
	this.updateStatus=function(id,status){
		return $http.get('../seller/updateStatus.do?id='+id+"&status="+status);
	}
	this.del=function(ids){
		return $http.get('../seller/del.do?ids='+ids);
	}
	this.findPage=function(page,rows){
		return $http.get('../seller/findPage.do?Index='+page+'&pageSize='+rows);
	}
	this.findBrandList=function(){
		return $http.get('../seller/findBrandList.do');
	}
	this.add=function(entity){
		return $http.post('../seller/add.do',entity);
	}
	this.selectOptionList=function(){
		return $http.get('../seller/selectOptionList.do');
	}
})