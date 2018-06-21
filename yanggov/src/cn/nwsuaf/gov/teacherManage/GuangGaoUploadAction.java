package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.HibernateSessionFactory;
import cn.nwsuaf.gov.service.TeaDele;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GuangGaoUploadAction extends ActionSupport {

	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private int tea_id;
	private String showpath;
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

	private String imageDir;
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

	public String getImageDir() {
		return imageDir;
	}

	public void setImageDir(String imageDir) {
		this.imageDir = imageDir;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String upload() throws Exception {
		String newFileName = "zhicheng.jpg";
		if (uploadFileName != null) {
		
			String path = ServletActionContext.getServletContext().getRealPath(
					imageDir);
			File dir = new File(path);
			if (dir.exists() == false) {
				dir.mkdir();
			}
			delImage();
			FileUtils.copyFile(upload, new File(path, newFileName));

			setShowpath(newFileName); //在前台显示的路径
		} else {
			setShowpath(newFileName);
		}
		return "success";
	}

	//删除原来重复的照片，在修改教师信息的时候才用此函数，在第一次发布的时候没有破
		public void delImage() throws HibernateException, Exception {
			
			String path = null;
			String picture = "zhicheng.jpg";
			path = ServletActionContext.getServletContext().getRealPath(
						"/images")
						+ "\\" + picture;
			File wg = new File(path);
			if (wg.exists()) {
				wg.delete();
			}
		}

}
