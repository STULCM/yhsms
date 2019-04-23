package com.yhsms.BizImpl;

import java.util.List;
import java.util.Map;

import com.yhsms.Dao.cardDao;
import com.yhsms.DaoImpl.cardDaoImpl;
import com.yhsms.biz.cardBiz;
import com.yhsms.domain.Card;

public class cardBizImpl implements cardBiz {

	private cardDao dao;



	public cardBizImpl() {
		this.dao= new cardDaoImpl();
	}

	//用户登录
	@Override
	public Card LoginUser(int caid,String capass) {

		return this.dao.LoginUser(caid,capass);
	}

	
	//经理查看所有会员卡
	@Override
		public List<Card> selectcard(){
		
		return this.dao.selectcard();
		
	}

	//开卡的方法
	@Override
	public String OpenCard(Card c) {

		return this.dao.OpenCard(c)?"开卡成功":"开卡失败";
	}

	//挂失冻结卡
	@Override
	public String GuaCard(int caid, String note) {

		return this.dao.GuaCard(caid,note)?"办理成功":"办理失败";
	}


	//查看余额
	@Override
	public String selectmoney(int caid) {

		return this.dao.selectmoney(caid);
	}

	//设置充值优惠
	//@Override
	//public String setaddmoney(double money,double remoney) {

	//return this.dao.setaddmoney(money,remoney);
	//}

	//会员充值
	@Override
	public String addmoney(int caid,double money){

		return this.dao.addmoney(caid,money);
	}


	//设置vip会员优惠额度
	@Override
	public double setVip(double vip) {

		return this.dao.setVip(vip);
	}

	//设置Svip会员优惠额度
	@Override
	public double setSVip(double svip){

		return this.dao.setSVip(svip);
	}

	//付款
	@Override
	public String paycard(int caid, double sum) {

		return this.dao.paycard(caid,sum);
	}

	//退款
	@Override
	public String returncard(int caid, double money) {

		return this.dao.returncard(caid,money)?"退款成功":"退款失败";
	}

	//根据caid判断卡是否存在
	@Override
	public Card selectcardBYcaid(int caid){

		return this.dao.selectcardBYcaid(caid);
	}

}
