<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        li {list-style-type:none;}
     
      
        .footer {
            background-color: #393D49;
            margin-top: 10px;
            margin-bottom: 0px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 170px;
            border: 1px ;
            clear:both
        }

        .container1 {
	            margin-left: 20%;
            width: 60%;
            height:140px;
           text-align:center;
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
<footer class="footer">
    <div class="container1">

    <img width="100px" height="50px" src="${pageContext.request.contextPath}/static/default/images/footer.png">
  
 
     <p>致力于提供分享交流的平台</p>
       
        <p>Copyright © 2020 LMY. All Rights Reserved.</p>
         <p>蚌埠学院计算机工程学院毕业设计 ——友情链接
          <a href="www.github.com">Github </a>|
           <a href="www.">Segmentfault </a>|
            <a href="www.v2ex.com">v2ex</a></p>
    
</div>
</footer>
</body>
</html>