<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layui-nav</title>
<link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/default/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/default/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/bootstrap.css">
   <link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/toastr.css">
   <link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/wangEditor/wangEditor.min.css">
  <!-- tostr.js组件 -->
  <script src="http://localhost:8888/GraduationDesign/static/default/layui/layui.js"></script>
    <script src="http://localhost:8888/GraduationDesign/static/default/layui/layui-paginate.js"></script>

  <script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
  <script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
  <!-- 自己创建的js -->
   <script src="http://localhost:8888/GraduationDesign/static/js/detail.js"></script>
   <script src="http://localhost:8888/GraduationDesign/static/js/toastr.js"></script>
   <script src="http://localhost:8888/GraduationDesign/static/js/new.js"></script>
     
   <script src="http://localhost:8888/GraduationDesign/static/default/js/toastr.min.js"></script>
    <script src="http://localhost:8888/GraduationDesign/static/wangEditor/wangEditor.min.js"></script>
     <script src="http://localhost:8888/GraduationDesign/static/wangEditor/wangEditor.js"></script>



 
  <script>
	//注意：导航 依赖 element 模块，否则无法进行功能性操作
	layui.use('element', function(){
	  var element = layui.element;
	  
	  //…
	});
	
</script>
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
 	<script>
 	/****查找是否有回复通知 (此方法立刻执行)*****/
 	(function () {
 	    $.ajax({
 	        url: "${pageContext.request.contextPath}/notice/isRead",
 	        type: "get",
 	        dataType: "json",
 	        success: function (data) {
 	                $("#notice").html(data.result);	          
 	        },
 	        error: function () {
				alert("出问题了");
 	        }
 	    });
 	})();
 	
 	</script>

<style>
button{
background-color:#393D49;
border:none;
color: #8A8A8B;
cursor: pointer;
}
.layui-nav{
	
border-radius:0px;
}
</style>
</head>
<body>
<div class="layui-fluid">
  <div class="layui-row">
    <div class="layui-col-md10 layui-col-sm7 layui-col-xs12">
  <ul class="layui-nav " lay-filter="">    <!-- 背景颜色layui-bg-green，默认#393D49 -->

  <img width="100px" height="50px" src="${pageContext.request.contextPath}/static/default/images/logo.jpg">
  <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/tomain">首页</a></li>
  <li class="layui-nav-item" <c:if test="${tab.tabNameEn == 'tech'}"></c:if>>
  					  <a href="${pageContext.request.contextPath}/tab/tech">技术</a>
  </li>
  <li class="layui-nav-item" <c:if test="${tab.tabNameEn == 'movies'}"></c:if>><a href="${pageContext.request.contextPath}/movies">电影</a></li>
  <li class="layui-nav-item">
    <a href="javascript:;">其他板块</a>
    <dl class="layui-nav-child"> <!-- 二级菜单 -->
      <dd <c:if test="${tab.tabNameEn == 'creative'}"></c:if>><a href="${pageContext.request.contextPath}/tab/creative">创意贴</a></dd>
      <dd <c:if test="${tab.tabNameEn == 'play'}"></c:if>><a href="${pageContext.request.contextPath}/tab/play">趣玩贴</a></dd>
      <dd <c:if test="${tab.tabNameEn == 'jobs'}"></c:if>><a href="${pageContext.request.contextPath}/tab/jobs">工作贴</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item">
  <form action="${pageContext.request.contextPath}/search" method="post">
  <input type="text" name="keyword" required lay-verify="required" placeholder="search" autocomplete="off" class="layui-input" style="color:black;">
  </form>
  </li>
   </ul>
   </div>
   <div class="layui-col-md2 layui-col-sm5 layui-col-xs12">
    <ul class="layui-nav " lay-filter=""> 
   <c:if test="${empty userId}">
   <!--未登陆-->
   <li class="layui-nav-item">
    <a href="${pageContext.request.contextPath}/signin">
    <i class="layui-icon layui-icon-username" style="font-size: 13px; color:write ;"></i>
    													登录</a>
  </li>
  <li class="layui-nav-item">
    <a href="${pageContext.request.contextPath}/signup"><i class="layui-icon layui-icon-add-1" style="font-size: 13px; color:write ;"></i>
    													注册</a>
  </li>
   </c:if>
      <c:if test="${!empty userId}">
             <!--已登录-->
  <li class="layui-nav-item">
    <a href="${pageContext.request.contextPath}/notice/list"><i class="layui-icon layui-icon-notice" style="font-size: 13px; color:write ;"></i><span class="layui-badge" id="notice" >0</span></a>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;"><img src="${pageContext.request.contextPath}/static/default/${user.avatar}" class="layui-nav-img">我</a>
    <dl class="layui-nav-child">
      <dd><a href="${pageContext.request.contextPath}/settings">个人资料</a></dd>
      <dd><a href="${pageContext.request.contextPath}/updatePsswd">修改密码</a></dd>
       <dd><a href="${pageContext.request.contextPath}/adminlogin">后台登录</a></dd>
      <dd><a href="javascript:signout_confirm();">安全退出</a></dd>
    </dl>
  </li>
 </ul>
 </c:if>
   </div>
  </div>
</div>      
</body>
</html>