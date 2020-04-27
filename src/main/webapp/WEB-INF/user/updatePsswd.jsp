<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/default/static/css/bootstrap.css">
<script src="http://localhost:8888/GraduationDesign/static/default/js/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8888/GraduationDesign/static/default/js/bootstrap.js"></script>
</head>

<style>
	li{list-style-type:none;}

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
        <div class="panel-heading" style="background-color: #6495ED">
       <a href="${pageContext.request.contextPath}/tomain" style="color:white;">首页</a> › 更改密码
         </div>

        <div class="panel-body">
         <div class="form-horizontal" >
					   <div class="form-group">
                                <label for="password1" class="col-sm-2 control-label" style="color:#313335;">密码</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password1" name="password" required pattern="^\w{3,20}$" minlength="6" maxlength="12" placeholder="6-12位数字与字母的结合">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password2" class="col-sm-2 control-label" style="color:#313335;">确认密码</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password2" required pattern="^\w{3,20}$" minlength="6" maxlength="12" placeholder="6-12位数字与字母的结合">
                                </div>
                            </div>  
                            	   			      
					   <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <!--  <button  type="submit" class="btn btn-warning" onclick="return confirmUpdate();">修改</button>-->
					      <button  class="btn btn-warning" id="confirmUpdate">修改</button>
					    </div>
					  </div>
					</div>
                
                
         </div>
		 	</div>
		 	</div>
		 	<div class="col-xs-6 col-sm-3 col-md-3">
		 	<!-- 引入侧文件 -->
		 	<%@ include file="../common/side.jsp"%>
		 	</div>
		 	
		    <div class=".col-md-offset-9  col-xs-6 col-sm-3 col-md-3 ">
		    <div class="panel panel-default" id="sidebar1" style="margin:7% 0% 1% 2%;">
   				 <div class="panel-heading" style="background-color: #6495ED;text-align: center;color:white;">
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
       <script>
      /*   function  confirmUpdate(){
        var p1=$("#password1").val();//获取密码框的值
        var p2=$("#password2").val();//获取重新输入的密码值
        if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
        	toastr.warning("两次密码不一致");
            
            return false;
        }else if(p1=='' && p2==''){
        	toastr.warning("密码不能为空");
          
             return false;
        }else{
        	var msg = "确定要修改吗？";
            if(confirm(msg)==true){
            toastr.success("密码修改成功");
            }else{
        
             return false;
            }
        }
    }
      */
      $("#confirmUpdate").click(function () {
    	  var p1=$("#password1").val();//获取密码框的值
          var p2=$("#password2").val();//获取重新输入的密码值
          if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
          	toastr.warning("两次密码不一致");
              
            
          }else if(p1=='' && p2==''){
          	toastr.warning("密码不能为空");
             
          }else{
              $.ajax({
                  type: "POST",
                  url: "${pageContext.request.contextPath}/update1",
                  data: {   
                      password: p1
                  },
                  dataType: "json",
                  success: function(data) {
                	  if(data.result.trim() == "0") {
                		  toastr.success("修改密码成功");         
                        
                	  } 
                	  setTimeout(function () {
                          window.location.href="tomain";

                      }, 900);	
                      },
                   	   error: function () { //失败，回调函数
                   	 	alert("出错了");
                   	 	}
                  
              });
          }
      })
</script>
<!-- 引入底文件 -->
		 	<%@ include file="../common/footer.jsp"%>
</body>
</html>