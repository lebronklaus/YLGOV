package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.HibernateSessionFactory;
import cn.nwsuaf.gov.service.TrainTeacherService;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;

public class EditTeaInfo extends ActionSupport{
	private int tea_id;
	private Train_Teachers tt;
	
	private int teacher_id;
	private String teaname; 
	private String gender ;
	private String workplace;
	private String inwork;
	private String profession; 
	private String phonenum ;
	private String university; 
	private String major ;
	private String address;
	private String email ;
	private String inputNote; 
	private String user_picpath;
	
	//点击修改，会调用这函数实现跳转到teaedit.jsp页面
	public String xxwh() throws Exception{
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		setTt(ttbusi.getTrainTeacher(tea_id));
		return "success";
	}
	
	//更新一个教师信息，用sql语句实现更新操作。
	public String editTeacher() throws Exception{
		Train_Teachers tt = new Train_Teachers();
		tt.setTeacher_id(teacher_id);
		tt.setTeacher_name(teaname);
		if (gender.equals("male")) {
			tt.setTeacher_sex("男");
		} else {
			tt.setTeacher_sex("女");
		}
		tt.setTeacher_workplace(workplace);
		if (inwork.equals("yes")) {
			tt.setTeacher_inwork("是");
		} else {
			tt.setTeacher_inwork("否");
		}

		tt.setTeacher_professional(profession);
		tt.setTeacher_phonenum(phonenum);
		tt.setTeacher_university(university);
		tt.setTeacher_major(major);
		tt.setTeacher_address(address);
		tt.setTeacher_email(email);
		tt.setTeacher_profile(inputNote);
		tt.setTeacher_path(user_picpath);
		TrainTeacherService tts = new TrainTeacherService();
		tts.update(tt);
		return "success";
	}
	
	public void deleBse(int num) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path1 = null;
		String path2 = null;
		String hql = "from Train_Base tt where tt.base_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Base> ttlist = query.list();
		Train_Base tr = ttlist.get(0);
		String picture1 = tr.getBase_path1();
		String picture2 = tr.getBase_path2();
		tx.commit();
		session.close();
		path1 = ServletActionContext.getServletContext().getRealPath(
				"../upload/media/baseimage")
				+ "\\" + picture1;
		path2 = ServletActionContext.getServletContext().getRealPath(
				"../upload/media/baseimage")
				+ "\\" + picture2;
		File pc1 = new File(path1);
		if (pc1.exists()) {
			pc1.delete();
		}
		File pc2 = new File(path2);
		if (pc2.exists()) {
			pc2.delete();
		}
	}
	public int getTea_id() {
		return tea_id;
	}

	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}

	

	public Train_Teachers getTt() {
		return tt;
	}

	public void setTt(Train_Teachers tt) {
		this.tt = tt;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getInwork() {
		return inwork;
	}

	public void setInwork(String inwork) {
		this.inwork = inwork;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInputNote() {
		return inputNote;
	}

	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}

	public String getUser_picpath() {
		return user_picpath;
	}

	public void setUser_picpath(String user_picpath) {
		this.user_picpath = user_picpath;
	}

}
