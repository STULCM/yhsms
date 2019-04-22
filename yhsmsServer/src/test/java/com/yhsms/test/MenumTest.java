package com.yhsms.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.yhsms.Dao.menuDao;
import com.yhsms.DaoImpl.menuDaoImpl;
import com.yhsms.domain.Menum;
import com.yhsms.domain.Menutype;

public class MenumTest {

	//添加菜品
	@Test
	public void addmenu() {
		menuDao dao=new menuDaoImpl();
		System.out.println(dao.addmenu(new Menum(101, "青椒炒肉", 15,""),1));
	}

	//客户查询所有菜
	@Test
	public void userseletemenu() {
		menuDao dao=new menuDaoImpl();
		Map<Integer, String> map = dao.userseletemenu(1);
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}
	
	//经理查询所有的菜
	@Test
	public void empseletemenu() {
		menuDao dao=new menuDaoImpl();
		Map<Integer, String> map = dao.empseletemenu();
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
		}
 

	//删除菜
	@Test
	public void deletemenu() {
		menuDao dao=new menuDaoImpl();
		System.out.println(dao.deletemenu(103));
	}
	
	
	//修改菜的价钱
	@Test
	public void updatemenu() {
		menuDao dao=new menuDaoImpl();
		System.out.println(dao.updatemenu(101, 20));
	}
	
	
	//设置特价菜
	@Test
		public void setspecial() {
		menuDao dao=new menuDaoImpl();
		System.out.println(dao.setspecial(101));
	}
	
	//显示特价菜
	@Test
		public void selectspecial() {
		menuDao dao=new menuDaoImpl();
		Map<Integer, String> map = dao.selectspecial();
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
