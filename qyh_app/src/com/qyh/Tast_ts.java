package com.qyh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TimerTask;

import com.data.Connect_db;

public class Tast_ts extends TimerTask{
	@Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Synchro data to other servers.");  
        SendMessage weChat = new SendMessage();
        //String ACCESS_TOKEN =weChat.getAccessToken();
		String context="";
		
		Connection con = Connect_db.Connect_yfzd2();
		
		PreparedStatement pre_qy = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result_qy = null;
	    PreparedStatement pre_yf = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result_yf = null;	   
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;	    
	    String sql_qy="select * from rb_user_qyh where 属性='区县'";
	    
	   
	    //按照区域推送信息
	    try{
	    	pre_qy = con.prepareStatement(sql_qy);// 实例化预编译语句
		    result_qy = pre_qy.executeQuery();
		    while(result_qy.next())		    	
		    {
		    	String qy=result_qy.getString(1).replace(" ", "");
		    	String sql="select z.昨日到单,z.昨日光宽竣工,z.在途合计,z.在途预约超时单,g.昨日到单_合计,g.昨日归档_合计,g.故障在途_合计,g.故障超时_合计   from rb_zjgd z join rb_gzd g on z.区域=g.区域 where z.区域='"+qy+"'";
		    	String bm=result_qy.getString(2);
		    	try
				   {
				   	
		    		   pre = con.prepareStatement(sql);// 实例化预编译语句
		    		   result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
				       while (result.next()){
				           // 当结果集不为空时       
				    	  context=qy+"分公司           装机日报：昨日到单"+  result.getString(1)+";昨日竣工:"+result.getString(2)+";在途工单:"+result.getString(3)+";超预约工单:"+result.getString(4);
				    	  context=context+"        故障单日报:昨日到单"+  result.getString(5)+";昨日归档:"+result.getString(6)+";在途工单:"+result.getString(7)+";超预约工单:"+result.getString(8);
				    	  //System.out.println(context);
				    	  //weChat.sendWeChatMessage(ACCESS_TOKEN,"", bm, "", context);	
				           
				       }
				           
				   }
		    	catch (Exception e)
			       {
			           e.printStackTrace();
			       }
				   
		    }
	    	
	    }
	    catch (Exception e)
		   { 
		       e.printStackTrace();
		   }
	    
	    //按照营服中心推送信息
	    String sql_yf="select * from rb_user_qyh where 属性='营服'";
	    try{
	    	pre_yf = con.prepareStatement(sql_yf);// 实例化预编译语句
		    result_yf = pre_yf.executeQuery();
		    while(result_yf.next())		    	
		    {
		    	String yf=result_yf.getString(1).replace(" ", "");
		    	String bm=result_yf.getString(2);
		    	//System.out.println(yf);
		    	String sql="select z.昨日到单,z.昨日光宽竣工,z.在途合计,z.在途预约超时单,g.昨日到单_合计,g.昨日归档_合计,g.故障在途_合计,g.故障超时_合计 from rb_zjgd_yf z full join rb_gzd_yf g on z.营服中心=g.营服中心 where  (z.在途预约超时单>0 or g.故障超时_合计>0) and (z.营服中心='"+yf+"' or g.营服中心='"+yf+"')";
		    	//System.out.println(sql);
		    	try
				   {
				   	
		    		   pre = con.prepareStatement(sql);// 实例化预编译语句
		    		   result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
				       while (result.next()){
				           // 当结果集不为空时       
				    	  context=yf+"    装机日报：昨日到单"+  result.getString(1)+";昨日竣工:"+result.getString(2)+";在途工单:"+result.getString(3)+";超预约工单:"+result.getString(4);
				    	  context=context+"       故障单日报：昨日到单"+  result.getString(5)+";昨日竣工:"+result.getString(6)+";在途工单:"+result.getString(7)+";超预约工单:"+result.getString(7);
				    	  //System.out.println(context);
				    	  //weChat.sendWeChatMessage(ACCESS_TOKEN,"", bm, "", context);	
				           
				       }
				           
				   }
		    	catch (Exception e)
			       {
			           e.printStackTrace();
			       }
				   
		    }
	    	
	    }
	    catch (Exception e)
		   { 
		       e.printStackTrace();
		   }
		
	    
	    
	    
	    //逐一关闭链接
		finally
		   {
		       try
		       {
		           // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
		           // 注意关闭的顺序，最后使用的最先关闭
		           if (result != null)
		               result.close();
		           if (pre != null)
		               pre.close();
		           if (result_qy != null)
		               result_qy .close();
		           if (pre_qy != null)					               
		        	   pre_qy.close();	
		           if (result_yf != null)
		               result_yf .close();
		           if (pre_yf != null)					               
		        	   pre_yf.close();	
		           if (con != null)
		               con.close();	
		           System.out.println("数据库连接已关闭！");
		       }
		       catch (Exception e)
		       {
		           e.printStackTrace();
		       }
		   }
		
    }

}
