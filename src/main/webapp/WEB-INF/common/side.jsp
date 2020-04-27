<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${empty userId}">
    <!-- 未登录 -->
    <div class="panel panel-default"  style="margin:4% 0% 0% 2%;">
        <div class="panel-heading" style="background-color: white;text-align: center">
            <blockquote>
                BBS论坛系统
                <small>致力于提供一个分享创造的地方</small>
            </blockquote>
              </div>
             
      
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <a  href="${pageContext.request.contextPath}/signin" class="btn btn-primary btn-block">登录</a>
                <a  href="${pageContext.request.contextPath}/signup" class="btn btn-default btn-block">注册</a>
            </li>
           
        </ul>
    </div>
</c:if>

<c:if test="${!empty userId}">
    <!-- 已登录 -->
    <!-- 
    <div class="panel panel-default" id="sidebar2" style="margin:6% 0% 1% 2%;">
        <div class="panel-heading" style="background-color: #6495ED;text-align: center;">
            <a href="${pageContext.request.contextPath}/member/${user.username}" style="color:white;">${user.username}</a>
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/new">创作新主题</a></li>
             <li class="list-group-item"><a href="${pageContext.request.contextPath}/getOwnList">我的主题</a></li>
              <li class="list-group-item"><a href="${pageContext.request.contextPath}/collect/topics">我的收藏(${collectTopicNum}条)</a></li>
            <li class="list-group-item" ><a href="${pageContext.request.contextPath}/notice/list"><span id="notice">0</span>条未读提醒</a></li>
            <li class="list-group-item"><a href="#">积分:${user.credit}</a></li>
        </ul>
    </div> -->
    <div class="panel-body" style="margin-top:10px;height:220px;background-color: white">
				<div class="media">
					<div class="media-left">
						<a href="#"> 
						<img style="width:50px;height:50px;"	src="${pageContext.request.contextPath}/static/default/${user.avatar}" title=""
							class="user-avatar img-circle">
						</a>
					</div>
					<div class="media-body">
						<div class="media-heading">
							<strong><a href="#">${user.username}</a></strong>
							<div style="color: #7A7A7A; font-size: 13px; margin-top: 5px;">
							  <i>个性签名：愿世间美好与你环环相扣   <i style="color:red;font-size:14px;"> ♥</i></i>
							</div>
						</div>
					</div>
					<div style="margin-top: 25px;">
						<a href="${pageContext.request.contextPath}/new" style="font-size: 12px;"><button
								class="btn btn-primary">创建新主题</button></a>
					</div>
				</div>
				<div class="sep15" style="height: 10px;"></div>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="table_fade" style="font-size: 14px;">
					<tbody>
						<tr>
							<td width="33%" align="center"><a href="${pageContext.request.contextPath}/getOwnList"
								class="dark" style="display: block;"><span class="bigger">${topicsNumofuser}</span>
									<div class="sep3"></div> <span>我的主题</span></a></td>
							<td width="34%"
								style="border-left: 1px solid rgba(100, 100, 100, 0.4); border-right: 1px solid rgba(100, 100, 100, 0.4);"
								align="center"><a href="${pageContext.request.contextPath}/collect/topics" class="dark"
								style="display: block;"><span class="bigger">${collectTopicNum}</span>
									<div class="sep3"></div> <span>我的收藏</span></a></td>
							<td width="33%" align="center"><a href="javascript:;" data-toggle="modal" data-target="#myModal"
								class="dark" style="display: block;"><span>${followUserNum}</span>
									<div class="sep3"></div> <span >特别关注</span></a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer" style="background-color: white">
				<div class="row">
					<span class="col-md-6"><a href="${pageContext.request.contextPath}/notice/list"><span
							id="notice">0</span> 条未读消息</a></span> <span class="col-md-6 text-right">积分：<a
						href="#">${user.credit}</a></span>
				</div>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">
									特别关注
								</h4>
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								
							</div>
							<div class="modal-body">
	<ul>
		                    <c:forEach items="${follows}" var="follow">
		                  
						        <li class="list-group-item">
						            <div style="height: 50px">
						                <div style="float: left;width: 5%;margin-bottom: 5px">
						                   <a href="${pageContext.request.contextPath}/member/${follow.user.username}"> <img width="50px" height="50px" src="${pageContext.request.contextPath}/static/default/${follow.user.avatar} " class="img-rounded"></a>
						                </div>
						                <div style="width: 89%;float: right">
						                    <a href="${pageContext.request.contextPath}/member/${follow.user.username}"><strong>${follow.user.username}</strong></a>&nbsp;&nbsp;
						                
											<button onclick="actionBtn(${follow.fid});" class="btn btn-xs btn-primary">
					                     	 取消特别关注
					                  	</button>
						                </div>
						            </div>
						        </li>
       						 </c:forEach>
       						 </ul>
							</div>
							
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>
			
</c:if>
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
 	
 	 function actionBtn(id){
    	 var r=confirm("确定取消关注吗?")
         if (r==true)
         {
             window.location.href="${pageContext.request.contextPath}/follow/delete1?id="+id;
         }
         else
         {

         }
     
    }
 	
 	</script>

