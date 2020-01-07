/**
 * 
 */
app.service("itemCatService",function($http){
	this.findByParentId=function(parentId){
		return $http.get('../tbItemCat/findByParentId.do?parentId='+parentId);
	}
	this.search=function(page,rows,searchEntity){
		return $http.post('../brand/search.do?Index='+page+'&pageSize='+rows,searchEntity);
	}
	this.del=function(ids){
		return $http.get('../tbItemCat/del.do?ids='+ids);
	}
	this.findAll=function(){
		return $http.get('../tbItemCat/findAll.do');
	}
	this.add=function(entity){
		return $http.post('../tbItemCat/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../tbItemCat/show.do?id='+id);
	}
	this.selectOptionList=function(){
		return $http.get('../brand/selectOptionList.do');
	}
})