<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/bootstrap.css">
	<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
 	<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
 	
 	<script type="text/javascript">
 	function replay(e){
 	    var t = $(e).closest('.replay').next();
 	    if(t.is(':hidden')){
 	        t.slideDown();
 	    }else {
 	        t.hide();
 	    };
 	};</script>
 	<script>
 
 	function dianzan(){
 	//$("#bt1").click(function () {//给button设置点击事件
 	$.ajax({
 	url: "${pageContext.request.contextPath}/dianzan", //这个对应Controller的URL，和你们以前表单里面的action一样
 	type: "POST",                                  //类型，POST或者GET,就和表单与超链接一样
 	dataType: "json",                              //Controller层返回类型，如果返回String，就用text,返回json,就用json
 	success: function (data) {                     //成功，回调函数
 	//alter(data.result);//可以用data调用Controller返回的值	
 	if(data.result.trim() == "-1"){
 		//alert("未登录，还不能点赞哦");
 		toastr.info("未登录，还不能点赞哦");
 	}else{
 		$("#likeCount").html(data.result);//点赞+1
 	 // alert(data.result);
 	
 	}
 	},
 	error: function () { //失败，回调函数
 	alert("出错了");
 	}
 	});
 	}
 	
 	</script>
 	<script>
 	/***** 是否已收藏了此话题 (此方法立刻执行)*****/
 	
 	(function () {
 	    $.ajax({
 	        url: "${pageContext.request.contextPath}/collect/isCollect",
 	        type: "get",
 	        dataType: "json",
 	        success: function (data) {
 	                $(".collectTopic").html(data.result);	          
 	        },
 	        error: function () {
				alert("出问题了");
 	        }
 	    });
 	})();

 	/***** 收藏和取消收藏话题 *****/
 	function save() {
 	    var collectTopic = $(".collectTopic").text();
 	    var url;
 	    if (collectTopic == "加入收藏") {
 	        url = "${pageContext.request.contextPath}/collect/save";
 	    }
 	    if (collectTopic == "取消收藏") {
 	        url = "${pageContext.request.contextPath}/collect/delete";
 	    }
 	    $.ajax({
 	        url: url,
 	        type: "post",
 	        dataType: "json",
 	        success: function (data) {
 	            if (data.result.trim() == "0") {
 	                $(".collectTopic").text("加入收藏");
 	            }else{
 	            	$(".collectTopic").text("取消收藏");
 	            }
 	            
 	        },
 	        error: function () {
				alert("出问题了");
 	        }
 	    })
 	}

 	</script>
 	<style>
 	.autoheight{
 	height:auto!important;
    height:50px;
    min-height:50px;
 	}
 	</style>
    <title>${topic.title}  </title>
</head>
<body style="background-color:#F5F5F5">
<!-- 引入头文件 -->
<%@ include file="header1.jsp"%>
<div class="container">
<div class="row">
<div class="col-xs-12 col-sm-9  col-md-9">
<div style="margin:1% 0% 1% 5%;">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <div>
            <div class="panel-heading" style="background-color: white">
                <a href="${pageContext.request.contextPath}/tomain">Love</a> › 主题
            </div>
            <h4>${topic.title}</h4><br/>
            <div>
                <a href="${pageContext.request.contextPath}/member/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
                <small class="text-muted">${topic.localCreateTime}&nbsp;&nbsp;&nbsp;+08:00</small>&nbsp;&nbsp;
                <small class="text-muted">${topic.click}浏览量</small>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0);" class="collectTopic" onclick="save()"></a>&nbsp;&nbsp;&nbsp;&nbsp;
                 <span id="bt1">
                   <a href="javascript:;"  onclick="dianzan();" title="点赞 ">
                   <i class="layui-icon layui-icon-praise"></i> 赞
                   <i id="likeCount">${topic.nice}</i>
    			   </a>
  				 </span>
            </div>
        </div>

        <div style="float: right;margin-top: -100px" >
            <img width="50px" height="50px" src="${pageContext.request.contextPath}/static/default/${topic.user.avatar}" class="img-circle">
        </div>
    </div>

    <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                ${topic.content}
            </li>
    </ul>
</div>

<c:if test="${!empty replies}">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <span>
                ${fn:length(replies)} 回复  |  直到 <c:forEach items="${replies}" var="reply" varStatus="status">

<c:if test="${status.last}">
    ${reply.localCreateTime}
    </c:if>
    </c:forEach>
    </span>
    </div>
<!--  
    <ul class="list-group" style="width: 100%">
        
        <c:forEach items="${replies}" var="reply">
        <li class="list-group-item">
            <div style="height:50px">
                <div style="float: left;width: 6%;margin-bottom: 5px">
                    <img width="50px" height="50px" src="${pageContext.request.contextPath}/static/default/${reply.user.avatar} " class="img-rounded">
                </div>
                <div style="width: 91%;float: right">
                    <a href="${pageContext.request.contextPath}/member/${reply.user.username}"><strong>${reply.user.username}</strong></a>&nbsp;&nbsp;
                    <small class="text-muted">${reply.localCreateTime}</small>
                    <br/>
                    <div>
                        ${reply.content}
                    </div>
                   
                </div>
              
            </div>
        </li>
        
        </c:forEach>

    </ul>-->
    <div class="table">
     <c:forEach var="reply" items="${replies}">  
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table">
                <tbody>
                <tr  class="replay">
                    <td width="48" valign="top" align="center">
                        <a href="">
                            <img style="width:60px;height:60px;"  src="${pageContext.request.contextPath}/static/default/${reply.user.avatar} " class="user-avatar img-circle" alt=""/>
                        </a>
                        </td>
                    <td width="10" valign="top"></td>
                    <td width="auto" valign="middle" align="left">
                     
                        <div class="sep3"></div>
                        <strong>
                            <a href="${pageContext.request.contextPath}/member/${reply.user.username}" class="dark">${reply.user.username}</a>
                        </strong>&nbsp;
                         <small class="text-muted">${reply.localCreateTime}</small>
                        <div class="sep5"></div>
                        <div class="comment_content">${reply.content}</div>
                    </td>
                </tr>
                  
                </tbody>
            </table>
   
    </c:forEach>
    </div>
</div>
</c:if>
<c:if test="${empty replies}">
<div class="panel panel-default" id="main" style="text-align:center;">
目前暂无评论
</div>
</c:if>
<c:if test="${!empty user}">

<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        添加一条新回复
    </div>
    <div class="panel-body">
        <div class="form-group">
            <form action="${pageContext.request.contextPath}/reply/add" method="post" id="reply" enctype="multipart/form-data">
                <input type="hidden" name="topicId" value="${topic.id}">
                <input type="hidden" name="replyUserId" value="${user.id}">
                  <input type="hidden" name="topicUserId" value="${topic.userId}">
               <!--  <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/> -->
                 <%--正文（富文本编辑器）--%>
                   
				    <div class="min800 inline-block" style="width:100%;" id="editor"></div>
				   <input type="hidden"  name="content" id="editor_txt">

                <br/>
            <input type="button" class="btn btn-success btn-sm" value="回复" id="btn_re">
            </form>
        </div>

    </div>
</div>
</c:if>
</div>
</div>
 <div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="side.jsp"%>
		 	</div>
</div>

</div>
<!-- 引入底文件 -->
		 	<%@ include file="footer.jsp"%>	
</body>
</html>