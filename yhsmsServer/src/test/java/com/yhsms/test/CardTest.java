package com.yhsms.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.yhsms.Dao.cardDao;
import com.yhsms.DaoImpl.cardDaoImpl;
import com.yhsms.domain.Card;
import com.yhsms.util.DBUtil;

public class CardTest {



	//用户登录
	@Test
	public void LoginUser(){
		cardDao dao=new cardDaoImpl();
		//(1100,'大强','1234','vip',0.8,100,'')
		System.out.println(dao.LoginUser(1100, "1234"));
	}

	//开卡的方法
	@Test
	public void OpenCard() {
		cardDao dao=new cardDaoImpl();
		//boolean openCard = dao.OpenCard(new Card(01, "111", "vip",0.8, 100, ""));
		System.out.println(dao.OpenCard(new Card(1234, "1234", "1234", "vip",0.8, 200, "")));
	}

	//挂失冻结卡
	@Test
	public void GuaCard() {
		cardDao dao=new cardDaoImpl();
		//boolean guaCard = dao.GuaCard(01,"挂失");
		System.out.println(dao.GuaCard(01,""));

	}


	//查看余额
	@Test
	public void selectmoney() {
		cardDao dao=new cardDaoImpl();
		System.out.println(dao.selectmoney(01));

	}

	//会员充值
	@Test
	public void addmoney(){//会员充值金额
		cardDao dao=new cardDaoImpl();

		System.out.println( dao.addmoney(02, 200));
	}

	
	//设置svip会员优惠额度
	@Test
	public void setSVip() {
		cardDao dao=new cardDaoImpl();
		
		System.out.println(dao.setSVip(0.5));

	}

	//设置svip会员优惠额度
		@Test
		public void setVip() {
			cardDao dao=new cardDaoImpl();
		
			System.out.println(dao.setVip(0.9));

		}

	
	//付款
	@Test
	public void paycard() {
		cardDao dao=new cardDaoImpl();

		System.out.println(dao.paycard(02,30));
	}


	}















