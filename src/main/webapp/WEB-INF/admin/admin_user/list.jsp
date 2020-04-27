<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<script>
    function ConfirmDel(id)
    {
        var r=confirm("确定删除该管理员吗?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/adminuser/delete?id="+id;
        }
        else
        {

        }
    }
    
    
</script>

<!-- 内容主体区域 -->
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="padding: 0 0 0 0;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>超级管理员</h1><br/><button  class="btn btn-xs btn-success" data-toggle="modal" data-target="#myModal"><i class="layui-icon layui-icon-add-1" style="font-size: 13px; color:write ;"></i>添加新管理员</button>
            
				 
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">超级管理员</li>
               <li class="breadcrumb-item active">列表</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  
   
   <section class="content">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title"></h3>
           
      <!-- /.box-header -->
      
    
        
         </div>
         <div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	style="height:460px;overflow:auto; position: relative;">
        <div class="box-body">
             <table id="example2" class="table table-bordered table-hover">
          <thead>
          <tr>
            <th>#</th>
            <th>用户名</th>
            <th>时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.id}</td>
              <td>${user.username}</td>
              <td><fmt:formatDate type="both" value="${user.createTime}" /></td>
              <td> 
                  	<button onclick="ConfirmDel(${user.id})" class="btn btn-xs btn-danger" >删除</button>
              </td>
            </tr>
			</c:forEach>
          </tbody>
        </table>
      </div>
      </div>
    </div>
    </div>
      <!-- <div class="panel-footer" id="paginate"></div> --> 
    </div>

  </section>

    <!-- 管理员注册界面 -->

				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">
									注册界面
								</h4>
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								
							</div>
							<div class="modal-body">
		                  <form action="${pageContext.request.contextPath}/adminuser/addadmin" method="post" class="form-horizontal" role="form" style="margin-left: 5%">
            <div class="form-group" >
                <label class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control"  name="username" required="required" placeholder="请输入用户名">
             
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10" >
                    <input type="password" class="form-control"  name="password" required="required" placeholder="密码">
                </div>
            </div>
           
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								<button  class="btn btn-primary">注册</button>
            
                         
                           </form>
							</div>
							
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>


</div>
<%@ include file="../layout/footer.jsp"%>