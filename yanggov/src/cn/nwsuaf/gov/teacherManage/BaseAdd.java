package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.service.BasDele;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainBaseBusiness;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAdd extends ActionSupport {
	private Train_Base tb;
	private String succ = "基地信息发布成功!";

	private List<File> image;
	private List<String> imageFileName;
	private List<String> imageContentType;
	private String imageDir;
	private String location;
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getBas_id() {
		return bas_id;
	}

	public void setBas_id(int bas_id) {
		this.bas_id = bas_id;
	}

	private int bas_id;

	public List<File> getImage() {
		return image;
	}

	public void setImage(List<File> image) {
		this.image = image;
	}

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<String> getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(List<String> imageContentType) {
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

	// //////////////////////////////////////////////////////////////////
	public String getSucc() {
		return succ;
	}

	public void setSucc(String succ) {
		this.succ = succ;
	}

	public Train_Base getTb() {
		return tb;
	}

	public void setTb(Train_Base tb) {
		this.tb = tb;
	}

	@Override
	public String execute() {
		String newFileName = null;
		// long now = new Date().getTime();
		String path = ServletActionContext.getServletContext().getRealPath(
				imageDir);
		File dir = new File(path);
		if (dir.exists() == false) {
			dir.mkdir();
		}

		try {
			if (image != null) {
				for (int i = 0; i < image.size(); i++) {
					long now = new Date().getTime();
					int index = imageFileName.get(i).lastIndexOf(".");
					if (index != -1) {
						newFileName = now
								+ imageFileName.get(i).substring(index);
					} else {
						newFileName = now + "";
					}
					FileUtils.copyFile(image.get(i),
							new File(path, newFileName));
					if (i == 0) {
						tb.setBase_path1(newFileName);
					} else {
						tb.setBase_path2(newFileName);
					}
				}
			} else {
				tb.setBase_path1(newFileName);
				tb.setBase_path2(newFileName);

			}
			// -------------------------------------------------
			TrainBaseBusiness ttbusi = BusinessFactory
					.createTrainBaseBussiness();
			ttbusi.add(tb.getBase_name(), tb.getBase_profile(),
					tb.getBase_contact(), tb.getBase_path1(),
					tb.getBase_path2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == 1) {
			BasDele bd = new BasDele();
			try {
				bd.deleBse(bas_id);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;

	}
	

}
