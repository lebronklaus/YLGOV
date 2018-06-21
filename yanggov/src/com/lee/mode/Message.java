package com.lee.mode;

public class Message {
	private int id;
	private String title;
	private int mark;//kuaixun=1peixun=2zhengce=3tnews=4;
	private String date;
	public Message(){}
	public Message(int id,String title,int mark,String date){
		this.id = id;
		this.title = title;
		this.mark = mark;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
