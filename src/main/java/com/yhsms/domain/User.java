package com.yhsms.domain;

public class User {

	private int uid ;
	private String uname;
	private Card c;
	
	
	public User() {
		super();
	}


	public User(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public Card getC() {
		return c;
	}


	public void setC(Card c) {
		this.c = c;
	}
	
	@Override
	public String toString() {
		System.out.println("用户编号"+"\t"+"用户姓名"+"\t"+"卡号");
		return this.uid+"\t"+this.uname+"\t"+this.c.getCaid();
	}
}
