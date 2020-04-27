<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>登录</title>
<!--  	<link rel="stylesheet" type="text/css" href="static/default/css/bootstrap.css">
	<script src="static/default/js/jquery-1.11.3.min.js"></script>
	<script src="static/default/js/bootstrap.js"></script>
	<script src="static/default/js/js.cookie.js"></script>

	<style>
        li {list-style-type:none;}
        html, body {
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
            background:#AAAAAA ;
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
<body >
<div class="panel panel-default" id="login" style="width: 20%;margin-left: 40%;margin-top: 10%;margin-bottom: 5%">
    <div class="panel-heading" style="background-color:#F5F5F5 ">
        <h3 class="panel-title" style="text-align:center">SSM 后台管理</h3>
    </div>
    <div class="panel-body">

       <div class="form-group has-feedback">
          <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
          <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
          <input type="password" class="form-control" id="password" name="password" placeholder="密码">
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <button id="loginButton" class="btn btn-primary btn-block">登录</button>

    </div>
</div>-->
  <!-- Font Awesome -->
  <link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/admintle/plugins/fontawesome-free/css/all.min.css">
 
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/admintle/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="http://localhost:8888/GraduationDesign/static/admintle/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
<!-- jQuery -->
<script src="http://localhost:8888/GraduationDesign/static/admintle/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="http://localhost:8888/GraduationDesign/static/admintle/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="http://localhost:8888/GraduationDesign/static/admintle/dist/js/adminlte.min.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box" style="margin-top: 10%;margin-bottom: 20%">
  <div class="login-logo">
  <b>BBS</b>后台管理系统
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">进入管理系统</p>

  
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" id="password" name="password" placeholder="密码">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
           
                <p style="text-align: right;color: red;position: absolute" id="info"></p>
            
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button  id="loginButton" class="btn btn-success btn-block">登录</button>
          </div>
          <!-- /.col -->
        </div>
    
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->



<script>
    $("#password").keyup(
        function () {
            if(isNaN($("#password").val())){
                $("#info").text("提示:密码只能为数字");
            }
            else {
                $("#info").text("");
            }
        }
    )
    // 记住登录信息
  
    $("#loginButton").click(function () {
        var username =$("#username").val();
        var passwd=$("#password").val();
        if( username=='' && passwd==''){
            $("#info").text("提示:账号和密码不能为空");
        }
        else if ( username ==''){
            $("#info").text("提示:账号不能为空");
        }
        else if( passwd ==''){
            $("#info").text("提示:密码不能为空");
        }
        else {
            $.ajax({
                type: "POST",
                url: "logincheck",
                data: {
                    "username":username ,
                    "password": passwd
                },
                dataType: "json",
                success: function(data) {
                    if(data.stateCode.trim() == "0") {
                        $("#info").text("提示:用户名不存在!");
                    } else if(data.stateCode.trim() == "1") {
                        $("#info").text("提示:密码错误!");
                    } else if(data.stateCode.trim() == "4"){
                        $("#info").text("提示:登陆成功，跳转中...");
                        window.location.href="toadminmain";
                    }
                }
            });
        }
    })
</script>
</body>
</html>