package com.xhj.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicDisplay;
import com.xhj.user.entity.DynamicPic;
import com.xhj.user.entity.User;
import com.xhj.user.service.DynamicService;
import com.xhj.util.UploadImg;

@Controller
public class UserDynamicController {
	
	//获取service
	@Autowired
	DynamicService ds;
	
	@RequestMapping("/dynamic")
	public String dynamic(HttpSession session) {
		
		List<DynamicDisplay> dds=ds.dynamicDisplay();
		
		session.setAttribute("dds", dds);
		
		//跳转到动态页面
		return "user/dynamic/dynamic";
		
	}
	
	//动态图片的存储路径
	@Value("${file.uploadDynamicPicPath}")
    private String uploadDynamicPicPath;
	
	//把动态的图片内容一起存入数据库
	//多图的时候就会上传多次
	@RequestMapping("/storageDynamicPic")
	public String storageDynamicPic(MultipartFile file,HttpSession session){
		
		//得到文件的新名字
		String fileName=UploadImg.uploadPic(file, uploadDynamicPicPath);
		
		//生成虚拟访问地址
		String newFileName="http://localhost:8080/dynamicPics/"+fileName;
		
		//更新到该用户的数据库中
		int dynamic_id=(int) session.getAttribute("dynamic_id");
		
		DynamicPic dynamicPic=new DynamicPic();
		dynamicPic.setDynamic_id(dynamic_id);
		dynamicPic.setDynamic_picture_path(newFileName);
		
		//动态图片信息存到数据库里
		ds.storageDynamicPic(dynamicPic);
		
		return "user/dynamic/dynamic";
	}
	
	//存储动态的内容
	@RequestMapping("/storageDynamicContent")
	public String storageDynamicContent(String dynamic_content,HttpSession session){
		
		//获取到用户id
		User user=(User) session.getAttribute("ulogined");
		
		//封装动态信息
		Dynamic dynamic=new Dynamic();
		dynamic.setDynamic_user_id(user.getU_id());
		dynamic.setDynamic_content(dynamic_content);
		
		//调用业务方法实现持久化并且取得动态的id
		int dynamic_id=ds.storageDynamic(dynamic);

		session.setAttribute("dynamic_id", dynamic_id);
		
		return "user/dynamic/dynamic";
	}
	
}
