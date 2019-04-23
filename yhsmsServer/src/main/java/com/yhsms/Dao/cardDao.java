package com.yhsms.Dao;

import java.util.List;
import java.util.Map;

import com.yhsms.domain.Card;

public interface cardDao {

	//用户登录
	public Card LoginUser(int caid,String capass);
	
	//经理查看所有会员卡
	public List<Card> selectcard();

	//开卡的方法
	public boolean OpenCard(Card c);

	//挂失冻结卡
	public boolean GuaCard(int caid,String note);

	//查看余额
	public String selectmoney(int caid);

	//设置充值优惠
	//public String setaddmoney(double money,double remoney);

	//会员充值
	public String addmoney(int caid,double money);

	//设置会员优惠额度
	public double setVip(double vip);

	//设置Svip会员优惠额度
	public double setSVip(double svip);

	//付款
	public String paycard(int caid, double sum);

	//退款
	public boolean returncard(int caid, double money);

	//根据caid判断卡是否存在
	public Card selectcardBYcaid(int caid);






}
