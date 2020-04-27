<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/default/static/css/bootstrap.css">
<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
</head>
<script type="text/javascript" language="javascript"> 
function confirmUpdate(){
	 var msg = "确定要修改吗？";
         if(confirm(msg)==true){
	  return true;
         }else{
          return false;
         }
 }
 </script>
<style>
	li{list-style-type:none;}

     .container {
          border:1px;
        }
     .info {
          margin-right: 5%;
          width: 10%;
          float: left;
          border:1px;
        }
     .panel-heading a{
           color: #8A8A8A;
           cursor: pointer;
        }
</style>

<body style="background-color:#F5F5F5">
	<!--引入header文件 -->
	<%@ include file="../common/header1.jsp"%>
	<div class="container">
        <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-9 ">
        <div class="panel panel-default" id="main" style="margin:2% 0% 10% 0%;">
        <div class="panel-heading" style="background-color: #6495ED">
       <a href="${pageContext.request.contextPath}/tomain" style="color:white;">首页</a> › 个人资料
         </div>


        <div class="panel-body">

                <form class="form-horizontal" role="form" action="update" method="post">
                    <div style="margin-left: 17%">
                        <img width="60px" height="60px" src="${pageContext.request.contextPath}/static/default/${user.avatar}" class="img-rounded">
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/settings/avatar" role="button">更换头像</a>
                         <a class="btn btn-primary" href="${pageContext.request.contextPath}/updatePsswd" role="button">修改密码</a>
                    </div>
 
					  <div class="form-group">
					    <label class="col-sm-2 control-label">UserName</label>
					    <div class="col-sm-10">
					      <input type="text" name="username" class="form-control"  value="${user.username}">
					    </div>
					  </div>
					  <div class="form-group">
					    <label  class="col-sm-2 control-label">Email</label>
					    <div class="col-sm-10">
					      <input type="email" name="email" class="form-control"  value="${user.email}">
					    </div>
					  </div>  
					   <div class="form-group">
					    <label for="phonenum" class="col-sm-2 control-label">Phone</label>
					    <div class="col-sm-10">
					      <input type="text" name="phonenum" class="form-control" id="phonenum" value="${user.phoneNum}" required="required">
					    </div>
					  </div>   			  					      
					  <div class="form-group">
					    <label class="col-sm-2 control-label">注册时间</label>
					    <div class="col-sm-10">
					      <input  class="form-control"id="disabledInput" type="text" placeholder="${user.localCreateTime}" disabled>
					    </div>
					  </div> 
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">积分</label>
					    <div class="col-sm-10">
					      <input  class="form-control"id="disabledInput" type="text" placeholder="${user.credit}" disabled>
					    </div>
					  </div> 
					   <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-warning" onclick="return confirmUpdate();">修改</button>
					    </div>
					  </div>
					</form>
                
                
         </div>
		 	</div>
		 	</div>
		 	<div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="../common/side.jsp"%>
		 	</div>
		 	
		    <div class=".col-md-offset-9  col-xs-6 col-sm-3 col-md-3 ">
		    <div class="panel panel-default" id="sidebar1" style="margin:7% 0% 1% 2%;">
   				 <div class="panel-heading" style="background-color: #6495ED;text-align: center;color:white;">
    							   热门图文
    		</div>
    		<ul class="list-group" >
      		  <c:forEach items="${hotestTopics}" var="hotestTopic">
          	  <li class="list-group-item"><a href="t/${hotestTopic.id}">${hotestTopic.title}</a></li>
       	 </c:forEach>
    </ul>
</div>
           </div>
		 </div>
      </div>
<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
</body>
</html>