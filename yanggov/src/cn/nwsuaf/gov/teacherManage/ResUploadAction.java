package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TeaDele;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ResUploadAction extends ActionSupport {

	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private int tea_id;
	private String showpath;
	private  String fileclass;
	private String spDir;
	private String gbDir;
	private String wgDir;
	
	public String getSpDir() {
		return spDir;
	}

	public void setSpDir(String spDir) {
		this.spDir = spDir;
	}

	public String getGbDir() {
		return gbDir;
	}

	public void setGbDir(String gbDir) {
		this.gbDir = gbDir;
	}

	public String getWgDir() {
		return wgDir;
	}

	public void setWgDir(String wgDir) {
		this.wgDir = wgDir;
	}


	public String getFileclass() {
		return fileclass;
	}

	public void setFileclass(String fileclass) {
		this.fileclass = fileclass;
	}

	public String getShowpath() {
		return showpath;
	}

	public void setShowpath(String showpath) {
		this.showpath = showpath;
	}

	public int getTea_id() {
		return tea_id;
	}

	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	private int flag;
	private String location;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String upload() throws Exception {
		String newFileName = null;
		if (uploadFileName != null) {
			if((".MP4".equals(fileclass))||(".FLV".equals(fileclass))){
				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext().getRealPath(
						spDir);
				File dir = new File(path);
				if (dir.exists() == false) {
					dir.mkdir();
				}
				int index = uploadFileName.lastIndexOf(".");
				if (index != -1) {
					newFileName = now + uploadFileName.substring(index);
				} else {
					newFileName = now + "";
				}
				FileUtils.copyFile(upload, new File(path, newFileName));
	
				setShowpath(newFileName); //在前台显示的路径
			}else if(".MP3".equals(fileclass)){
				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext().getRealPath(
						gbDir);
				File dir = new File(path);
				if (dir.exists() == false) {
					dir.mkdir();
				}
				int index = uploadFileName.lastIndexOf(".");
				if (index != -1) {
					newFileName = now + uploadFileName.substring(index);
				} else {
					newFileName = now + "";
				}
				FileUtils.copyFile(upload, new File(path, newFileName));
	
				setShowpath(newFileName); //在前台显示的路径
			}else if(".PDF".equals(fileclass)){
				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext().getRealPath(
						wgDir);
				File dir = new File(path);
				if (dir.exists() == false) {
					dir.mkdir();
				}
				int index = uploadFileName.lastIndexOf(".");
				if (index != -1) {
					newFileName = now + uploadFileName.substring(index);
				} else {
					newFileName = now + "";
				}
				FileUtils.copyFile(upload, new File(path, newFileName));
	
				setShowpath(newFileName);//在前台显示的路径
			}
		}else {
				setShowpath(newFileName);
		}
		return "success";
	}



}
