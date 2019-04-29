package com.xhj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter {

	//头像的静态访问地址
    @Value("${file.accessAvatarPath}")
    private String accessAvatarPath;
    @Value("${file.uploadAvatarPath}")
    private String uploadAvatarPath;
    
    //动态图片的静态访问地址
    @Value("${file.accessDynamicPicPath}")
    private String accessDynamicPicPath;
    @Value("${file.uploadDynamicPicPath}")
    private String uploadDynamicPicPath;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    	//注册头像访问的虚拟地址
        registry.addResourceHandler(accessAvatarPath).addResourceLocations("file:///" + uploadAvatarPath);
        
        //注册动态图片访问的虚拟地址
        registry.addResourceHandler(accessDynamicPicPath).addResourceLocations("file:///" + uploadDynamicPicPath);
    }
}