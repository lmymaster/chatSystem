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
            <h1>用户</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">用户</li>
               <li class="breadcrumb-item active">编辑</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title">编辑</h3>
      </div>
      <!-- /.box-header -->
      <div class="box-body">
      		<div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	   style="height:515px;overflow:auto; position: relative;">
      	<div class="row">
      		<div class="col-sm-6">
      	
      			<form id="form" action="${pageContext.request.contextPath}/admin/user/update?id=${user1.id}"  enctype="multipart/form-data" method="post">
          
          			<div class="form-group">
            			<label>用户名</label>
            			<input type="text" name="username"  value="${user1.username}" class="form-control" readonly="readonly">
          			</div>
          			<div class="form-group">
            			<label>密码</label>
            			<input type="password" name="password"  value="" class="form-control" placeholder="密码（为空不修改）">
        			</div>
          			<div class="form-group">
            			<label>邮箱</label>
            			<input type="email" name="email" value="${user1.email}" class="form-control">
          			</div>
          			<div class="form-group">
            			<label>积分</label>
            			<input type="number" name="credit" value="${user1.credit}" class="form-control">
          			</div>
          			
          			<div class="form-group">
            			<label>创建时间</label>
            			<input type="text" name="createtime" readonly="readonly" value="${user1.localCreateTime}" class="form-control">
          			</div>
          		
          			<div class="form-group">
                		<label>头像</label>
                		<p>
            				<input type="file"  name="avatar" accept="image/png,image/jpeg,image/jpg" >
                    			</p>
        				<div class="row">
          					<div class="col-md-9" id="adjustment">
            					<img src="${pageContext.request.contextPath}/static/default/${user1.avatar}" id="newAvatarImg" class="origin-avatar" style="width:150px;height:150px;" alt="">
          					</div>
          					<div class="col-md-3">
            				<div class="preview"></div>
          					</div>
        				</div>
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
	 var msg = "确定要提交吗？";
     if(confirm(msg)==true){
  return true;
     }else{
      return false;
     }
}</script>


<%@ include file="../layout/footer.jsp"%>