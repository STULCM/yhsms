package com.yhsms.test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.yhsms.Dao.orderDao;
import com.yhsms.DaoImpl.orderDaoImpl;
import com.yhsms.domain.Orders;
import com.yhsms.util.DBUtil;

public class OrdersTest {

	//获取系统时间
	@Test
	public void sysdate() {
		orderDao dao=new orderDaoImpl();
		System.out.println(dao.sysdate());
	}


	//添加订单
	@Test
	public void addorders() {
		orderDao dao=new orderDaoImpl();

		System.out.println(dao.addorders(0, 201, 3));

	}


	//员工下单
	@Test
	public void emporder() {
		orderDao dao=new orderDaoImpl();
		String s="2019-04-20 10:22:22";
		System.out.println(dao.emporder(1, 2, 101, 2));

	}

	//根据员工号显示所有订单
	@Test
	public void selectorderbyeid() {
		orderDao dao=new orderDaoImpl();
		Map<Integer, String> map = dao.selectorderbyeid(1);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

	//根据卡号显示所有订单
	@Test
	public void selectordersBycaid() {
		orderDao dao=new orderDaoImpl();
		Map<Integer, String> map = dao.selectordersBycaid(2);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}


	//根据卡号显示当前订单
	@Test
	public void selectnoworder() {
		orderDao dao=new orderDaoImpl();
		Map<Integer, String> map = dao.selectnoworder(0);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

	//删除订单
	@Test
	public void deleteorder() {
		orderDao dao=new orderDaoImpl();
		System.out.println(dao.deleteorder(37));
	}

	//修改订单
	@Test
	public void updateorder() {
		orderDao dao=new orderDaoImpl();
		System.out.println(dao.updateorder(2,101,1));
	}

	//	//修改订单
	//	@Test
	//	public void update() {
	//		DBUtil db =new DBUtil();
	//		String sql="update oitem set num=5 where oid=37 and mid=101 and onote is null";
	//		try {
	//			int i = db.update(sql);
	//			if(i>0){
	//				String s="select mprice from menum where mid=101";
	//				ResultSet rs = db.query(s);
	//				if(rs.next()){
	//					String str="update oitem set oprice="+rs.getDouble("mprice")*5+" where oid=37 and mid=101";
	//					int n = db.update(str);
	//					if(n>0){
	//						System.out.println( "修改成功");
	//					}	
	//				}	
	//			}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//			System.out.println("修改失败");
	//		}finally{
	//			db.close();
	//		}
	//	}

	//结账
	@Test
	public void jiezhang() {
		orderDao dao=new orderDaoImpl();
		System.out.println(dao.jiezhang(0));
	}


	//查看月账单
	@Test
	public void month() {
		orderDao dao=new orderDaoImpl();
		Map<Integer, String> map = dao.month(4);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

	//查看员工月账单
	@Test
	public void empmonth() {
		orderDao dao=new orderDaoImpl();
		Map<Integer, String> map = dao.empmonth(1,4);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

//	//打印小票
//	@Test
//	public void xiaopiao(){
//		orderDao dao=new orderDaoImpl();
//		 dao.xiaopiao(0);
//		
//		}
	}




