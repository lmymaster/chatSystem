<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页界面</title>
</head>

<script>
    function ConfirmDel()
    {
        var r=confirm("确定删除?")
        if (r==true)
        {
            window.location.href="tomain";
        }
        else
        {

        }
    }

</script>

<style>
	li {list-style-type:none;}
  #body	a {text-decoration:none;}
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
.line-limit-length {

 overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 1;
-webkit-box-orient: vertical;
}
</style>

<script>
    setInterval("gun2()",500);
    function gun2() {
        var tag = document.getElementById('i2');
        var content = tag.innerText;
        f = content.charAt(0);
        l = content.substring(1,content.length);
        new_content = l + f;
        tag.innerText = new_content;
    }
   

</script>


<body id ="body" style="background-color:#F5F5F5">
<!--引入header文件 -->
<%@ include file="header1.jsp"%>
	<div class="container">
	  <div class="row">
        <div class="hidden-sm hidden-xs col-xs-12 col-sm-9  col-md-9" style="margin-top:10px;">
          <!-- 引入轮播图 -->
	     <%@ include file="lunbo.jsp"%>
        </div>
        <div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="side.jsp"%>
		 	</div>
      </div>
        <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-9 ">
        <div class="panel panel-default" id="main" style="margin:2% 0% 2% 0%;">
        <div class="panel-heading" style="background-color: #F5F5F5  ;">
        <a href="${pageContext.request.contextPath}/tomain" style="margin-right: 2%;">最新贴</a><a href="${pageContext.request.contextPath}/good" style="margin-right: 2%;">精华贴</a>   
  <div style="float:right;width:600px;"> <strong >公告：</strong> <div style="float:right;color:red;width:540px;" id="i2">您可以转载或引用本站的资讯栏目内容，请注名文章出处，但不得用以任何商业用途 ；</div></div>

       </div>
     <!-- 滚动事件     
	 <div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	 	style="height:500px;overflow:auto; position: relative;">-->
 	<c:if test="${!empty topics.list}">
 	<ul class="list-group" style="width: 100%">
 	 
     <c:forEach items="${topics.list}" var="topic">
     <li class="list-group-item">
        <div style="height: 50px">
            <div style="float: left;width: 6%;margin-bottom: 5px">
                <img width="50px" height="50px" src="http://localhost:8888/GraduationDesign/static/default/${topic.user.avatar}" class="img-rounded">
            </div>
            <div style="width: 89%;float: left">
                <a class="line-limit-length" href="${pageContext.request.contextPath}/t/${topic.id}">${topic.title}</a>
                <c:if test="${topic.top}">      
                   <span class="label label-success">置顶</span>
                 </c:if>
                 <c:if test="${topic.good}">      
                   <span class="label label-success">精华</span>
                 </c:if><br/>
            <div>
                    <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/member/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;&nbsp;
                    <small class="text-muted">${topic.localCreateTime}</small>
                </div>
            </div>
            <div style="width: 5%;float: right;text-align: center">
                <span class="glyphicon glyphicon-comment" aria-hidden="true"> ${topic.countReplies}</span>
            </div>
        </div>
    </li>
    </c:forEach>
    <!-- 分页设置 -->
			<!--  <div class="panel-footer" style="float: right; ">
					<a href="${pageContext.request.contextPath}/paginate/${topics.currentPage==1?1:topics.currentPage-1 }">
						上一页
					</a>
						第${topics.currentPage }页/共${topics.totalPage}页 
					<a href="${pageContext.request.contextPath}/paginate/${topics.currentPage==topics.totalPage?topics.totalPage:topics.currentPage+1 }">
						下一页
					</a>
			</div>
			-->
			 <div class="panel-footer" id="paginate"> </div>
			</ul>
			 
			  </c:if>
			   <c:if test="${empty topics.list}">
                 <ul style="height:500px;">
                 <h3>未找到该板块内容！来发贴吧^-^</h3> 
                 </ul>
   </c:if>
		 	</div>
		 	  
		 	</div> 	
		 	  	    <div class="col-xs-6 col-sm-3 col-md-3 ">
		    <div class="panel panel-default" id="sidebar1" style="margin:7% 0% 1% 2%;">
   				 <div class="panel-heading" style="background-color: #F5F5F5 ;text-align: center;">
    							<strong>   热门电影 	</strong>
    		</div>
    		<ul class="list-group" >
      		  <c:forEach items="${hotestMovies}" var="hotestMovie">
          	  <li class="list-group-item"><a href="${pageContext.request.contextPath}/view/${hotestMovie.id}"><img style="width:100px;height: 100px" src="${pageContext.request.contextPath}/static/default/${hotestMovie.avatar}"></a><strong>${hotestMovie.moviename}</strong></li>
       	 </c:forEach>
    </ul>

</div>
           </div>	
         <c:if test="${topics.totalRow ge 10}">
		    <div class=" col-xs-6 col-sm-3 col-md-3 ">
		    <div class="panel panel-default" id="sidebar1" style="margin:7% 0% 1% 2%;">
   				 <div class="panel-heading" style="background-color: #F5F5F5 ;text-align: center;">
    						<strong>   热门内容</strong>	
    		</div>
    		<ul class="list-group" >
      		  <c:forEach items="${hotestTopics}" var="hotestTopic">
          	  <li class="list-group-item"><a href="${pageContext.request.contextPath}/t/${hotestTopic.id}">${hotestTopic.title}</a></li>
       	 </c:forEach>
    </ul>
     <div class="panel-footer" style="background-color: white;text-align: center;color:">
               <li><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>会员数:   <span class="layui-badge">${usersNum}</span></li>
               <li><span class="glyphicon glyphicon-gift" aria-hidden="true"></span>话题数:    <span class="layui-badge">${topicsNum}</span></li> </div>
</div>
           </div>
          </c:if>
         
            <div>
       <!-- <i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> -->
       <a href="javascript:;" class="backtop" title="回到顶部" style="width:80px; 
         height:80px; position:fixed; right:130px; bottom:10px; "><i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> </a>
    </div>
		 </div>
      </div>
<!-- 引入底文件 -->
		 	<%@ include file="footer.jsp"%>
</body>
<script type="text/javascript">
    var count = ${topics.totalRow};//数据总量
    var limit = ${topics.pageSize};//每页显示的条数
    var url = "${pageContext.request.contextPath}/paginate?p=";//url
    function page() {
        var page = location.search.match(/p=(\d+)/);
        return page ? page[1] : 1;
    }
    var p = page();//当前页数
    paginate(count, limit, p, url);
</script>
</html>