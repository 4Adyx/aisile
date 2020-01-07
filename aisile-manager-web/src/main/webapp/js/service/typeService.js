/**
 * 
 */
app.service('typeService',function($http){
	this.search=function(page,rows,searchEntity){
		return $http.post('../type/search.do?Index='+page+"&pageSize="+rows,searchEntity)
	}
	this.add=function(entity){
		return $http.post('../type/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../type/show.do?id='+id);
	}
	this.del=function(ids){
		return $http.get('../type/del.do?ids='+ids);
	}
	this.findPage=function(page,rows){
		return $http.get('../type/findPage.do?Index='+page+'&pageSize='+rows);
	}
	this.findBrandList=function(){
		return $http.get('../type/findBrandList.do');
	}
})