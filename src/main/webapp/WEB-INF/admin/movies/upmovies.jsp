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
            <h1>上传电影</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">电影</li>
               <li class="breadcrumb-item active">上传</li>
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
      	
      			<form id="form" action="${pageContext.request.contextPath}/admin/movies/addmovie"  enctype="multipart/form-data" method="post">
          
          			<div class="form-group">
            			<label>电影名</label>
            			<input type="text" name="moviename" class="form-control">
          			</div>
          			<div class="form-group">
            			<label>制作地区</label>
            			<input type="text" name="area" class="form-control" >
        			</div>
        				<div class="form-group">
            			<label>上映时间</label>
            			<input type="text" name="uptime" class="form-control" placeholder="(格式：xxxx-xx-xx)" >
        			</div>
          			<div class="form-group">
            			<label>导演</label>
            			<input type="text" name="director" class="form-control">
          			</div>
          			<div class="form-group">
            			<label>演员</label>
            			<input type="text" name="actor"  class="form-control">
          			</div>
          			
          			<div class="form-group">
            			<label>简介</label>
            			<input type="text" name="introduce" class="form-control">
          			</div>
          		
          			<div class="form-group">
                		<label>上传电影图片</label>
                		<p>
            				<input type="file"  name="avatar" accept="image/png,image/jpeg,image/jpg" >
                    			</p>
        				
              		</div>
              			<div class="form-group">
                		<label>上传电影资源</label>
                		<p>
            				<input type="file"  name="address ">
                    			</p>
        				
              		</div>
          			<button type="submit" onclick="return confirmUpdate();" class="btn btn-primary">提交</button>
        		
        		</form>
        		
      		</div>
      	</div>
      	</div>
      </div>
    </div>
  </section>
</div>
<script>
function confirmUpdate(){
	 var msg = "确定要上传该影片吗？";
     if(confirm(msg)==true){
  return true;
     }else{
      return false;
     }
}</script>


<%@ include file="../layout/footer.jsp"%>