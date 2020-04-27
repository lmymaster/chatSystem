<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<script>
    function ConfirmDel(id)
    {
        var r=confirm("确定删除该主题吗?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/admin/topic/delete?id="+id;
        }
        else
        {

        }
    }
    function actionBtn(id){
    	 var r=confirm("确定置顶该主题吗?")
         if (r==true)
         {
             window.location.href="${pageContext.request.contextPath}/admin/topic/top?id="+id;
         }
         else
         {

         }
     
    }
    function actionBtn1(id){
   	 var r=confirm("确定加精该主题吗?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/admin/topic/good?id="+id;
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
            <h1>话题</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">话题</li>
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
	 	style="height:530px;overflow:auto; position: relative;">
        <div class="box-body">
             <table id="example2" class="table table-bordered table-hover">
          <thead>
          <tr>
            <th>#</th>
            <th>话题</th>
            <th>用户</th>
            <th>时间</th>
            <th>置顶</th>
            <th>精华</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="topic" items="${topics}">
            <tr>
              <td>${topic.id}</td>

              <td style="width:700px"><a href="/topic/${topic.id}" target="_blank">${topic.title}</a> 
              <c:if test="${topic.top}"> <span class="btn btn-xs btn-success">置顶</span></c:if>
              <c:if test="${topic.good}"> <span class="btn btn-xs btn-success">精华</span></c:if>
              </td>
              <td><a href="/user/${topic.userId}" target="_blank">${topic.user.username}</a></td>
              <td><fmt:formatDate type="both" value="${topic.createTime}" /></td>
              <td><button onclick="actionBtn(${topic.id});" class="btn btn-xs btn-primary">
                  		<c:choose>
                  			<c:when test="${topic.top}">取消置顶</c:when>
                  			<c:otherwise>置顶</c:otherwise>
                  		</c:choose>
                  	</button></td>
              
                 <td><button onclick="actionBtn1(${topic.id});" class="btn btn-xs btn-primary">
                  		<c:choose>
                  			<c:when test="${topic.good}">取消精华</c:when>
                  			<c:otherwise>加精</c:otherwise>
                  		</c:choose>
                  	</button></td>
              <td> 
                  	<a href="${pageContext.request.contextPath}/admin/topic/edit?id=${topic.id}" class="btn btn-xs btn-warning">编辑</a>
                  	<button  onclick="ConfirmDel(${topic.id})" class="btn btn-xs btn-danger">删除</button>
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