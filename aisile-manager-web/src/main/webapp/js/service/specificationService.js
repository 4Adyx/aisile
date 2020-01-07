/**
 * 
 */
app.service('specificationService',function($http){
	this.search=function(page,rows,searchEntity){
		return $http.post('../specification/search.do?Index='+page+"&pageSize="+rows,searchEntity)
	}
	this.del=function(ids){
		return $http.get('../specification/del.do?ids='+ids);
	}
	this.findPage=function(page,rows){
		return $http.get('../specification/findPage.do?Index='+page+'&pageSize='+rows);
	}
	this.findBrandList=function(){
		return $http.get('../specification/findBrandList.do');
	}
	this.add=function(entity){
		return $http.post('../specification/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../specification/show.do?id='+id);
	}
	this.selectSpecList=function(){
		return $http.get('../specification/selectSpecList.do');
	}
})