package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Connect_db;
import com.data.Data_arr;
import com.data.Getdata;
import com.data.Sql;


import net.sf.json.JSONArray;

/**
 * Servlet implementation class Servlet_tb
 */
//@WebServlet("/Servlet_tb")
public class Servlet_tb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_tb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");  
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		request.setCharacterEncoding("utf-8");
	
		Connection con = Connect_db.Connect_yfzd2();	
		Getdata data=new Getdata();
		List<Data_arr> strList1=data.get_data4(Sql.zb_gdxh,con);
		List<Data_arr> strList2=data.get_data3(Sql.rb_zjgdtj,con);
		List<Data_arr> strList3=data.get_data3(Sql.rb_gzdtj,con);
		List<Data_arr> strList4=data.get_data1(Sql.rb_ztgd,con);
		List<Data_arr> strList5=data.get_data1(Sql.zjgd_yf_cyy,con);
		List<Data_arr> strList6=data.get_data1(Sql.gzd_yf_cs,con);
		try
		{
			if (con != null)
				{con.close();System.out.println("数据库连接已关闭！");}
			
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		
		
		
		JSONArray json1 = JSONArray.fromObject(strList1);
		JSONArray json2 = JSONArray.fromObject(strList2);
		JSONArray json3 = JSONArray.fromObject(strList3);		
		JSONArray json4 = JSONArray.fromObject(strList4);
		JSONArray json5 = JSONArray.fromObject(strList5);
		JSONArray json6 = JSONArray.fromObject(strList6);
		//System.out.println(json4);	
		String ret="";
		ret = String.format("[{\"a\":%s, \"b\":%s, \"c\":%s,\"d\":%s,\"e\":%s,\"f\":%s}]", json1,json2,json3,json4,json5,json6);
	
		response.getWriter().print(ret); 
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
