package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TeaDele;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TeaTestAdd extends ActionSupport {
	private Train_Teachers tt;
	private File image;
	private String imageFileName;
	private String imageContentType;
	private int tea_id;

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

	public Train_Teachers getTt() {
		return tt;
	}

	public void setTt(Train_Teachers tt) {
		this.tt = tt;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String newFileName = null;
		if (imageFileName != null) {
			long now = new Date().getTime();
			String path = ServletActionContext.getServletContext().getRealPath(
					imageDir);
			File dir = new File(path);
			if (dir.exists() == false) {
				dir.mkdir();
			}
			int index = imageFileName.lastIndexOf(".");
			if (index != -1) {
				newFileName = now + imageFileName.substring(index);
			} else {
				newFileName = now + "";
			}
			FileUtils.copyFile(image, new File(path, newFileName));

			tt.setTeacher_path(newFileName);
		} else {
			tt.setTeacher_path(newFileName);
		}
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		ttbusi.add(tt.getTeacher_name(), tt.getTeacher_sex(),
				tt.getTeacher_workplace(), tt.getTeacher_inwork(),
				tt.getTeacher_university(), tt.getTeacher_major(),
				tt.getTeacher_professional(), tt.getTeacher_address(),
				tt.getTeacher_email(), tt.getTeacher_profile(),
				tt.getTeacher_phonenum(), tt.getTeacher_path());

		if (getFlag() == 1) {
			TeaDele td = new TeaDele();
			td.delTea(tea_id);
		}
		return Action.SUCCESS;
	}
	

}
