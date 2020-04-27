<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传头像</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/bootstrap.css">
<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
</head>
<style>
	li {list-style-type:none;}

     .container {
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
</style>

<body style="background-color:#F5F5F5">
	<!--引入header文件 -->
	<%@ include file="../common/header1.jsp"%>
	<div class="container">
        <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-9 ">
        <div class="panel panel-default" id="main" style="margin:2% 0% 10% 0%;">
        <div class="panel-heading" style="background-color: white">
       <a href="${pageContext.request.contextPath}/tomain">首页</a> |设置 ›头像上传
         </div>
         <div class="panel-body">
         <!--上传文件  表单上传  -->
            <form  enctype="multipart/form-data" method="post" class="form-horizontal" id="uploadForm">
                <div style="margin-left: 17%">
                    <img width="60px" height="60px" src="${pageContext.request.contextPath}/static/default/${user.avatar}" class="img-rounded">
                    <input type="file"   id="file" name="avatar" accept="image/png,image/jpeg,image/jpg" >
                    <br/>
				         <input class="btn btn-default" onclick="submitXML()" type="button" value="上传头像">
				           
                </div>
            </form>
         
        </div>
		 	</div>
		 	</div>
		 	<div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="../common/side.jsp"%>
		 	</div>
		 	
		    <div class=".col-md-offset-9  col-xs-6 col-sm-3 col-md-3 ">
		    <div class="panel panel-default" id="sidebar1" style="margin:7% 0% 1% 2%;">
   				 <div class="panel-heading" style="background-color: white;text-align: center">
    							   热门图文
    		</div>
    		<ul class="list-group" >
      		  <c:forEach items="${hotestTopics}" var="hotestTopic">
          	  <li class="list-group-item"><a href="t/${hotestTopic.id}">${hotestTopic.title}</a></li>
       	 </c:forEach>
    </ul>
</div>
           </div>
		 </div>
      </div>
<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
		 	<script>	
		
		 	function submitXML(){
		 		var formData = new FormData($('#uploadForm')[0]); 
		 		var fileInput = $('#file').get(0).files[0];       //获取文件内容
		 		console.info(fileInput);
		 		if(fileInput){
		 			//$("#uploadForm").submit();    //表单提交的方法
		 		    $.ajax({ 
		                type: 'post', 
		                url: "${pageContext.request.contextPath}/settings/avatar/update", //上传文件的请求路径必须是绝对路劲
		                data: formData, 
		                cache: false, 
		                processData: false, 
		                contentType: false, 
		            }).success(function (data) { 
		            	if(data.result.trim() == "0") {
	                		  toastr.success("图片上传成功");         
	                        
	                	  } 
	                	  setTimeout(function () {
	                          window.location.href="${pageContext.request.contextPath}/settings/avatar";

	                      }, 900);	
		           }).error(function () { 
		                alert("上传失败"); 
		       }); 
		 		
		 		}else{
		 			 toastr.info("请选择上传文件");
		 		}
		 	}
		 	
		 	
		 	</script>
</body>
</html>