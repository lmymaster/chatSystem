<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<!-- 内容主体区域 -->
<div class="content-wrapper" style="padding: 0 0 0 0;">
	 <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>轮播图管理</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">轮播图</li>
               <li class="breadcrumb-item active">管理</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title"></h3>
      </div>
      <!-- /.box-header -->
      <div class="box-body">
      		<div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	   style="height:515px;overflow:auto; position: relative;">
      	<div class="row">
      		<div class="col-sm-6">
      		  <label>门户轮播</label>
      		 <c:forEach items="${lunbolist}" var="lunbo">
      		 	<c:if test="${lunbo.type eq 0}">
      		 <form action="${pageContext.request.contextPath}/admin/lunbo/update/${lunbo.id}" id="d" method="post" enctype="multipart/form-data" class="form-inline">
                  <table id="example2" class="table table-bordered table-hover" >
			          <thead>
			          <tr>
			            <th>#</th>
			            <th >相对地址</th>
			            <th>本地上传</th>
			            <th>预览图片</th>
			            <th>操作</th>
			          </tr>
			          </thead>
			          <tbody>
			            <tr>
                 
			              <td>${lunbo.id}</td>
						  <td style="width:100px"><input type="text" name="" value="${lunbo.avatar}" class="form-control" readonly="readonly"></td>
						  <td><input type="file" id="file"name="file" ></td>
	                      <td><img style="width:200px;height: 90px" src="${pageContext.request.contextPath}/${lunbo.avatar}"></td>  
						  <td><button   onclick="return confirmUpdate();" class="btn btn-xs btn-warning">修改</button></td> 
			            
          			  </tr>
        		     
			            
			             
			          </tbody>
			        </table>  
          		</form>
          		 	</c:if> 	
          		   </c:forEach>
          		   
          		   
                     <label>电影轮播</label>
                    <c:forEach items="${lunbolist}" var="lunbo">
      		 	<c:if test="${lunbo.type eq 1}">
      		 <form action="${pageContext.request.contextPath}/admin/lunbo/update/${lunbo.id}" id="d" method="post" enctype="multipart/form-data" class="form-inline">
                  <table id="example2" class="table table-bordered table-hover" >
			          <thead>
			          <tr>
			            <th>#</th>
			            <th >相对地址</th>
			            <th>本地上传</th>
			            <th>预览图片</th>
			            <th>操作</th>
			          </tr>
			          </thead>
			          <tbody>
			            <tr>
                 
			              <td>${lunbo.id}</td>
						  <td style="width:100px"><input type="text" name="" value="${lunbo.avatar}" class="form-control" readonly="readonly"></td>
						  <td><input type="file" id="file1 	" name="file" ></td>
	                      <td><img style="width:200px;height: 90px" src="${pageContext.request.contextPath}/${lunbo.avatar}"></td>  
						  <td><button  onclick=" return confirmUpdate();" class="btn btn-xs btn-warning">修改</button></td> 
			            
          			  </tr>
        		     
			            
			             
			          </tbody>
			        </table>  
          		</form>
          		 	</c:if> 	
          		   </c:forEach>
         	</div>
      	  </div>
      	</div>
      </div>
    </div>
  </section>
</div>
<script>
function confirmUpdate(){
	var fileInput = $('#file').get(0).files[0];
	console.info(fileInput);
	if(fileInput){
		$("#d").submit();
		return true;
         }else{    		
       		 toastr.info("请选择上传文件");   
       		 return false;
       	}
    	}
    	

</script>
<%@ include file="../layout/footer.jsp"%>