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
       
        document.getElementById('btn_re').addEventListener('click', function () {
            // 读取 html
        	if(editor.txt.text()==""){ 
        		 alert("回复内容不能为空");
       	 }else{
       		var editor_txt=editor.txt.html();      
            document.getElementById('editor_txt').value=editor_txt;
            $("#reply").submit(); 
       		 }
           
           
        }, false)  

       
  });