package com.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_db {
		   
	   public static Connection  Connect_zddb(){
		   String url = "jdbc:oracle:" + "thin:@132.96.188.20:1521:zddb";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
	       String user = "WUCW_YF";// �û���,ϵͳĬ�ϵ��˻���
	       String password = "1qaz!QAZ";// �㰲װʱѡ���õ�����
	       
	       Connection con = null;
	       
		   try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
	        System.out.println("��ʼ�����������ݿ⣡");	       
	        con = DriverManager.getConnection(url, user, password);// ��ȡ����
	        System.out.println("���ӳɹ���");
	        
		    }catch (Exception e){
	    	   e.printStackTrace();
	       }
	       return con;		   
	   }
	   
	   public static Connection  Connect_yfzd2(){
		   
		   String url = "jdbc:oracle:" + "thin:@132.117.32.83:1521:yfzd2";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
		   String user = "yfplss03";// �û���,ϵͳĬ�ϵ��˻���
		   String password = "yfplss03";// �㰲װʱѡ���õ�����
		   
		   Connection con = null;

		   try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
	        System.out.println("��ʼ�����������ݿ⣡");
	        
	        con = DriverManager.getConnection(url, user, password);// ��ȡ����
	        System.out.println("���ӳɹ���");
	        
		    }catch (Exception e){
	    	   e.printStackTrace();
	       }
	       return con;		   
	   }

}
