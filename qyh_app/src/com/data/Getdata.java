package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class Getdata {
	
	//Connection con = Connect_db.Connect_yfzd2();	
	PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
    ResultSet result = null;// 创建一个结果集对象
	
	
	
   
public String get_String(String sql,Connection con){
		
		String str="";		
		try
		{
			pre = con.prepareStatement(sql);// 实例化预编译语句
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next()){
       	        str=result.getString(1).replace(" ", ""); 
              
                }
            }
		catch (Exception e) 
		{ 
			e.printStackTrace();
			}
		finally
		{
			try
			{
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
			
				}
			catch (Exception e)
			{
				e.printStackTrace();
				}
			} 
		return str;
		}
 
    
	
public List<Data_arr> get_data1(String sql,Connection con){
		
		List<Data_arr> strLists = new ArrayList<Data_arr>();		
		try
		{
			pre = con.prepareStatement(sql);// 实例化预编译语句
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next()){
            	Data_arr str = new Data_arr();
       	        str.setqy(result.getString(1).replace(" ", ""));
  	            str.settj1(result.getString(2));  
  	             
                strLists.add(str);
                }
            }
		catch (Exception e) 
		{ 
			e.printStackTrace();
			}
		finally
		{
			try
			{
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
			
				}
			catch (Exception e)
			{
				e.printStackTrace();
				}
			} 
		return strLists;
		}

public List<Data_arr> get_data2(String sql,Connection con){
	
	List<Data_arr> strLists = new ArrayList<Data_arr>();		
	try
	{
		pre = con.prepareStatement(sql);// 实例化预编译语句
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next()){
        	Data_arr str = new Data_arr();
   	        str.setqy(result.getString(1).replace(" ", ""));
	        str.settj1(result.getString(2));  
	        str.settj2(result.getString(3));  
	            
            strLists.add(str);
            }
        }
	catch (Exception e) 
	{ 
		e.printStackTrace();
		}
	finally
	{
		try
		{
			if (result != null)
				result.close();
			if (pre != null)
				pre.close();
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		} 
	return strLists;
	}

public List<Data_arr> get_data3(String sql,Connection con){
	
	List<Data_arr> strLists = new ArrayList<Data_arr>();		
	try
	{
		pre = con.prepareStatement(sql);// 实例化预编译语句
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next()){
        	Data_arr str = new Data_arr();
   	        str.setqy(result.getString(1).replace(" ", ""));
	        str.settj1(result.getString(2));  
	        str.settj2(result.getString(3));  
	        str.settj3(result.getString(4));  
	            
            strLists.add(str);
            }
        }
	catch (Exception e) 
	{ 
		e.printStackTrace();
		}
	finally
	{
		try
		{
			if (result != null)
				result.close();
			if (pre != null)
				pre.close();
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		} 
	return strLists;
	}

public List<Data_arr> get_data4(String sql,Connection con){
	
	List<Data_arr> strLists = new ArrayList<Data_arr>();		
	try
	{
		pre = con.prepareStatement(sql);// 实例化预编译语句
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next()){
        	Data_arr str = new Data_arr();
   	        str.setqy(result.getString(1).replace(" ", ""));
	        str.settj1(result.getString(2));  
	        str.settj2(result.getString(3));  
	        str.settj3(result.getString(4));  
	        str.settj4(result.getString(5));  
            strLists.add(str);
            }
        }
	catch (Exception e) 
	{ 
		e.printStackTrace();
		}
	finally
	{
		try
		{
			if (result != null)
				result.close();
			if (pre != null)
				pre.close();
		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		} 
	return strLists;
	}


public List<Data_arr> get_data3a(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();	       	    
	  	        str.settj1(result.getString(1)); 
	  	        str.settj2(result.getString(2));
	  	        str.settj3(result.getString(3));	     
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;

}
public List<Data_arr> get_data6(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();	       	    
	  	        str.settj1(result.getString(1)); 
	  	        str.settj2(result.getString(2));
	  	        str.settj3(result.getString(3));
	  	        str.settj4(result.getString(4)); 
		        str.settj5(result.getString(5));
		        str.settj6(result.getString(6));		     
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;
 
}

public List<Data_arr> get_data9(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();	       	    
	  	        str.settj1(result.getString(1)); 
	  	        str.settj2(result.getString(2));
	  	        str.settj3(result.getString(3));
	  	        str.settj4(result.getString(4)); 
		        str.settj5(result.getString(5));
		        str.settj6(result.getString(6));
		        str.settj7(result.getString(7));
	            str.settj8(result.getString(8));  
	            str.settj9(result.getString(9));
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;
  
}
public List<Data_arr> get_data10(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();
	       	    str.setqy(result.getString(1));
	  	        str.settj1(result.getString(2)); 
	  	        str.settj2(result.getString(3));
	  	        str.settj3(result.getString(4));
	  	        str.settj4(result.getString(5)); 
		        str.settj5(result.getString(6));
		        str.settj6(result.getString(7));
		        str.settj7(result.getString(8));
	            str.settj8(result.getString(9));
	            str.settj9(result.getString(10)); 
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;
 
}

