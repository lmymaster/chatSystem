<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<script>
    function ConfirmDel(id)
    {
        var r=confirm("确定删除该评论吗?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/admin/comment/delete?id="+id;
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
            <h1>评论</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">评论</li>
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
      
        <form action="${pageContext.request.contextPath}/admin/comment/search" method="post" class="form-inline">
          <div class="form-group" style="margin-bottom: 10px;">
            <input type="text" name="username"  class="form-control" placeholder="用户名">
            <input type="text" name="topic"  class="form-control" placeholder="话题"><!-- 模糊匹配 -->
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
            <th>评论</th>
            <th>话题</th>
            <th>用户</th>
            <th>时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="reply" items="${replies}">
            <tr>
              <td>${reply.id}</td>
              <td style="width:250px">${reply.content}</td>
              <td><a href="/topic/${reply.topicId}" target="_blank">${reply.topic.title}</a></td>
              <td><a href="/user/${reply.replyUserId}" target="_blank">${reply.user.username}</a></td>
              <td><fmt:formatDate type="both" value="${reply.createTime}" /></td>
              <td> 
                  	<a href="${pageContext.request.contextPath}/admin/comment/edit?id=${reply.id}" class="btn btn-xs btn-warning">编辑</a>
                  	<button onclick="ConfirmDel(${reply.id})" class="btn btn-xs btn-danger">删除</button>
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