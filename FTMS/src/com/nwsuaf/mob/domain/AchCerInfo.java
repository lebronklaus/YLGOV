package com.nwsuaf.mob.domain;
/*
 * ���ڴ洢ҵ����֤�����
 * Ϊ�˼��ٴ�����������Ϊ�˷��㣬������дҵ����֤����Ϣ
 */
public class AchCerInfo {
	private String category;//�����ж���ҵ���������֤�飬ֵΪach����cer
	//ҵ�����
	private String start;
	private String end;
	private String completion;
	private String winess;
	//��õ�֤��
	private String time;
	private String major;
	private String certificatename;
	public AchCerInfo() {
		super();
	}
	public AchCerInfo(String category, String start, String end,
			String completion, String winess, String time, String major,
			String certificatename) {
		super();
		this.category = category;
		this.start = start;
		this.end = end;
		this.completion = completion;
		this.winess = winess;
		this.time = time;
		this.major = major;
		this.certificatename = certificatename;
	}
	//��ҵ�������ֵ
	public AchCerInfo(String category, String start, String end,
			String completion, String winess) {
		this.category = category;
		this.start = start;
		this.end = end;
		this.completion = completion;
		this.winess = winess;
		//�������Ը�ֵΪ""
		this.time = "";
		this.major = "";
		this.certificatename = "";
	}
	//��֤�鸳ֵ
	public AchCerInfo(String category, String time, String major,
			String certificatename) {
		this.category = category;
		this.time = time;
		this.major = major;
		this.certificatename = certificatename;
		//�������Ը�ֵΪ""
		this.start = "";
		this.end = "";
		this.completion = "";
		this.winess = "";
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCompletion() {
		return completion;
	}
	public void setCompletion(String completion) {
		this.completion = completion;
	}
	public String getWiness() {
		return winess;
	}
	public void setWiness(String winess) {
		this.winess = winess;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCertificatename() {
		return certificatename;
	}
	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}
	@Override
	public String toString() {
		return "AchCerInfo [category=" + category + ", start=" + start
				+ ", end=" + end + ", completion=" + completion + ", winess="
				+ winess + ", time=" + time + ", major=" + major
				+ ", certificatename=" + certificatename + "]";
	}
}
