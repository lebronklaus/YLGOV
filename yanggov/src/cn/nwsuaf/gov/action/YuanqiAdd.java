package cn.nwsuaf.gov.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.nwsuaf.gov.DAO.Xinxidao;
import cn.nwsuaf.gov.bean.Xinxi;
import com.opensymphony.xwork2.ActionSupport;

public class YuanqiAdd extends ActionSupport {
	private Xinxi tb;
	private String succ = "基地信息发布成功!";

	// 照片上传---------------------------------------------------------
	private List<File> image;
	private List<String> imageFileName;
	private List<String> imageContentType;
	private String imageDir;
	private String location;

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

	public Xinxi getTb() {
		return tb;
	}

	public void setTb(Xinxi tb) {
		this.tb = tb;
	}

	@Override
	public String execute() {
		// 实现多文件上传文件上传
		String newFileName = "";
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
						tb.setPath1(newFileName);
					} else {
						tb.setPath2(newFileName);
					}
				}
			} else {
				tb.setPath1(newFileName);
				tb.setPath2(newFileName);
			}
			// -------------------------------------------------
			Xinxidao xx = new Xinxidao();
			xx.add(tb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

}
