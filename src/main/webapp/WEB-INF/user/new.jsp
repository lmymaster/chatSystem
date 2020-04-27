<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="static/default/css/bootstrap.css" rel="stylesheet">
    <script src="static/default/js/jquery-1.11.3.min.js"></script>
    <script src="static/default/js/bootstrap.js"></script>
    <!-- 引入富文本js文件 -->
      <script src="http://localhost:8888/GraduationDesign/static/js/new.js"></script>
    <title>创作新主题 › BBS</title>
</head>
<body>
<!--引入header文件 -->
	<%@ include file="../common/header1.jsp"%>
<div class="container">
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading"><a href="${pageContext.request.contextPath}/tomain">首页</a> / 创建新主题</div>
            <div class="panel-body">
                <form action="topic/add" method="post"  enctype="multipart/form-data">

                    <%--标题--%>
                     <div class="form-group" >
	                    <label for="title">主题标题</label>
	                    <input type="text" class="form-control" id="title" name="title" placeholder="请输入主题标题，如果标题能够表达完整内容，则正文可以为空" required="required">
                     </div>
                    

                   <!--   <div class="form-group">
                    <label for="content">正文</label>
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>-->
                
                  <%--正文（富文本编辑器）--%>
                   <div class="form-group">
					<label for="content">正文</label>
				    <div class="min800 inline-block" style="width:800px;" id="editor"></div>
				   <input type="hidden" name="content" id="editor_txt">

                </div>

                    <div class="form-group">
                    <label for="tab">板块</label><br/>
                    <div class="col-sm-10" style="width: 40%">
                        <select class="form-control" id="tab" name="tab">
                            <c:forEach items="${tabs}" var="tab">
                            <option value="${tab.id}">${tab.tabName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success  btn-sm" value="发布主题" style="float:right;" id="btn_re">
                </div>

                  
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-3 hidden-sm hidden-xs">
        <div class="panel panel-default">
            <div class="panel-heading">
                <b>帖子发布指南</b>
            </div>
            <div class="panel-body">
                <p>• 在标题中描述内容要点。如果一件事情在标题的长度内就已经可以说清楚，那就没有必要写正文了。</p>
                <p>• 请清楚地表达所要说明的内容。。</p>
                <p>• 如果是转载的帖子，请务必只填上原文的URL，内容就不用复制过来了。</p>
                <p>• 请为你的主题选择一个板块。恰当的归类会让你发布的信息更加有用。</p>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><b>BBS社区指导原则</b></div>
            <div class="panel-body">
               <h5>尊重原创</h5>
                <p>• 请不要发布任何盗版下载链接，包括软件、音乐、电影等等。</p>
               <h5>友好互助</h5>
                <p>• 保持对陌生人的友善。用知识去帮助别人</p>

                  </div>
            </div>
        </div>
    </div>
</div>

<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
<script>
    function submitValidate(flag){
        return flag;
    }
    $("#btn_re").click(function () {
        if($("#title").val()==''){
        	toastr.warning("未写标题");
            return submitValidate(false);
        }else {
            var ifSubmit=confirm("确定发表该主题吗?");
            if (ifSubmit == true){

            }else {
                return submitValidate(false);
            }
        }
    })
</script>
</body>
</html>