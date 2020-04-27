package com.limingyi.controller.wangeditor;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.limingyi.entity.Result;
import com.limingyi.util.ResultUtil;

@Controller
public class wangEditor {
	   @CrossOrigin        //解决跨域问题
	    @RequestMapping(value = "/upload",method = RequestMethod.POST)
	    @ResponseBody
	    public Result uploadImage(@RequestParam(value="myFileName") MultipartFile myFileName, HttpSession session, HttpServletRequest request) throws IllegalStateException, IOException
	    {
	        String realPath = "";// 存储的真实路径
	        String uploadFileName = "";
	        if(myFileName != null)
	        {
	            System.out.println("'进入函数'");
	            String filename = myFileName.getOriginalFilename();
	            String[] names=filename.split("\\.");//
	            String tempNum=(int)(Math.random()*100000)+"";
	             uploadFileName = tempNum +System.currentTimeMillis()+"."+names[names.length-1];
	            // 生成实际存储的真实文件名
	             realPath = "C:\\Users\\李明义\\eclipse-workspace\\GraduationDesign\\src\\main\\webapp\\static\\uploadImages"+"\\"+uploadFileName;
	            System.out.println(realPath);
	            File uploadFile = new File(realPath);
	            myFileName.transferTo(uploadFile);
	        }
	        // str:返回图片存储在服务器下的路径
	        String[] str = { "http://localhost:8888/GraduationDesign/static/uploadImages/" + uploadFileName};
	        return ResultUtil.success(str);
	    }
}
