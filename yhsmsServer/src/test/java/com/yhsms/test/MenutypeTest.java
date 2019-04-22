package com.yhsms.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.yhsms.Dao.menuDao;
import com.yhsms.Dao.menutypeDao;
import com.yhsms.DaoImpl.menuDaoImpl;
import com.yhsms.DaoImpl.menutypeDaoImpl;
import com.yhsms.domain.Menutype;

public class MenutypeTest {

	//添加菜类型的方法
	@Test
	public void addmetype() {
		menutypeDao dao=new menutypeDaoImpl();
		System.out.println(dao.addmetype(01, "肉菜"));
	}

	//查询所有菜的类型
	@Test
	public void selectmetype() {
		menutypeDao dao=new menutypeDaoImpl();
		Map<Integer, String> map = dao.selectmetype();
		Set<Integer> key = map.keySet();
		for (Integer i : key) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

	//修改菜类型
	@Test
	public void updatemetype() {
		menutypeDao dao=new menutypeDaoImpl();
		System.out.println(dao.updatemetype(01, "特色菜"));
	}

	//删除菜类型
	@Test
	public void deletemetype() {
		menutypeDao dao=new menutypeDaoImpl();
		System.out.println(dao.deletemetype(02));
	}

	//修改菜类型状态
	@Test
	public void updatemtnote() {
		menutypeDao dao=new menutypeDaoImpl();
		System.out.println(dao.updatemtnote(02));
	}
	}













