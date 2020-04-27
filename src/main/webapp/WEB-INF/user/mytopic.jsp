<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页界面</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/bootstrap.css">
<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
</head>
<script>
    function ConfirmDel(id)
    {
        var r=confirm("确定删除该主题吗?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/delete?id="+id;
        }
        else
        {

        }
    }
    
</script>
<style>
	li {list-style-type:none;}
	.container{
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
.layui-nav{
	
border-radius:0px;
}
#button{
width:50px;
height:28px;
}
</style>

<body style="background-color:#F5F5F5">
	<!--引入header文件 -->
	<%@ include file="../common/header1.jsp"%>
	<div class="container">
        <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-9 ">
        <div class="panel panel-default" id="main" style="margin:2% 0% 2% 0%;">
        <div class="panel-heading" style="background-color: #6495ED ;">
        <b style="margin-right: 2%;color:white;">已发布的主题</b>
         </div>
	<div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	style="height:500px;overflow:auto; position: relative;">
 	<ul class="list-group" style="width: 100%">
 	 <c:if test="${!empty topics}">
    <c:forEach items="${topics}" var="topic">
    <li class="list-group-item">
        <div style="height: 50px">
            <div style="float: left;width: 6%;margin-bottom: 5px">
                <img width="50px" height="50px" src="http://localhost:8888/GraduationDesign/static/default/${topic.user.avatar}" class="img-rounded">
            </div>
            <div style="width: 84%;float: left">
                <a href="${pageContext.request.contextPath}/t/${topic.id}">${topic.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${topic.countReplies} 回复<br/>
                <div>
                    <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/member/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;&nbsp;
                    <small class="text-muted">${topic.localCreateTime}</small>
                </div>
            </div>
            <div style="width:10%;float:right;text-align: center">
                  <button id="button"type="button" class="btn btn-danger" onclick="ConfirmDel(${topic.id});" style="font-size:11px;">删除</button>
            </div>
        </div>
    </li>

    </c:forEach>
   </c:if>
   <c:if test="${empty topics}">
   <h3>未找到该板块内容！来发贴吧^-^</h3 >
   </c:if>
			</ul>
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
          	  <li class="list-group-item"><a href="${pageContext.request.contextPath}/t/${hotestTopic.id}">${hotestTopic.title}</a></li>
       	 </c:forEach>
    </ul>
</div>
           </div>
		 </div>
		  <a href="javascript:;" id="btn" title="回到顶部" style="width:80px; 
         height:80px; position:fixed; right:130px; bottom:10px; "><i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> </a>
      </div>
<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
</body>
</html>