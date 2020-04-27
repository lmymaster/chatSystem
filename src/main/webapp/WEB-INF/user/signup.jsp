<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
	<link rel="stylesheet" type="text/css" href="static/default/css/bootstrap.css">
	<script src="static/default/js/jquery-1.11.3.min.js"></script>
	<script src="static/default/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="http://localhost:8888/GraduationDesign/static/default/css/toastr.css">
    <script src="http://localhost:8888/GraduationDesign/static/js/toastr.js"></script>
    <script src="http://localhost:8888/GraduationDesign/static/default/js/toastr.min.js"></script>
<style>
        li {list-style-type:none;}
        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
            background: #f0f2f5;
        }
        .footer {
            background-color: #fff;
            margin-top: 22px;
            margin-bottom: 22px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 200px;
            border: 1px ;
            clear:both
        }

        .container {
            margin-right: 5%;
            margin-left: 5%;
            padding-left: 15px;
            padding-right: 15px;
            width: 40%;
            float: left;
        }
        .info {
            margin-right: 5%;
            width: 10%;
            float: left;
        }
        a{
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
   
</head>
<body>
<div class="panel panel-default" id="login" style="width: 55%;margin-left: 10%;margin-top: 5%;margin-bottom: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">用户注册</h3>
    </div>
    <div class="panel-body">
        <div class="form-horizontal"  style="margin-left: 5%">
            <div class="form-group" >
                <label class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="text" class="form-control" id="username" name="username" required="required">
                    <p class="form-control-static">请使用半角的 a-z 或数字 0-9</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="password" class="form-control" id="password" name="password" required="required">
                </div>
            </div>
   
            <div class="form-group">
                <label class="col-sm-2 control-label">国际电话区号</label>
                <div class="col-sm-10" style="width: 40%;">
                    <select class="form-control" id="areaCode" name="areaCode">
                        <option value="86">+86</option>
                        <option value="85">+85</option>
                        <option value="84">+84</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="tel" class="form-control" id="tel" name="tel" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">电子邮件</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="email" class="form-control" id="email" name="email" required="required">
                </div>
            </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">电子邮件验证码</label>
                <div class="col-sm-8" style="width:40%;">
                    <input  class="form-control" id="emailvarify" name="emailvarify" required="required">
                </div>
   
            </div>
            <div style="margin-left:200px">
            <button  id="signupForm" class="btn btn-success">登录</button>
			<button type="reset" class="btn btn-info">重置</button>
			</div>
        </div>
        <br/>
        <div ><button onclick="getVarify();" class="btn btn-success">获取邮箱验证码</button></div>
    </div>
</div>
 <script>
    $("#signupForm").click(function () {
    	var username =$("#username").val();
    	var password =$("#password").val();
    	var email =$("#email").val();
    	var tel =$("#tel").val();
    	var emailvarify =$("#emailvarify").val();
        if(username==''||password==''||email==''||tel==''){
        	 toastr.warning("请将注册信息填写完整");
        }else if(emailvarify==''){
        	 toastr.warning("请先获取邮箱验证码");
        }else{
        	$.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/register",
                data: {   
                    email: email,
                    username:username,
                    password:password,
                    tel:tel,
                    emailvarify:emailvarify
                },
                dataType: "json",
                success: function(data) {      
              	  if(data.result.trim() == "1") {
              		  toastr.error("邮箱验证失败，检查输入是否错误");         
              	  } else if(data.result.trim() == "2"){
              		toastr.error("未进行验证,请获取验证码");  
              		//console.log("啥问题啊");
              	  }else if(data.result.trim() == "0"){
              		  toastr.success("邮箱验证成功");
              	 	  setTimeout(function () {
                        window.location.href="${pageContext.request.contextPath}/signin";

                    }, 900);
              	  }
             	
                    },
                 	   error: function () { //失败，回调函数
                 	 	alert("出错了");
                 	 	}
                
            });
        }
    })
</script>
<script>
    function getVarify()
    { 
    	var emailvarify =$("#emailvarify").val();
    	var email =$("#email").val();
    	var emailType =/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;  //验证邮箱格式
    	 if($("#username").val()==''||$("#password").val()==''||$("#tel").val()==''){
    		 toastr.warning("请将注册信息填写完整");
    	 }else if($("#email").val()==''){
        	toastr.warning("请填写邮箱，才能验证");
    	}else if(!emailType.test(email)){
    		toastr.warning("邮箱格式不正确，请正确填写");
    	}else{
    		//window.location.href="${pageContext.request.contextPath}/verify?email="+$("#email").val();
    		$.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/verify",
                data: {   
                    email: email
                },
                dataType: "json",
                success: function(data) {
              	  if(data.result.trim() == "0") {
              		  toastr.success("邮箱验证码发送成功，等待验证");         
              	  } 
                    },
                 	   error: function () { //失败，回调函数
                 	 	alert("出错了");
                 	 	}
                
            });
    	}
            
    
    }
    
</script>
</body>
</html>