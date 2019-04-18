package com.yhsms.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Shop {
	private String sid;
	
	//private int uid;
	private User u;
	
	//private int mid;
	private Meun m;
	
	private int num;
	private double sprice;//金额
	private double sum;//总计
	private Date time;
	
	private Employee e;
	
	

	public Shop() {
		super();
	}


	public Shop(String sid, User u, Meun m, int num, double sprice, double sum, Date time, Employee e) {
		super();
		this.sid = sid;
		this.u = u;
		this.m = m;
		this.num = num;
		this.sprice = sprice;
		this.sum = sum;
		this.time = time;
		this.e = e;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public double getSprice() {
		return sprice;
	}


	public void setSprice(double sprice) {
		sprice = num * this.m.getMprice();
		this.sprice = sprice;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		
		this.time = time;
	}
	
	

    public double getSum() {
		return sum;
	}



	public void setSum(double sum) {
		this.sum = sum;
	}



	public void show(){
    	System.out.println("欢迎来到"+this.e.getEloc());
    	System.out.println("订单编号："+this.sid);
    	System.out.println("用户编号："+this.u.getUid());
    	System.out.println("------------------------------------");
    
     
    }
	
}









