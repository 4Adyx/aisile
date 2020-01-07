/**
 * 
 */
app.service("contentCateService",function($http){
	this.search=function(page,rows,searchEntity){
		return $http.post('../contentCate/search.do?index='+page+'&pageSize='+rows,searchEntity);
	}
	this.findAll=function(){
		return $http.get('../contentCate/findAll.do');
	}
	this.add=function(entity){
		return $http.post('../contentCate/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../contentCate/show.do?id='+id);
	}
	this.del=function(ids){
		return $http.get('../contentCate/del.do?ids='+ids);
	}
	this.updateStatus1=function(ids){
		return $http.get('../contentCate/updateStatus1.do?ids='+ids);
	}
	this.updateStatus2=function(ids){
		return $http.get('../contentCate/updateStatus2.do?ids='+ids);
	}
})