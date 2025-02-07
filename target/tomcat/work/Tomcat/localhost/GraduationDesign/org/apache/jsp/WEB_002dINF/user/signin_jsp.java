/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-24 15:40:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>登录</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"static/default/css/bootstrap.css\">\r\n");
      out.write("\t<script src=\"static/default/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("\t<script src=\"static/default/js/bootstrap.js\"></script>\r\n");
      out.write("\t<script src=\"static/default/js/js.cookie.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<style>\r\n");
      out.write("        li {list-style-type:none;}\r\n");
      out.write("        html, body {\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #525252;\r\n");
      out.write("            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,\"Microsoft Yahei\",\"Hiragino Sans GB\",\"WenQuanYi Micro Hei\",sans-serif;\r\n");
      out.write("            background: #f0f2f5;\r\n");
      out.write("        }\r\n");
      out.write("        .footer {\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            margin-top: 22px;\r\n");
      out.write("            margin-bottom: 22px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding-top: 22px;\r\n");
      out.write("            color: #8A8A8A;\r\n");
      out.write("            display: block;\r\n");
      out.write("            height: 200px;\r\n");
      out.write("            border: 1px ;\r\n");
      out.write("            clear:both\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            margin-right: 5%;\r\n");
      out.write("            margin-left: 5%;\r\n");
      out.write("            padding-left: 15px;\r\n");
      out.write("            padding-right: 15px;\r\n");
      out.write("            width: 40%;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        .info {\r\n");
      out.write("            margin-right: 5%;\r\n");
      out.write("            width: 10%;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        a{\r\n");
      out.write("            color: #8A8A8A;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"panel panel-default\" id=\"login\" style=\"width: 20%;margin-left: 40%;margin-top: 10%;margin-bottom: 5%\">\r\n");
      out.write("    <div class=\"panel-heading\" style=\"background-color: #fff\">\r\n");
      out.write("        <h3 class=\"panel-title\">登录</h3>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"panel-body\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"username\">用户名</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"请输入用户名\" required=\"required\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"password\">密码</label>\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" id=\"passwd\" name=\"password\" placeholder=\"请输入密码\" required=\"required\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"checkbox text-left\">\r\n");
      out.write("            <label>\r\n");
      out.write("                <input type=\"checkbox\" id=\"remember\">记住密码\r\n");
      out.write("            </label>\r\n");
      out.write("            <a style=\"margin-left: 30%\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/adminlogin\">后台登录</a>/<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/signup\">\r\n");
      out.write("        注册</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <p style=\"text-align: right;color: red;position: absolute\" id=\"info\"></p><br/>\r\n");
      out.write("            <button id=\"loginButton\" class=\"btn btn-success btn-block\">登录</button>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(\"#passwd\").keyup(\r\n");
      out.write("        function () {\r\n");
      out.write("            if(isNaN($(\"#passwd\").val())){\r\n");
      out.write("                $(\"#info\").text(\"提示:密码只能为数字\");\r\n");
      out.write("            }\r\n");
      out.write("            else {\r\n");
      out.write("                $(\"#info\").text(\"\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    )\r\n");
      out.write("    // 记住登录信息\r\n");
      out.write("    function rememberLogin(username, password, checked) {\r\n");
      out.write("        Cookies.set('loginStatus', {\r\n");
      out.write("            username: username,\r\n");
      out.write("            password: password,\r\n");
      out.write("            remember: checked\r\n");
      out.write("        }, {expires: 30, path: ''})\r\n");
      out.write("    }\r\n");
      out.write("    // 若选择记住登录信息，则进入页面时设置登录信息\r\n");
      out.write("    function setLoginStatus() {\r\n");
      out.write("        var loginStatusText = Cookies.get('loginStatus')\r\n");
      out.write("        if (loginStatusText) {\r\n");
      out.write("            var loginStatus\r\n");
      out.write("            try {\r\n");
      out.write("                loginStatus = JSON.parse(loginStatusText);\r\n");
      out.write("                $('#username').val(loginStatus.username);\r\n");
      out.write("                $('#passwd').val(loginStatus.password);\r\n");
      out.write("                $(\"#remember\").prop('checked',true);\r\n");
      out.write("            } catch (__) {}\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    // 设置登录信息\r\n");
      out.write("    setLoginStatus();\r\n");
      out.write("    $(\"#loginButton\").click(function () {\r\n");
      out.write("        var username =$(\"#username\").val();\r\n");
      out.write("        var passwd=$(\"#passwd\").val();\r\n");
      out.write("        var remember=$(\"#remember\").prop('checked');\r\n");
      out.write("        if( username=='' && passwd==''){\r\n");
      out.write("            $(\"#info\").text(\"提示:账号和密码不能为空\");\r\n");
      out.write("        }\r\n");
      out.write("        else if ( username ==''){\r\n");
      out.write("            $(\"#info\").text(\"提示:账号不能为空\");\r\n");
      out.write("        }\r\n");
      out.write("        else if( passwd ==''){\r\n");
      out.write("            $(\"#info\").text(\"提示:密码不能为空\");\r\n");
      out.write("        }\r\n");
      out.write("        else {\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                url: \"logincheck\",\r\n");
      out.write("                data: {\r\n");
      out.write("                    username:username ,\r\n");
      out.write("                    password: passwd\r\n");
      out.write("                },\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                success: function(data) {\r\n");
      out.write("                    if(data.stateCode.trim() == \"0\") {\r\n");
      out.write("                        $(\"#info\").text(\"提示:用户名不存在!\");\r\n");
      out.write("                    } else if(data.stateCode.trim() == \"1\") {\r\n");
      out.write("                        $(\"#info\").text(\"提示:密码错误!\");\r\n");
      out.write("                    }  else if(data.stateCode.trim() == \"3\") {\r\n");
      out.write("                        $(\"#info\").text(\"提示:邮箱未进行验证!\");\r\n");
      out.write("                    } else if(data.stateCode.trim() == \"4\") {\r\n");
      out.write("                        $(\"#info\").text(\"提示:管理员不在此登录!\");\r\n");
      out.write("                    }else if(data.stateCode.trim() == \"2\"){\r\n");
      out.write("                        if(remember){\r\n");
      out.write("                            rememberLogin(username,passwd,remember);\r\n");
      out.write("                        }else {\r\n");
      out.write("                            Cookies.remove('loginStatus');\r\n");
      out.write("                        }\r\n");
      out.write("                        $(\"#info\").text(\"提示:登陆成功，跳转中...\");\r\n");
      out.write("                        window.location.href=\"tomain\";\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
