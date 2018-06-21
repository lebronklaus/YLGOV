package com.ftms.action;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport implements ServletContextAware {
	private File upload;
	private String uploadContentType; 
	private String uploadFileName; 
	private String uploadImageName;
	private ServletContext context;
	private JSONArray imgJSON;
	private String imgpath;
	public JSONArray getImgJSON() {
		return imgJSON;
	}

	public void setImgJSON(JSONArray imgJSON) {
		this.imgJSON = imgJSON;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadImageName() {
		return uploadImageName;
	}

	public void setUploadImageName(String uploadImageName) {
		this.uploadImageName = uploadImageName;
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

	public String upload(){

		int k= uploadFileName.length();
		if(k>10){
			uploadFileName=uploadFileName.substring(k-10,k).trim();
		}
		if(upload.length()>102400){
			return "input";
		}
		//判断上传的是否是图片。如果不是就抛出异常，前台界面会蹦的样子，但是不影响服务器。其他方法不知道。
		boolean isImage = false;  
        String[] imgExts = {".gif", ".jpg", ".jpeg",".bmp", ".png"}; 
		for(String ext : imgExts) {  
            if(uploadFileName.toLowerCase().endsWith(ext)) {  
                isImage = true;  
            }  
        }  
		if(!isImage){
			return "false";
		}

		//判断上传的是否是图片。如果不是就抛出异常，前台界面会蹦的样子，但是不影响服务器。其他方法不知道。
		try {
			String targetDirectory = context.getRealPath("upload/image");
			File target = new File(targetDirectory,UUID.randomUUID().toString()+uploadFileName);
			FileUtils.copyFile(upload, target);
			this.uploadImageName="../upload/image/" + target.getName();
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		return "success";
	}
	
	public String deleteimg(){
		imgJSON=new JSONArray();
		String realpath = context.getRealPath("upload/image");
		imgpath=imgpath.substring(16, imgpath.length());
		String path=realpath+"\\"+imgpath;
		File file = new File(path); 
		file.delete();  
		imgJSON.add("成功!");
		return "deleteimg";
	}
}
