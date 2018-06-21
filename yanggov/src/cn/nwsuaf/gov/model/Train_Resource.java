package cn.nwsuaf.gov.model;

import java.io.Serializable;

public class Train_Resource implements Serializable {
	private String resources_title;
	private String resources_time;
	private String resources_colum;
	private String resources_from;
	private String resources_author;
	private String resources_profile;
	private String resources_path;

	public String getResources_path() {
		return resources_path;
	}

	public void setResources_path(String resources_path) {
		this.resources_path = resources_path;
	}

	private int resources_id;

	public Train_Resource() {
	}

	public String getResources_title() {
		return resources_title;
	}

	public void setResources_title(String resources_title) {
		this.resources_title = resources_title;
	}

	public String getResources_time() {
		return resources_time;
	}

	public void setResources_time(String resources_time) {
		this.resources_time = resources_time;
	}

	public String getResources_colum() {
		return resources_colum;
	}

	public void setResources_colum(String resources_colum) {
		this.resources_colum = resources_colum;
	}

	public String getResources_from() {
		return resources_from;
	}

	public void setResources_from(String resources_from) {
		this.resources_from = resources_from;
	}

	public String getResources_author() {
		return resources_author;
	}

	public void setResources_author(String resources_author) {
		this.resources_author = resources_author;
	}

	public String getResources_profile() {
		return resources_profile;
	}

	public void setResources_profile(String resources_profile) {
		this.resources_profile = resources_profile;
	}

	public int getResources_id() {
		return resources_id;
	}

	public void setResources_id(int resources_id) {
		this.resources_id = resources_id;
	}

}
