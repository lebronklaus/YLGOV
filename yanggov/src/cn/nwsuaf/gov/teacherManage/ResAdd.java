package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.ResDele;
import cn.nwsuaf.gov.service.TrainResourceBusiness;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ResAdd extends ActionSupport {
	private Train_Resource tr;
	private File image;
	private String imageFileName;
	private String imageContentType;
	private String spDir;
	private String gbDir;
	private String wgDir;
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	private int res_id;
	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private String location;
	TrainResourceBusiness ttbusi = BusinessFactory
			.createTrainResourceBussiness();

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

	public Train_Resource getTr() {
		return tr;
	}

	public void setTr(Train_Resource tr) {
		this.tr = tr;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String execute() throws Exception {
		String newFileName = null;
		if (imageFileName != null) {
			if (tr.getResources_colum().equals("sp")) {

				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext()
						.getRealPath(spDir);
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
				tr.setResources_path(newFileName);
			} else if (tr.getResources_colum().equals("gb")) {
				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext()
						.getRealPath(gbDir);
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
				tr.setResources_path(newFileName);
			} else if (tr.getResources_colum().equals("wg")) {
				String newFileSwf = null;
				long now = new Date().getTime();
				String path = ServletActionContext.getServletContext()
						.getRealPath(wgDir);
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
				newFileSwf = now + ".swf";
				FileUtils.copyFile(image, new File(path, newFileName));
				location = path + "\\" + newFileName;
				path = path + "\\";
				TestPdfToSwf.convertPDF2SWF(location, path, newFileSwf);
				File file = new File(location);
				if (file.exists()) {
					file.delete();
				}
				newFileName = newFileSwf;
				tr.setResources_path(newFileName);

			}
		} else {
			tr.setResources_path(newFileName);
		}
		ttbusi.add(tr.getResources_title(), tr.getResources_colum(),
				tr.getResources_from(), tr.getResources_author(),
				tr.getResources_profile(), tr.getResources_path());
		if (flag == 1) {
			ResDele rd = new ResDele();
			rd.deleRes(res_id);
		}
		return Action.SUCCESS;
	}

}