public List<Data_arr> get_data12(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();
	    	    str.settj1(result.getString(1)); 
	  	        str.settj2(result.getString(2));
	  	        str.settj3(result.getString(3));
	  	        str.settj4(result.getString(4)); 
		        str.settj5(result.getString(5));
		        str.settj6(result.getString(6));
		        str.settj7(result.getString(7));
	            str.settj8(result.getString(8));  
	            str.settj9(result.getString(9));
	            str.settj10(result.getString(10));
	            str.settj11(result.getString(11));  
	            str.settj12(result.getString(12));
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;

}
public List<Data_arr> get_data27(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();
	       	    str.setqy(result.getString(1));
	  	        str.settj1(result.getString(2)); 
	  	        str.settj2(result.getString(3));
	  	        str.settj3(result.getString(4));
	  	        str.settj4(result.getString(5)); 
		        str.settj5(result.getString(6));
		        str.settj6(result.getString(7));
		        str.settj7(result.getString(8));
	            str.settj8(result.getString(9));
	            str.settj9(result.getString(10));
	            str.settj10(result.getString(11));
	            str.settj11(result.getString(12)); 
	  	        str.settj12(result.getString(13));
	  	        str.settj13(result.getString(14));
	  	        str.settj14(result.getString(15)); 
		        str.settj15(result.getString(16));
		        str.settj16(result.getString(17));
		        str.settj17(result.getString(18));
	            str.settj18(result.getString(19));
	            str.settj19(result.getString(20)); 
	            str.settj20(result.getString(21)); 
	            str.settj21(result.getString(22)); 
	  	        str.settj22(result.getString(23));
	  	        str.settj23(result.getString(24));
	  	        str.settj24(result.getString(25)); 
		        str.settj25(result.getString(26));
		        str.settj26(result.getString(27));
		        str.settj27(result.getString(28));	           
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;
 
}

public List<Data_arr> get_data29(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();
	       	    str.setqy(result.getString(1));
	  	        str.settj1(result.getString(2)); 
	  	        str.settj2(result.getString(3));
	  	        str.settj3(result.getString(4));
	  	        str.settj4(result.getString(5)); 
		        str.settj5(result.getString(6));
		        str.settj6(result.getString(7));
		        str.settj7(result.getString(8));
	            str.settj8(result.getString(9));
	            str.settj9(result.getString(10));
	            str.settj10(result.getString(11));
	            str.settj11(result.getString(12)); 
	  	        str.settj12(result.getString(13));
	  	        str.settj13(result.getString(14));
	  	        str.settj14(result.getString(15)); 
		        str.settj15(result.getString(16));
		        str.settj16(result.getString(17));
		        str.settj17(result.getString(18));
	            str.settj18(result.getString(19));
	            str.settj19(result.getString(20)); 
	            str.settj20(result.getString(21)); 
	            str.settj21(result.getString(22)); 
	  	        str.settj22(result.getString(23));
	  	        str.settj23(result.getString(24));
	  	        str.settj24(result.getString(25)); 
		        str.settj25(result.getString(26));
		        str.settj26(result.getString(27));
		        str.settj27(result.getString(28));
		        str.settj28(result.getString(29));
		        str.settj29(result.getString(30));	
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;

}

public List<Data_arr> get_data30(String sql,Connection con){
	
	  
	 List<Data_arr> strLists = new ArrayList<Data_arr>();
	 try
	   {
	   	
	       pre = con.prepareStatement(sql);// 实例化预编译语句
	       result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	       while (result.next()){
	           // 当结果集不为空时       
	    	    Data_arr str = new Data_arr();
	       	    str.setqy(result.getString(1));
	  	        str.settj1(result.getString(2)); 
	  	        str.settj2(result.getString(3));
	  	        str.settj3(result.getString(4));
	  	        str.settj4(result.getString(5)); 
		        str.settj5(result.getString(6));
		        str.settj6(result.getString(7));
		        str.settj7(result.getString(8));
	            str.settj8(result.getString(9));
	            str.settj9(result.getString(10));
	            str.settj10(result.getString(11));
	            str.settj11(result.getString(12)); 
	  	        str.settj12(result.getString(13));
	  	        str.settj13(result.getString(14));
	  	        str.settj14(result.getString(15)); 
		        str.settj15(result.getString(16));
		        str.settj16(result.getString(17));
		        str.settj17(result.getString(18));
	            str.settj18(result.getString(19));
	            str.settj19(result.getString(20)); 
	            str.settj20(result.getString(21)); 
	            str.settj21(result.getString(22)); 
	  	        str.settj22(result.getString(23));
	  	        str.settj23(result.getString(24));
	  	        str.settj24(result.getString(25)); 
		        str.settj25(result.getString(26));
		        str.settj26(result.getString(27));
		        str.settj27(result.getString(28));
	            str.settj28(result.getString(29));
	            str.settj29(result.getString(30));
	            str.settj30(result.getString(31));
	  	        strLists.add(str);
	           }
	           
	   }
	   catch (Exception e)
	   { 
	       e.printStackTrace();
	   }
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
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	   return strLists;
  
}




}


