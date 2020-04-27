<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <c:if test="${!empty userInfo}">${userInfo.username}</c:if><c:if test="${!empty errorInfo}">会员未找到</c:if></title>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/bootstrap.css">
<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
<script>
 	/***** 是否已关注了此话题 (此方法立刻执行)*****/
 	
 	(function () {
 	    $.ajax({
 	        url: "${pageContext.request.contextPath}/follow/isFollow",
 	        type: "get",
 	        dataType: "json",
 	        success: function (data) {
 	                $("#followUser").html(data.result);	          
 	        },
 	        error: function () {
				alert("出问题了");
 	        }
 	    });
 	})();
	/***** 加入和取消关注话题 *****/
 	function save() {
 	    var followuser = $("#followUser").text();
 	    var url;
 	    if (followuser == "加入特别关注") {
 	        url = "${pageContext.request.contextPath}/follow/save";
 	    }
 	    if (followuser == "取消关注") {
 	        url = "${pageContext.request.contextPath}/follow/delete";
 	    }
 	    $.ajax({
 	        url: url,
 	        type: "post",
 	        dataType: "json",
 	        success: function (data) {
 	            if (data.result.trim() == "0") {
 	                $("#followUser").text("加入特别关注");
 	            }else{
 	            	$("#followUser").text("取消关注");
 	            }
 	            
 	        },
 	        error: function () {
 	        	alert("出问题了");
 	        }
 	    })
 	}


 	</script>
</head>
<body style="background-color:#F5F5F5">

<!--引入header文件 -->
<%@ include file="../common/header.jsp"%>
<div style="width: 50%;margin:3% 0% 5% 22%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color:#F5F5F5">
            <a href="${pageContext.request.contextPath}/tomain">Love</a> › <strong>${userInfo.username}      </strong>的个人首页
        </div>

        <div class="panel-body">
            <c:if test="${!empty userInfo}">
            <form class="form-horizontal " role="form">
                <div style="margin-left: 17% ">
                    <img width="60px" height="60px" src="http://localhost:8888/GraduationDesign/static/default/${userInfo.avatar}" class="img-rounded">
                <div style="float:right;margin-right:17%">
                 <c:if test="${!empty userId}">
                <!-- <a href="javascript:void(0);" class="followUser" onclick="save()"></a> -->
                <button class="btn btn-success btn-sm" id="followUser" onclick="save()"></button>
                 </c:if></div> 
                 </div>
                
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">uid</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.id}</p>
                      
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.email}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">注册时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.localCreateTime}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">积分</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.credit}</p>
                    </div>
                </div>
            </form>
            </c:if>
            <c:if test="${!empty errorInfo}">
                会员未找到!
            </c:if>
        </div>
    </div>
</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>