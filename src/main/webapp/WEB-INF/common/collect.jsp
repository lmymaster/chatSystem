<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收藏系统</title>

</head>
<!--引入header文件 -->
<%@ include file="header1.jsp"%>
<body>
<div class="container">
<div class="row">
<div class="col-xs-6 col-sm-9 col-md-9">
        <div class="panel panel-default" id="main" style="margin:2% 0% 2% 0%;">
         <div class="panel-heading" style="background-color:#F5F5F5">
        <span >
                ${fn:length(topics)} 回复  |  直到 <c:forEach items="${topics}" var="reply" varStatus="status">

<c:if test="${status.last}">
    ${reply.localCreateTime}
    </c:if>
    </c:forEach>
    </span>
    </div>
<ul class="list-group" >
 	 
     <c:forEach items="${topics}" var="topic">
     <li class="list-group-item">
        <div style="height: 50px">
            <div style="float: left;width: 6%;margin-bottom: 5px">
                <img width="50px" height="50px" src="http://localhost:8888/GraduationDesign/static/default/${topic.user.avatar}" class="img-rounded">
            </div>
            <div style="width: 89%;float: left">
                <a href="${pageContext.request.contextPath}/t/${topic.id}">${topic.title}</a><br/>
            <div>
                    <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/member/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;&nbsp;
                    <small class="text-muted">${topic.localCreateTime}</small>
                </div>
            </div>
            <div style="width: 5%;float: right;text-align: center">
                <span class="badge">${topic.countReplies}</span>
            </div>
        </div>
    </li>
    </c:forEach>

			</ul>
			</div>
			</div>
			</div>
			</div>
			<div style="padding-top:120px;">
				<%@ include file="../common/footer.jsp"%>
				</div>
</body>
</html>