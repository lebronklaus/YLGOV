package com.nwsuaf.mob.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {
	private  String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getInputStream(){
		//ServletActionContext.getServletContext().getRealPath("/")
				//FileInputStream fis = new FileInputStream();
		FileInputStream fis=null;
		try {
			filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
			String path = ServletActionContext.getServletContext().getRealPath("/");
			System.out.println(path);
			fis = new FileInputStream(new File(path+"/MobFTMS.apk"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fis;
	}
	public String getContentType(){
		String mimeType = ServletActionContext.getServletContext().getMimeType(filename);
		return mimeType;
	}
	public String getDownloadFileName() throws UnsupportedEncodingException{
		return DownloadUtils.getDownloadFileName(ServletActionContext.getRequest().getHeader("user-agent"), filename);
	}
	@Override
	public String execute() throws Exception {
		System.out.println("正在下载");
		return SUCCESS;
	}
}
