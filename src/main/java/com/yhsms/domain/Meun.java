package com.yhsms.domain;

public class Meun {
	private int mid;
	private String mname;
	private double mprice;
	private int mtid;
	
	
	public Meun() {
		super();
	}



	public Meun(int mid, String mname, double mprice, int mtid) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mtid = mtid;
	}





	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public double getMprice() {
		return mprice;
	}


	public void setMprice(double mprice) {
		this.mprice = mprice;
	}


	public int getMtid() {
		return mtid;
	}


	public void setMtid(int mtid) {
		this.mtid = mtid;
	}
	
	public void show(){
		System.out.println();
	}

}
