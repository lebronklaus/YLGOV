package cn.nwsuaf.gov.model;

import java.io.Serializable;

public class Train_Base implements Serializable {
	private String base_name;
	private String base_profile;
	private String base_contact;
	private String base_time;
	private int base_id;
	private String base_path1;
	private String base_path2;

	public String getBase_path1() {
		return base_path1;
	}

	public void setBase_path1(String base_path1) {
		this.base_path1 = base_path1;
	}

	public String getBase_path2() {
		return base_path2;
	}

	public void setBase_path2(String base_path2) {
		this.base_path2 = base_path2;
	}

	public Train_Base() {
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}

	public String getBase_profile() {
		return base_profile;
	}

	public void setBase_profile(String base_profile) {
		this.base_profile = base_profile;
	}

	public String getBase_contact() {
		return base_contact;
	}

	public void setBase_contact(String base_contact) {
		this.base_contact = base_contact;
	}

	public String getBase_time() {
		return base_time;
	}

	public void setBase_time(String base_time) {
		this.base_time = base_time;
	}

	public int getBase_id() {
		return base_id;
	}

	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}

}
