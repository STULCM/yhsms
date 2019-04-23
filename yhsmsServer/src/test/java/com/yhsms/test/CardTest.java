package com.yhsms.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		System.out.println(dao.LoginUser(1100, "1234"));
	}

	//经理查看所有会员卡
	@Test
	public void selectcard(){
		cardDao dao=new cardDaoImpl();
		List<Card> list = dao.selectcard();
		System.out.println("会员卡号"+"\t"+"会员姓名"+"\t"+"会员类型"+"\t"+"优惠额度"+"\t"+"余额"+"\t"+"备注");
		for (Card card : list) {
			System.out.println(card);
		}
	}


	//开卡的方法
	@Test
	public void OpenCard() {
		cardDao dao=new cardDaoImpl();

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

	//根据caid判断卡是否存在
	@Test
	public void selectcardBYcaid(){
		cardDao dao=new cardDaoImpl();

		System.out.println(dao.selectcardBYcaid(34));
	}
}















