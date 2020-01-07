/**
 * 
 */
app.service("brandService",function($http){
	this.del=function(ids){
		return $http.get('../brand/del.do?ids='+ids);
	}
	this.search=function(page,rows,searchEntity){
		return $http.post('../brand/search.do?Index='+page+'&pageSize='+rows,searchEntity);
	}
	this.findPage=function(page,rows){
		return $http.get('../brand/findPage.do?Index='+page+'&pageSize='+rows);
	}
	this.findBrandList=function(){
		return $http.get('../brand/findBrandList.do');
	}
	this.add=function(entity){
		return $http.post('../brand/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../brand/show.do?id='+id);
	}
	this.selectOptionList=function(){
		return $http.get('../brand/selectOptionList.do');
	}
})