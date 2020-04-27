<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="../layout/header.jsp"%>
<script>
	$(function(){
    $("#btn1").click(function () {
            var ifSubmit=confirm("确定更新内容?");
            if (ifSubmit == true){
				
            }else {
                return false;
            }
        
    })
	});
</script>
<!-- 内容主体区域 -->
<div class="content-wrapper" style="padding: 0 px 0 40px;">
   <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>话题编辑</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item ">话题</li>
               <li class="breadcrumb-item active">编辑</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
     
      </div>
      <!-- /.box-header -->
      <div class="box-body">
        <form id="commentfrom" action="${pageContext.request.contextPath}/admin/topic/update?id=${id}" method="post">
           <div class="form-group" style="margin-bottom: 10px;">
          	<label>title:</label><input type="text" name="title" value="${title}" class="form-control" >
          </div>
          <div class="form-group" style="margin-bottom: 10px;">
          	<div class="form-group">
           <!-- 富文本编辑器 -->
				   <label>content:</label> <div class="min800 inline-block" style="width:100%;" id="editor"></div>
				   <input type="hidden" name="content"  id="editor_txt">
          	</div>
            <button type="submit" class="btn btn-primary btn-sm" id="btn1">更新评论</button>
          </div>
        </form>
      </div>
    </div>
  </section>

 
</div>
<%@ include file="../layout/footer.jsp"%>

<script>
$(function () {
	  var E = window.wangEditor;
      var editor = new E('#editor');
    //开启debug模式
  	editor.customConfig.debug = true;
  	// 关闭粘贴内容中的样式
  	editor.customConfig.pasteFilterStyle = false
  	// 忽略粘贴内容中的图片
  	editor.customConfig.pasteIgnoreImg = true
  	// 使用 base64 保存图片
  	//editor.customConfig.uploadImgShowBase64 = true
      editor.customConfig.showLinkImg = false; //隐藏‘网络图片’的按钮 
      editor.customConfig.uploadImgServer = 'http://localhost:8888/GraduationDesign/upload' // 上传图片到服务器
      editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024; // 将图片大小限制为 2M
      editor.customConfig.uploadImgMaxLength = 5; // 限制一次最多上传 5 张图片
      editor.customConfig.uploadFileName = 'myFileName';
      editor.customConfig.uploadImgTimeout = 30000; // 将 timeout 时间改为 3s
   /* editor.customConfig.menus = [
          'bold',
          'italic',
          'underline',
          'strikeThrough',
          'link', // 插入链接
          'list', // 列表
          'quote', // 引用
          'image', // 插入图片
          'undo', // 撤销
          'redo' // 重复
      ]   */
    //自定义上传图片事件
      editor.customConfig.uploadImgHooks = {
          before: function (xhr, editor, files) {
   
          },
          success: function (xhr, editor, result) {
              console.log("上传成功");
          },
          fail: function (xhr, editor, result) {
              console.log("上传失败,原因是" + result);
          },
          error: function (xhr, editor) {
              console.log("上传出错");
          },
          timeout: function (xhr, editor) {
              console.log("上传超时");
          },
          
      };
      // 或者 var editor = new E( document.getElementById('editor') )

      editor.create();
      editor.txt.html('${content}');
      document.getElementById('btn1').addEventListener('click', function () {
          // 读取 html
          var editor_txt=editor.txt.html();
          document.getElementById('editor_txt').value=editor_txt;
      }, false)  


     
});
</script>