<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<script>
    function ConfirmDel(id)
    {
        var r=confirm("确定删除该用户吗?")
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
            <h1>用户</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">用户</li>
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
      
        <form action="${pageContext.request.contextPath}/admin/user/search" method="post" class="form-inline">
          <div class="form-group" style="margin-bottom: 10px;">
            <input type="text" name="username"  class="form-control" placeholder="用户名">
            <input type="text" name="email"  class="form-control" placeholder="邮箱">
            <button type="submit" class="btn btn-primary btn-sm">搜索</button>
          </div>
        </form>
        
         </div>
         <div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	style="height:460px;overflow:auto; position: relative;">
        <div class="box-body">
             <table id="example2" class="table table-bordered table-hover">
          <thead>
          <tr>
            <th>#</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>积分</th>
            <th>时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.id}</td>
              <td>${user.username}</td>
              <td>${user.email}</td>
              <td>${user.credit}</td>
              <td><fmt:formatDate type="both" value="${user.createTime}" /></td>
              <td> 
                  	<a href="${pageContext.request.contextPath}/admin/user/edit?id=${user.id}" class="btn btn-xs btn-warning">编辑</a>
                  	<button onclick="ConfirmDel(${user.id})" class="btn btn-xs btn-danger">删除</button>
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
  <script type="text/javascript">
  
  </script>
</div>
<%@ include file="../layout/footer.jsp"%>