package com.yhsms.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.yhsms.service.Service;
import com.yhsms.service.ServiceImpl;


public class Sserver {
	    //创建服务器套接字对象
		private ServerSocket server;
		public static final int PORT=6666;
		//创建线程池变量
		private ExecutorService es;
		
		//创建被代理的对象
		private Service service;
		
		//构造方法
		public Sserver() {
			//创建服务器
			try {
				System.out.println("服务器正在开启中.....");
				this.server=new ServerSocket(PORT);
				Thread.sleep(1000);
				System.out.println("服务器已开启");
				
				es=Executors.newCachedThreadPool();
				
				this.service=new ServiceImpl();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//自定义方法-项目流程方法
		public void start(){
			//创建while循环 为死循环   服务器一旦开启   不关闭
			while(true){
				//等待客户端连接
				try {
					Socket client = this.server.accept();
					System.out.println("用户"+client.getInetAddress().getHostAddress()+"已链接");
					//创建线程对象
				    ServerThread st=new ServerThread(client,service);
				    //需要将线程对象交给线程池管理
				    es.submit(st);
				    //返回当前处于活跃状态的线程数量
				    int activeCount = ((ThreadPoolExecutor)es).getActiveCount();
				    System.out.println("当前在线活跃用户："+activeCount);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}





















