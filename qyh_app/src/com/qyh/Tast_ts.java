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
		
		PreparedStatement pre_qy = null;// ����Ԥ����������һ�㶼�������������Statement
	    ResultSet result_qy = null;
	    PreparedStatement pre_yf = null;// ����Ԥ����������һ�㶼�������������Statement
	    ResultSet result_yf = null;	   
	    PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
	    ResultSet result = null;	    
	    String sql_qy="select * from rb_user_qyh where ����='����'";
	    
	   
	    //��������������Ϣ
	    try{
	    	pre_qy = con.prepareStatement(sql_qy);// ʵ����Ԥ�������
		    result_qy = pre_qy.executeQuery();
		    while(result_qy.next())		    	
		    {
		    	String qy=result_qy.getString(1).replace(" ", "");
		    	String sql="select z.���յ���,z.���չ����,z.��;�ϼ�,z.��;ԤԼ��ʱ��,g.���յ���_�ϼ�,g.���չ鵵_�ϼ�,g.������;_�ϼ�,g.���ϳ�ʱ_�ϼ�   from rb_zjgd z join rb_gzd g on z.����=g.���� where z.����='"+qy+"'";
		    	String bm=result_qy.getString(2);
		    	try
				   {
				   	
		    		   pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		    		   result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
				       while (result.next()){
				           // ���������Ϊ��ʱ       
				    	  context=qy+"�ֹ�˾           װ���ձ������յ���"+  result.getString(1)+";���տ���:"+result.getString(2)+";��;����:"+result.getString(3)+";��ԤԼ����:"+result.getString(4);
				    	  context=context+"        ���ϵ��ձ�:���յ���"+  result.getString(5)+";���չ鵵:"+result.getString(6)+";��;����:"+result.getString(7)+";��ԤԼ����:"+result.getString(8);
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
	    
	    //����Ӫ������������Ϣ
	    String sql_yf="select * from rb_user_qyh where ����='Ӫ��'";
	    try{
	    	pre_yf = con.prepareStatement(sql_yf);// ʵ����Ԥ�������
		    result_yf = pre_yf.executeQuery();
		    while(result_yf.next())		    	
		    {
		    	String yf=result_yf.getString(1).replace(" ", "");
		    	String bm=result_yf.getString(2);
		    	//System.out.println(yf);
		    	String sql="select z.���յ���,z.���չ����,z.��;�ϼ�,z.��;ԤԼ��ʱ��,g.���յ���_�ϼ�,g.���չ鵵_�ϼ�,g.������;_�ϼ�,g.���ϳ�ʱ_�ϼ� from rb_zjgd_yf z full join rb_gzd_yf g on z.Ӫ������=g.Ӫ������ where  (z.��;ԤԼ��ʱ��>0 or g.���ϳ�ʱ_�ϼ�>0) and (z.Ӫ������='"+yf+"' or g.Ӫ������='"+yf+"')";
		    	//System.out.println(sql);
		    	try
				   {
				   	
		    		   pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		    		   result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
				       while (result.next()){
				           // ���������Ϊ��ʱ       
				    	  context=yf+"    װ���ձ������յ���"+  result.getString(1)+";���տ���:"+result.getString(2)+";��;����:"+result.getString(3)+";��ԤԼ����:"+result.getString(4);
				    	  context=context+"       ���ϵ��ձ������յ���"+  result.getString(5)+";���տ���:"+result.getString(6)+";��;����:"+result.getString(7)+";��ԤԼ����:"+result.getString(7);
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
		
	    
	    
	    
	    //��һ�ر�����
		finally
		   {
		       try
		       {
		           // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
		           // ע��رյ�˳�����ʹ�õ����ȹر�
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
		           System.out.println("���ݿ������ѹرգ�");
		       }
		       catch (Exception e)
		       {
		           e.printStackTrace();
		       }
		   }
		
    }

}
