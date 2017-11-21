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
public class Servlet_report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_report() {
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
		response.setCharacterEncoding("utf-8");  
		
		//获取前端送回来的数据
		//String qy=request.getParameter("qy");
		//qy=new String(qy.getBytes("iso8859-1"),"UTF-8"); 
		//System.out.println(qy);

		//连接数据库
		Connection con = Connect_db.Connect_yfzd2();	
		Getdata data=new Getdata();
		List<Data_arr> strList1=data.get_data9(Sql.rb_zjgd,con);
		List<Data_arr> strList2=data.get_data27(Sql.rb_gzd,con);
		List<Data_arr> strList3=data.get_data10(Sql.rb_zjgd_yf,con);
		List<Data_arr> strList4=data.get_data29(Sql.rb_gzd_yf,con);		
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
		
		//System.out.println(json4);	
		String ret="";
		ret = String.format("[{\"a\":%s, \"b\":%s, \"c\":%s,\"d\":%s}]", json1,json2,json3,json4);
	
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
