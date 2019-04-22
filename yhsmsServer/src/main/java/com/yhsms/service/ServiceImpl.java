package com.yhsms.service;

import java.util.List;
import java.util.Map;

import com.yhsms.BizImpl.cardBizImpl;
import com.yhsms.BizImpl.empBizImpl;
import com.yhsms.BizImpl.menumBizImpl;
import com.yhsms.BizImpl.menutypeBizImpl;
import com.yhsms.BizImpl.ordersBizImpl;
import com.yhsms.biz.cardBiz;
import com.yhsms.biz.empBiz;
import com.yhsms.biz.menumBiz;
import com.yhsms.biz.menutypeBiz;
import com.yhsms.biz.ordersBiz;
import com.yhsms.domain.Card;
import com.yhsms.domain.Employee;
import com.yhsms.domain.Menum;


public class ServiceImpl implements Service {

	private cardBiz cbiz;
	private empBiz ebiz;
	private menumBiz mbiz;
	private menutypeBiz mnbiz;
	private ordersBiz obiz;
	
	public ServiceImpl() {
		this.cbiz=new cardBizImpl();
		this.ebiz=new empBizImpl();
		this.mbiz=new menumBizImpl();
		this.mnbiz=new menutypeBizImpl();
		this.obiz=new ordersBizImpl();
	}
	@Override
	//用户登录
	public Card LoginUser(int id, String pass) {
		
		return cbiz.LoginUser(id, pass);
	}
	@Override
	//查看菜类型
	public Map<Integer, String> ShowM() {
		return mnbiz.selectmetype();
	}
	
	@Override
	//根据菜的类型编号查看菜单
	public Map<Integer, String> showAllMenu(int id) {
		
		return mbiz.userseletemenu(id);
	}
	@Override
	//员工登录
	public Employee Login(String account, String password) {
		return ebiz.logemp(account, password);
	}
	@Override
	//点菜
	public String addMenu(int id, int num, int cid) {
		
		return this.obiz.addorders(id, num,cid);
	}
	
	
	@Override
	//办卡的方法
	public String addCard(Card c) {
		
		return cbiz.OpenCard(c);
	}
	@Override
	//一个挂失的方法
	public String Lock(int id, String note) {
		
		return cbiz.GuaCard(id, note);
	}
	@Override
	//创建一个充值 的方法
	public String addMoney(int id, double m) {
		
		return cbiz.addmoney(id, m);
	}
	@Override
	//查看余额
	public String selectmoney(int caid) {
		
		return cbiz.selectmoney(caid);
	}
	@Override
	//设置会员优惠额度
	public double setVip(double vip) {
		
		return cbiz.setVip(vip);
	}
	@Override
	//设置Svip会员优惠额度
	public double setSVip(double svip) {
		
		return cbiz.setSVip(svip);
	}
	@Override
	//付款
	public String paycard(int caid, double sum) {
	
		return cbiz.paycard(caid, sum);
	}
	@Override
	//退款
	public String returncard(int caid, double money) {
		
		return cbiz.returncard(caid, money);
	}
	@Override
	//创建一个添加员工的方法
	public String addEmp(Employee e) {
		// TODO Auto-generated method stub
		return ebiz.addemp(e);
	}
	@Override
	//根据id删除员工
	public String deleteEmp(int id) {
		return ebiz.deleteemp(id);
	}
	@Override
	//修改员工职位
	public String updateemp(int eid, String ejob) {
		return ebiz.updateemp(eid, ejob);
	}
	@Override
	//查询所有员工信息
	public Map<Integer, String> finfAll() {
		return ebiz.selectEmp();
	}
	@Override
	//创建一个经理查看菜单的方法
	public Map<Integer, String> showMenu() {
		return mbiz.empseletemenu();
	}
	@Override
	//修改菜的价钱
	public String updatemenu(int mid, double price) {
		return mbiz.updatemenu(mid, price);
	}
	@Override
	//创建一个添加菜单的方法
	public String addMenus(Menum m, int mtid) {
		return mbiz.addmenu(m, mtid);
	}
	@Override
	//修改菜类型
	public String updatemetype(int mtid, String mtname) {
		return mnbiz.updatemetype(mtid, mtname);
	}
	@Override
	//删除菜类型
	public String deletemetype(int mtid) {
		return mnbiz.deletemetype(mtid);
	}
	@Override
	//修改菜类型状态
	public String updatemtnote(int mtid) {
		return mnbiz.updatemtnote(mtid);
	}
	@Override
	//设置特价菜
	public String setspecial(int mid) {
		 return mbiz.setspecial(mid);
	}
	@Override
	//显示特价菜
	public Map<Integer, String> selectspecial() {
		return mbiz.selectspecial();
	}
	@Override
	public String sysdate() {
		
		return this.obiz.sysdate();
	}
	@Override
	public String addorders(int caid, int mid, int num) {
		
		return this.obiz.addorders(caid, mid, num);
	}
	@Override
	public Map<Integer, String> selectordersBycaid(int caid) {
		
		return this.obiz.selectordersBycaid(caid);
	}
	@Override
	public Map<Integer, String> selectnoworder(int caid) {
		
		return this.obiz.selectnoworder(caid);
	}
	@Override
	public String emporder(int eid, int caid, int mid, int num) {
		
		return this.obiz.emporder(eid, caid, mid, num);
	}
	//根据员工号查询所有订单
	@Override
	public Map<Integer, String> selectorderbyeid(int eid) {
		
		return this.obiz.selectordersByeid(eid);
	}
	//删除订单
	@Override
	public void deleteorder(int oid) {
		
		 this.obiz.deleteorder(oid);
	}
	//修改订单
	@Override
	public String updateorder(int caid, int mid, int num) {
		
		return this.obiz.updateorder(caid, mid, num);
	}
	//结账
	@Override
	public double jiezhang(int caid) {
		
		return this.obiz.jiezhang(caid);
	}
	//查看月账单
	@Override
	public Map<Integer, String> month(int date) {
	
		return this.obiz.month(date);
	}

	//删除菜
	@Override
	public String deleteM(int mid) {
		
		return this.mbiz.deletemenu(mid);
	}
	//添加菜的类型
	@Override
	public String addmenuType(int mtid, String mtname) {
		// TODO Auto-generated method stub
		return this.mnbiz.addmetype(mtid, mtname);
	}
}