package com.nwsuaf.mob.domain;


public class QuesCountScore {
	private String xuanzecount;
	private String score_xuanze;
	private String panduancount;
	private String score_panduan;
	private String time;
	public QuesCountScore() {
		super();
	}
	public QuesCountScore(String xuanzecount, String score_xuanze,
			String panduancount, String score_panduan, String time) {
		super();
		this.xuanzecount = xuanzecount;
		this.score_xuanze = score_xuanze;
		this.panduancount = panduancount;
		this.score_panduan = score_panduan;
		this.time = time;
	}
	public String getXuanzecount() {
		return xuanzecount;
	}
	public void setXuanzecount(String xuanzecount) {
		this.xuanzecount = xuanzecount;
	}
	public String getScore_xuanze() {
		return score_xuanze;
	}
	public void setScore_xuanze(String score_xuanze) {
		this.score_xuanze = score_xuanze;
	}
	public String getPanduancount() {
		return panduancount;
	}
	public void setPanduancount(String panduancount) {
		this.panduancount = panduancount;
	}
	public String getScore_panduan() {
		return score_panduan;
	}
	public void setScore_panduan(String score_panduan) {
		this.score_panduan = score_panduan;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "QuesCountScore [xuanzecount=" + xuanzecount + ", score_xuanze="
				+ score_xuanze + ", panduancount=" + panduancount
				+ ", score_panduan=" + score_panduan + ", time=" + time + "]";
	}
	
}
