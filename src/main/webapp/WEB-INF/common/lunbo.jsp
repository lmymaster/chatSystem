<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>轮播图</title>
  <script>
	layui.use('carousel', function(){
  	var carousel = layui.carousel; 
  	//建造实例
  	carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    //,anim: 'updown' //切换动画方式,默认左右切换
  });
});
  </script>
  <style>
	.layui-carousel img{
	width:100%;
	height:100%;
	}
	</style>
</head>
<body>	
	<!-- 轮播图 -->
	<div class="layui-carousel" id="test1">
	  <div carousel-item>
	         <c:forEach items="${lunbolist}" var="lunbo">
	     	<c:if test="${lunbo.type eq 0}">
	 <div>  <img src="${pageContext.request.contextPath}/${lunbo.avatar}"></div>
	    </c:if>
	    </c:forEach>
	  </div>
	</div>
<!-- 条目中可以是任意内容，如：<img src=""> -->

	

</body>
</html>