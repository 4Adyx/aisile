/**
 * 
 */
app.service("contentService",function($http){
	this.search=function(page,rows,searchEntity){
		return $http.post('../content/search.do?index='+page+'&pageSize='+rows,searchEntity);
	}
	this.findAll=function(){
		return $http.get('../contentCate/findAll.do');
	}
	this.add=function(entity){
		return $http.post('../content/add.do',entity);
	}
	this.show=function(id){
		return $http.get('../content/show.do?id='+id);
	}
	this.del=function(ids){
		return $http.get('../content/del.do?ids='+ids);
	}
	this.updateStatus1=function(ids){
		return $http.get('../content/updateStatus1.do?ids='+ids);
	}
	this.updateStatus2=function(ids){
		return $http.get('../content/updateStatus2.do?ids='+ids);
	}
	this.upload=function(){
		var formData=new FormData();
		formData.append('file',file.files[0]);
		return $http({
			method:"POST",
			url:"../upload.do",
			data:formData,
			headers:{'Content-Type':undefined},
			transformRequest:angular.identity
		});
	}
})