package com.nwsuaf.mob.domain;

/*
 * Ϊ�˼��ٴ��������ֻ����дweb���results
 */
public class DeclareInfo {
	private String achievement;   //ҵ��
	private String writescore;    //���Գɼ�
	private String interviewscore;//���Գɼ�
	private String totalscore;    //�ܳɼ�
	private String tatal;         //������
	private String canjia;        //�μ�����
	private String approval;      //�޳�Ʊ
	private String opposition;    //����Ʊ
	private String checktime;     //�������
	private String level;         //ְ�����
	private String prof;          //רҵ���
	private String number;        //֤����
	public DeclareInfo() {
		super();
	}
	public DeclareInfo(String achievement, String writescore,
			String interviewscore, String totalscore, String tatal,
			String canjia, String approval, String opposition,
			String checktime, String level, String prof, String number) {
		super();
		this.achievement = achievement;
		this.writescore = writescore;
		this.interviewscore = interviewscore;
		this.totalscore = totalscore;
		this.tatal = tatal;
		this.canjia = canjia;
		this.approval = approval;
		this.opposition = opposition;
		this.checktime = checktime;
		this.level = level;
		this.prof = prof;
		this.number = number;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getWritescore() {
		return writescore;
	}
	public void setWritescore(String writescore) {
		this.writescore = writescore;
	}
	public String getInterviewscore() {
		return interviewscore;
	}
	public void setInterviewscore(String interviewscore) {
		this.interviewscore = interviewscore;
	}
	public String getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}
	public String getTatal() {
		return tatal;
	}
	public void setTatal(String tatal) {
		this.tatal = tatal;
	}
	public String getCanjia() {
		return canjia;
	}
	public void setCanjia(String canjia) {
		this.canjia = canjia;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getOpposition() {
		return opposition;
	}
	public void setOpposition(String opposition) {
		this.opposition = opposition;
	}
	public String getChecktime() {
		return checktime;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "DeclareInfo [achievement=" + achievement + ", writescore="
				+ writescore + ", interviewscore=" + interviewscore
				+ ", totalscore=" + totalscore + ", tatal=" + tatal
				+ ", canjia=" + canjia + ", approval=" + approval
				+ ", opposition=" + opposition + ", checktime=" + checktime
				+ ", level=" + level + ", prof=" + prof + ", number=" + number
				+ "]";
	}
}
