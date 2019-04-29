package com.xhj.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadImg {
	
	//参数包含待上传的文件，存储路径
	//功能：把文件复制到存储目录下面，然后返回唯一的文件名字
	public static String uploadPic(MultipartFile file,String storagePath){
		
		//得到文件名
		String fileName=file.getOriginalFilename();
		
		//得到文件后缀
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
		
		//重新生成唯一的文件名
		String newFileName=UUID.randomUUID().toString()+suffixName;
		
		//判断上传目录是否存在
		File storageFolder=new File(storagePath);
		if(storageFolder.exists()==false){
			storageFolder.mkdirs();
		}
		
		//创建文件
		File newFile=new File(storagePath+newFileName);
		
		//复制文件到指定的地方
		try {
			file.transferTo(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return newFileName;
	}
}
