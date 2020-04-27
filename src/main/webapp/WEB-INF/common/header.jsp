<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航栏</title>
<link rel="stylesheet" type="text/css" href="static/default/css/bootstrap.css">
  <link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/default/layui/css/layui.css">
  <script src="http://localhost:8888/GraduationDesign/static/default/layui/layui.js"></script>
    <script src="http://localhost:8888/GraduationDesign/static/default/layui/layui-paginate.js"></script>
<script src="static/default/js/jquery-1.11.3.min.js"></script>
<script src="static/default/js/bootstrap.js"></script>
<script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/signout";
        }
        else
        {

        }
    }
</script>
<style type="text/css">
.navbar{
background-color:#E6E6FA;
}
</style>
</head>

<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand"  href="/"> <img width="100px" height="30px" src="${pageContext.request.contextPath}/static/default/images/logo.jpg"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="background-color:#393D49;">
      <ul class="nav navbar-nav">
       <!--   <li class="active"><a href="#">首页</a></li>-->
        <li><a href="${pageContext.request.contextPath}/tomain">首页</a></li>
		<li <c:if test="${tab.tabNameEn == 'tech'}">
                            class="active" </c:if>><a href="tab/tech">技术</a>
                    </li>
		<li<c:if test="${tab.tabNameEn == 'jobs'}">
                             </c:if>><a href="tab/jobs">工作</a></li>
		<li><a href="#">其他板块</a></li>
      </ul>
   
      <form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/search">
		       <div class="input-group">
	         <input type="text" class="form-control" name="keyword" placeholder="search">
	        <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span> </span>
	     		 </div>
      		</form> 
   
      <c:if test="${empty userId}">
             <!--未登陆-->
          <ul class="nav navbar-nav navbar-right">
          <li><a href="${pageContext.request.contextPath}/signin"><span class="glyphicon glyphicon-user" aria-hidden="true"/>登录</a></<li>
	    
	   <li><a href="${pageContext.request.contextPath}/signup">注册</a></<li>
     </ul>
 </c:if>
            <c:if test="${!empty userId}">
                   <!--已登陆-->
                <ul class="nav navbar-nav navbar-right"> 
                    <li>
                        <p class="navbar-text"><a href="${pageContext.request.contextPath}/member/${user.username}">欢迎，${sessionScope.username}</a></p> 
                    </li>
                    <li>
                        <p class="navbar-text"><a href="${pageContext.request.contextPath}/settings"> <img width="30px" height="30px" src="http://localhost:8888/GraduationDesign/static/default/${user.avatar}" class="img-rounded"></a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="javascript:signout_confirm();"><span class="glyphicon glyphicon-off" aria-hidden="true" style="color:red"/>安全退出</a></p>
                    </li>
                </ul>
            </c:if>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>