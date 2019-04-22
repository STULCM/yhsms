package com.yhsms.test;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.yhsms.Dao.empDao;
import com.yhsms.DaoImpl.empDaoImpl;
import com.yhsms.domain.Employee;

public class EmpTest {

	//员工登录
	@Test
	public void logemp() {
		empDao dao=new empDaoImpl();
		System.out.println(dao.logemp("222", "222"));
	}

	//添加员工的方法
	@Test
	public void addemp() {
		empDao dao=new empDaoImpl();
		System.out.println(dao.addemp(new Employee(02, "222", "222", "222", "经理", "天津","")));
	}
	
	//查询所有员工的方法
	@Test
		public void selectemp(){
		empDao dao=new empDaoImpl();
		Map<Integer, String> map = dao.selectemp();
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(i+"\t"+map.get(i));
		}
	}

	//修改员工权限的方法
	@Test
	public void updateemp() {
		empDao dao=new empDaoImpl();
		System.out.println(dao.updateemp(01, "经理"));
	}

	//删除员工的方法
	@Test
	public void deleteemp() {
		empDao dao=new empDaoImpl();
		System.out.println(dao.deleteemp(02));
	}
	}
