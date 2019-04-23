package com.yhsms.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yhsms.Dao.cardDao;
import com.yhsms.domain.Card;
import com.yhsms.domain.Employee;
import com.yhsms.util.DBUtil;

public class cardDaoImpl implements cardDao {

	private DBUtil db;

	//用户登录
	@Override
	public Card LoginUser(int caid,String capass) {
		db=new DBUtil();
		String sql="select * from card where caid="+caid;
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				if(rs.getString("capass").equals(capass) && rs.getString("canote")==null){
					Card c=new Card(rs.getInt("caid"),rs.getString("uname"),rs.getString("capass"),rs.getString("catype"),rs.getDouble("discount"),rs.getDouble("money"),rs.getString("canote"));
					return c;
				}				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.close();
		}
		return null;
	}


	//经理查看所有会员卡
	@Override
	public List<Card> selectcard(){
		List<Card> list =new ArrayList<Card>();
		this.db=new DBUtil();
		String sql="select * from card where caid<>0 order by caid ";
		try {
			ResultSet rs =this.db.query(sql);
			while(rs.next()){
				list.add(new Card(rs.getInt("caid"), rs.getString("uname"),rs.getString("capass"),rs.getString("catype")
				,rs.getDouble("discount"),rs.getDouble("money"),rs.getString("canote")));
				
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.close();
		}
	}

	//开卡的方法
	@Override
	public boolean OpenCard(Card c) {
		db=new DBUtil();

		String sql="insert into card values(?,?,?,?,?,?,?)";
		try {
			//System.out.println(c.getCaid());
			double money = c.getMoney();
			if(money>=200){
				money=money+100;
			}else if(money>=500){
				money=money+300;
			}
			//System.out.println(c.getCaid());
			int n = this.db.update(sql,c.getCaid(),c.getUname(),c.getCapass(),c.getCatype(),c.getDiscount(),money,c.getCanote());
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.close();
		}
	}




	//挂失冻结卡
	@Override
	public boolean GuaCard(int caid,String note) {
		db= new DBUtil();
		String sql="update card set canote='"+note+"' where caid="+caid;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.close();
		}


	}

	//查看余额
	@Override
	public String selectmoney(int caid) {
		db= new DBUtil();
		String sql="select money,canote from card where caid="+caid;
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){

				if(rs.getString("canote")!=null){
					return "该卡被"+rs.getString("canote");
				}
				return "余额为："+rs.getDouble("money");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.close();
		}
		return null;

	}

	//	//设置充值优惠
	//	@Override
	//	public String setaddmoney(double money,double remoney) {//满money返remony
	//
	//		return "满"+money+"减"+remoney;
	//
	//	}


	//会员充值
	@Override
	public String addmoney(int caid,double money){//会员充值金额
		db= new DBUtil();
		String str="select canote from card where caid="+caid;

		try {
			ResultSet rs = this.db.query(str);
			while(rs.next()){
				if(rs.getString("canote")!=null){
					return "该卡被"+rs.getString("canote");

				}
			}

			if(money>=200){
				money=money+100;
			}else if(money>=500){
				money=money+300;
			}

			String sql="update card set money= money+"+money+"where caid=caid";
			int i = this.db.update(sql);
			if(i>0){
				String now = this.selectmoney(caid);
				return "充值成功，"+now;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "充值失败";
		}
		return "充值失败";

	}

	//设置vip会员优惠额度
	@Override
	public double setVip(double vip) {
		db= new DBUtil();
		String sql="update card set discount="+vip+" where catype='vip'";
		try {
			int i = this.db.update(sql);
			if(i>0){
				return vip;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			this.db.close();
		}
		return 0;

	}

	//设置svip会员优惠额度
	@Override
	public double setSVip(double svip) {
		db= new DBUtil();
		String sql="update card set discount='"+svip+"' where catype='svip'";
		try {
			int i = this.db.update(sql);
			if(i>0){
				return svip;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			this.db.close();
		}
		return 0;

	}


	//付款
	@Override
	public String paycard(int caid, double sum) {
		double hou = 0;
		double discount=0;
		db= new DBUtil();

		String str="select catype,discount from card where caid="+caid;

		try {
			ResultSet rs = this.db.query(str);
			while(rs.next()){
				//System.out.println("您是"+rs.getString("catype")+"用户");
				discount=rs.getDouble("discount");
				hou=sum*discount;


				String sql="update card set money=money-"+hou+" where caid="+caid;
				int n = this.db.update(sql);
				if(n>0){

					//System.out.println("消费为"+sum+",打"+discount+"折后实际消费为"+hou);

					return "您是"+rs.getString("catype")+"用户"+"\n"
					+"消费为"+sum+",打"+discount+"折后实际消费为"+hou+"\n"
					+this.selectmoney(caid);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.close();
		}
		return null;

	}

	//退款
	@Override
	public boolean returncard(int caid, double money) {
		db= new DBUtil();
		String sql="update card set money= (select money from card where caid="+caid+")+"+money;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.close();
		}

	}

	//根据caid判断卡是否存在
	@Override
	public Card selectcardBYcaid(int caid){
		this.db = new DBUtil();
		String sql="select * from card where canote is null and caid="+caid;
		try {
			ResultSet rs = this.db.query(sql);

			while(rs.next()){
				Card c=new Card(caid, rs.getString("uname"),rs.getString("cpass"), rs.getString("catype"), rs.getDouble("discount"),rs.getDouble("money") , "");
				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.close();
		}
		return null;



	}



}















