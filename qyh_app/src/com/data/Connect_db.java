package com.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_db {
		   
	   public static Connection  Connect_zddb(){
		   String url = "jdbc:oracle:" + "thin:@132.96.188.20:1521:zddb";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	       String user = "WUCW_YF";// 用户名,系统默认的账户名
	       String password = "1qaz!QAZ";// 你安装时选设置的密码
	       
	       Connection con = null;
	       
		   try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");	       
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        
		    }catch (Exception e){
	    	   e.printStackTrace();
	       }
	       return con;		   
	   }
	   
	   public static Connection  Connect_yfzd2(){
		   
		   String url = "jdbc:oracle:" + "thin:@132.117.32.83:1521:yfzd2";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
		   String user = "yfplss03";// 用户名,系统默认的账户名
		   String password = "yfplss03";// 你安装时选设置的密码
		   
		   Connection con = null;

		   try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        
		    }catch (Exception e){
	    	   e.printStackTrace();
	       }
	       return con;		   
	   }

}
