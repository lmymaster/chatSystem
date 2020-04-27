<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="format-detection" content="telephone=no" />
    <title>电影 - 电影论坛系统</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/moviesStyle.css" />
    <script type="text/javascript" src="http://localhost:8888/GraduationDesign/static/js/movies/common.js"></script>
    <script type="text/javascript" src="http://localhost:8888/GraduationDesign/static/js/movies/jquery.raty.min.js"></script>
</head>
<body class="qky-xypg" style="background-color:#F5F5F5">
<!--引入header文件 -->
<%@ include file="../common/header1.jsp"%>
<div class="ny-banner"></div>
<div class="content" style="background-color:#F5F5F5">
    <div class="w1000">   
       <h2 class="vedio-tit">
	          观看影片
	   <div class="s-num p-a">播放次数<span>${movies.click}</span>次</div>
	   </h2>
        <!-- 视频 -->
        <div style="border:solid 1px black;height:500px"><video controls="controls" name="media" style="width: 100%; height:100%; object-fit: fill;" ><source src="${pageContext.request.contextPath}/static/default/${movies.address}"></video></div>

        <div class="box-5">
            <ul class="list4">
                <li>
                    <a  class="head-pic"  style="cursor:default"><img style="height: 290px;" src="${pageContext.request.contextPath}/static/default/${movies.avatar}" /></a>
                    <div class="intro" style="width: 690px">
                        <h4 class="s21">${movies.moviename}</h4>
                        <p class="s22">制片地区：<b>${movies.area}</b></p>
                        <p class="s22">上映时间：<b>${movies.upTime}</b></p>
                        <p class="s22">导演：<b>${movies.director}</b></p>
                        <p class="s22">演员：<b>${movies.actor}</b></p>
                        <p class="s23" title="${movies.introduce }">简介：
                            <b>
                    ${movies.introduce}
                            </b>
                        </p>
                    </div>
                    <div style="border-left: 4px solid #e9e7e4; position: absolute;top: 10px;right: 75px;">
                        <p style="margin-left: 10px; font-size: 25px;">影视评分：<span style="color: #0093e8;font-weight: 800;">8.9</span></p>
                    </div>
                </li>
            </ul>
        </div>

        <!-- 发表影评 -->
        <div class="box-6" style="">
            <div >
            <c:if test="${!empty replies}">        
				<div class="panel panel-default" id="main" style="width:100%">
				    <div class="panel-heading" style="background-color: white">
				        <span>
				                ${fn:length(replies)} 回复  |  直到 <c:forEach items="${replies}" var="reply" varStatus="status">
				
				   <c:if test="${status.last}">
				    ${reply.localCreateTime}
				    </c:if>
				    </c:forEach>
				    </span>
				    </div>
				   
				    <ul class="list-19"> <li class="i">
				       <c:forEach var="reply" items="${replies}">  
                   
                        <div>
                            <div class="replay">
                                <div class="img">
                                  <a href="${pageContext.request.contextPath}/member/${reply.user.username}" > <img src="${pageContext.request.contextPath}/static/default/${reply.user.avatar}" class="img-circle"/></a>
                                </div>
                                <div >
                                    <span class="color1"><strong>${reply.user.username}</strong></span>
                                    <p class='p'>${reply.content}</p>
                                    
    
      
       
               
               
           
      
   
               <!-- 二级回复 -->
              <ul class="list-group" style="width: 100%">
                
                  <c:forEach var="secondreply" items="${secondreplies}">   
                   
                       
                      <c:if test="${reply.user.id==secondreply.targetuserId}">  
                      <li class="list-group-item">
                       <div style="height: 50px">           
                        <div style="float: left;width: 6%;margin-bottom: 5px">
                        <a href="${pageContext.request.contextPath}/member/${secondreply.user.username}" >  <img width="50px" height="50px" src="${pageContext.request.contextPath}/static/default/${secondreply.user.avatar} " class="img-circle"></a>
                        </div>
                <div style="width: 89%;float: left">
                <a href="${pageContext.request.contextPath}/member/${secondreply.user.username}"><strong>${secondreply.user.username}</strong></a> &nbsp;&nbsp; 开心的回复了你&nbsp;&nbsp;
                    <small class="text-muted">${secondreply.localCreateTime}</small>  <br/>
                    <div>
                      &nbsp;&nbsp;&nbsp;&nbsp;  <p>${secondreply.content}</p>
                    </div>
                 </div>
                </div>
                 </li>
                </c:if>
                
                     </c:forEach>
                                
                               </ul>
                                    <p><b>${reply.localCreateTime}</b> <c:if test="${!empty user}"><a href="javascript:;" class="color1" onClick="replay(this)">回复</a></c:if></p>
                                </div>
                            </div>
                             <div class="replay-write">
                               <form action="${pageContext.request.contextPath}/reply/add2" method="post">
                                 <input type="hidden" name="moviesId" value="${movies.id}">
                                 <input type="hidden" name="secondreplyUserId" value="${user.id}">
                                  <input type="hidden" name="targetuserId" value="${reply.user.id}">
                                <div class="replay-text">
                                    <textarea name="content"></textarea>
                                    <span><b class="size">0</b>/300</span>
                                </div>
                                <p class="txtr">
                                    <button type="submit" class="btn-replay">回复</button>
                                </p>
                                </form>
                            </div> 
                        </div>
</c:forEach>
                      </li>
                    </ul>
				   
				    </div>
				    </c:if>
				</div>

 <c:if test="${empty replies}">
 <div class="panel panel-default" id="main" style="text-align:center;">
    目前暂无评论
 </div>
 </c:if>


 
  <c:if test="${!empty user}">
   <h2 class="tit-2">发表影评</h2>
    <form action="${pageContext.request.contextPath}/reply/add1" method="post">
         <input type="hidden" name="moviesId" value="${movies.id}">
         <input type="hidden" name="replyUserId" value="${user.id}">   
            <div class="replay-text">
                <textarea  name="content" placeholder="您的影评将是其他观影的参考..."></textarea>
                <span><b class="size">0</b>/300</span>
            </div>
            <p class="txtr">
                <button class="btn-2 btn-2-2">确定</button>
            </p>
            </form>
            </c:if>
        </div>
    </div>
    <a href="javascript:;" class="backtop" title="回到顶部" style="width:80px; 
         height:80px; position:fixed; right:130px; bottom:10px; "><i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> </a>
</div>

<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
<div class="full"></div>
<script>


//    bgiframe("#video");


    var maxstrlen = 300;
    $('textarea').on({
        'keydown':function(e){
            var t = $(e.target);
            var len = t.val().length;
            if(len>maxstrlen){
                t.val(t.val().substring(0, maxstrlen-1));
            };
            t.parent().find('.size').text(len);
        }
    });

    function light(e){
        if($('.full').size()>0){
            $('.full').toggleClass('on');
            //$('.video1').toggleClass('l');

        }
    };


function replay(e){
    var t = $(e).closest('.replay').next();
    if(t.is(':hidden')){
        t.slideDown();
    }else {
        t.hide();
    };
};

</script>

</body>
</html>
