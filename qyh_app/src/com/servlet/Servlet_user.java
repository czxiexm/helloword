package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qyh.qyh_jk;

/**
 * Servlet implementation class Servlet_user
 */
//@WebServlet("/Servlet_user")
public class Servlet_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_user() {
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
		String reqUrl = request.getRequestURL().toString(); 
		System.out.println(reqUrl);
		//获取前台送过来的数据
		String code=request.getParameter("code");
		System.out.println("code:"+code);
			
		qyh_jk jk = new qyh_jk();
		String ACCESS_TOKEN =jk.getAccessToken();
		
		String UserID=jk.getuserid(code,ACCESS_TOKEN);
		System.out.println("用户id:"+UserID);
		String[] msg=jk.getusermsg(UserID,ACCESS_TOKEN);
		System.out.println("用户名:"+msg);
		String name=msg[0];
		String[] bm=msg[1].split(",");
		System.out.println("用户名:"+name);
		System.out.println("部门id:"+bm[0]);
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("bm",bm[0]);
		response.sendRedirect("report_yz.jsp");
//		PrintWriter out = response.getWriter();
//        out.println("<html>" 
//                    + "<head><title>传参</title></head>" 
//                    + "<body><tr><tb>欢迎你：</tb>"+name[0]+"</tr></body></html>");
        
    	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
}
