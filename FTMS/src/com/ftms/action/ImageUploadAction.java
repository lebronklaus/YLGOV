package com.ftms.action;

import java.io.File;

import javax.servlet.ServletContext;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction extends ActionSupport implements
		ServletContextAware {

	private String username;
	private UserService userService;
	private File upload;// 实际上传文件

	private String uploadContentType; // 文件的内容类型

	private static String uploadImageName; // 上传文件名
	
	private String fileCaption;// 上传文件时的备注

	private ServletContext context;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public static String getUploadImageName() {
		return uploadImageName;
	}

	public static void setUploadImageName(String uploadImageName) {
		ImageUploadAction.uploadImageName = uploadImageName;
	}

	public String getFileCaption() {
		return fileCaption;
	}

	public void setFileCaption(String fileCaption) {
		this.fileCaption = fileCaption;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}

	public String addImage() throws Exception{
		boolean isImage = false;  
        String[] imgExts = {".gif", ".jpg", ".jpeg",".bmp", ".png"}; 
		for(String ext : imgExts) {  
            if(uploadImageName.toLowerCase().endsWith(ext)) {  
                isImage = true;  
            }  
        }  
		if(isImage){
			return "false";
		}
		try {
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid);
			String targetDirectory = context.getRealPath("upload");
			String targetImageName = uploadImageName;
			File target = new File(targetDirectory, targetImageName);
			FileUtils.copyFile(upload, target);

			setUploadImageName(uuid.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return "input";
		}
		return "success";
	}
}
