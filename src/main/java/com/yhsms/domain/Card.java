package com.yhsms.domain;

public class Card {
	private int caid;
	private String capass;
	private String catype;
	private double money;
	private String canote;
	
	
	
	public Card() {
		super();
	}



	public Card(int caid, String capass, String catype, double money) {
		super();
		this.caid = caid;
		this.capass = capass;
		this.catype = catype;
		this.money = money;
		this.canote = canote;
	}



	public int getCaid() {
		return caid;
	}



	public void setCaid(int caid) {
		this.caid = caid;
	}



	public String getCapass() {
		return capass;
	}



	public void setCapass(String capass) {
		this.capass = capass;
	}



	public String getCatype() {
		return catype;
	}



	public void setCatype(String catype) {
		this.catype = catype;
	}



	public double getMoney() {
		return money;
	}



	public void setMoney(double money) {
		this.money = money;
	}



	public String getCanote() {
		return canote;
	}



	public void setCanote(String canote) {
		this.canote = canote;
	}
	
	

}
