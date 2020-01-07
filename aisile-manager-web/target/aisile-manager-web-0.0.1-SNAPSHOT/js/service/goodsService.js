/**
 * 
 */
app.service("goodsService",function($http){
	this.add=function(entity){
		return $http.post('../goods/add.do',entity);
	}
	this.del=function(ids){
		return $http.get('../goods/del.do?ids='+ids);
	}
	this.search=function(page,rows,searchEntity){
		return $http.post('../goods/search.do?page='+page+'&rows='+rows,searchEntity);
	}
	this.show=function(id){
		return $http.get('../goods/show.do?id='+id);
	}
	this.findAll=function(){
		return $http.get('../tbItemCat/findAll.do');
	}
	this.examine=function(ids){
		return $http.get('../goods/examine.do?ids='+ids);
	}
	this.reject=function(ids){
		return $http.get('../goods/reject.do?ids='+ids);
	}
	this.findOne=function(id){
		return $http.get('../goods/findOne.do?id='+id);
	}
	this.updateStatus=function(entity){
		return $http.post('../goods/updateStatus.do',entity);
	}
})