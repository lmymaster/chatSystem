<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息回复系统</title>
</head>
<!--引入header文件 -->
<%@ include file="header1.jsp"%>
<body  style="background-color:#F5F5F5">
<div class="container">
<div class="row">
<div class="col-xs-6 col-sm-9 col-md-9">
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
    <div class="table">
   
    <!-- 遍历评论 -->
       <c:forEach var="reply" items="${replies}">  
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table">
                <tbody>
                <tr>
                    <td width="48" valign="top" align="center">
                        <a href="${pageContext.request.contextPath}/member/${reply.user.username}">
                            <img style="width:60px;height:60px;"  src="${pageContext.request.contextPath}/static/default/${reply.user.avatar} " class="user-avatar img-circle" alt=""/>
                        </a>
                        </td>
                    <td width="10" valign="top"></td>
                    <td width="auto" valign="middle" align="left">
                     
                        <div class="sep3"></div>
                        <strong>
                            <a href="${pageContext.request.contextPath}/member/${reply.user.username}" class="dark">${reply.user.username}</a></strong>
                            在<a href="${pageContext.request.contextPath}/t/${reply.topicId}">${reply.topic.title}</a>中评论了你
                        &nbsp;
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
</div>
		 	</div>
	</div>	
	<div >
	 <%@ include file="footer.jsp"%>
	</div>	
</body>
</html>