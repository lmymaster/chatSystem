<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影界面</title>
 <!-- 电影界面引入的css和js -->   
 <link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/moviesStyle.css" />
  <script type="text/javascript" src="http://localhost:8888/GraduationDesign/static/js/movies/common.js"></script>

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

</style>

<body style="background-color:#F5F5F5">
<!--引入header文件 -->
<%@ include file="../common/header1.jsp"%>
	<div class="container">
	  <div class="row">
        <div class="hidden-sm hidden-xs col-xs-12 col-sm-9  col-md-9" style="margin-top:10px;">
          <!-- 引入轮播图 -->
	     <%@ include file="../common/lunbo1.jsp"%>
        </div>
       <div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="../common/side.jsp"%>
		 	</div>
      </div>
        <div class="row">
     	 <div class="cont-wrap cont-wrap-ny col-xs-12 col-sm-5  col-md-5	">
			  <div class="cont-wrap-2 cont-wrap-last">
			    <div class="w1000">
			      <div class="mskt-box skms-box">
			
			        <div class="mskt-right-list f-l sx-home-wrap">
			          <h3 class="sx-tit">
			            <span style="font-weight:bold">视频列表</span>
			          </h3>
			          <ul class="list-chair ztjz-chair " style="margin-left: 0px;">
			           <c:forEach items="${movies}" var="movie">
			            <li>
			              <div class="top"><img style="height: 250px" src="static/default/${movie.avatar}"> </div>
			              <p class="mid "><span class="f-l hid-t">${movie.moviename}</span><a class="try-l f-r" href="${pageContext.request.contextPath}/view/${movie.id}">观看</a></p>
			              <p class="bot"><span class="f-r">观看次数：<em>${movie.click}</em></span></p>
			            </li>
			           <!--  <li>
			              <div class="top"><img style="height: 250px" src="static/default/images/movies/Peter.jpg"> </div>
			              <p class="mid "><span class="f-l hid-t">Peter</span><a class="try-l f-r">观看</a></p>
			              <p class="bot"><span class="f-l">评分：<em style="color: #e95b0e;font-style: normal;">8</em></span><span class="f-r">观看次数：<em>123</em></span></p>
			            </li>
			            <li>
			              <div class="top"><img style="height: 250px" src="static/default/images/movies/Civil_War.jpg"> </div>
			              <p class="mid "><span class="f-l hid-t">Civil War</span><a class="try-l f-r">观看</a></p>
			              <p class="bot"><span class="f-l">评分：<em style="color: #e95b0e;font-style: normal;">8</em>  </span><span class="f-r">观看次数：<em>123</em></span></p>
			            </li>
			            <li>
			              <div class="top"><img style="height: 250px" src="static/default/images/movies/x-man.jpg"> </div>
			              <p class="mid "><span class="f-l hid-t">X-Men</span><a class="try-l f-r">观看</a></p>
			              <p class="bot"><span class="f-l">评分：<em style="color: #e95b0e;font-style: normal;">8</em></span><span class="f-r">观看人数：<em>123</em></span></p>
			            </li>
			            --> 
			            </c:forEach>
			          </ul>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
     
  

		   
            <div>
       <!-- <i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> -->
       <a href="javascript:;" class="backtop" title="回到顶部" style="width:80px; 
         height:80px; position:fixed; right:130px; bottom:10px; "><i class="layui-icon layui-icon-top" style="font-size: 80px; color: #1E9FFF;"></i> </a>
    </div>
		 </div>
      </div>
<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
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