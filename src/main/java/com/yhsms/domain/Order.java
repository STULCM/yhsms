package com.yhsms.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid;
	
	//private int uid;
	private User u;
	
	//private int mid;
	private Meun m;
	
	private int num;
	private double oprice;//金额
	private Date time;
	
	private Employee e;
	
	

	public Order() {
		super();
	}


	public Order(String oid, User u, Meun m, int num, double sprice, Date time, Employee e) {
		super();
		this.oid = oid;
		this.u = u;
		this.m = m;
		this.num = num;
		this.oprice = oprice;
		this.time = time;
		this.e = e;
	}


	public String getOid() {
		return oid;
	}


	public void setSid(String oid) {
		this.oid = oid;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public double getOprice() {
		return oprice;
	}


	public void setOprice(double osprice) {
		osprice = num * this.m.getMprice();
		this.oprice = oprice;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		
		this.time = time;
	}
	
	
	public void show(){
    	System.out.println("欢迎来到"+this.e.getEloc());
    	System.out.println("订单编号："+this.oid);
    	System.out.println("用户编号："+this.u.getUid());
    	System.out.println("------------------------------------");
    
     
    }
	
}









