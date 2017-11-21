package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.Connect_db;
import com.data.Data_arr;
import com.data.Getdata;
import com.data.Sql;







import net.sf.json.JSONArray;

/**
 * Servlet implementation class Servlet_tb
 */
public class Servlet_report_yz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_report_yz() {
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
		String qy=request.getParameter("qy");
		qy=new String(qy.getBytes("iso8859-1"),"UTF-8");
		String id=request.getParameter("id");
		id=new String(id.getBytes("iso8859-1"),"UTF-8");
		//session送参数
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpSession session=httpRequest.getSession();
		String bm=session.getAttribute("bm").toString();
		String name=session.getAttribute("name").toString();
		//连接数据库
		Connection con = Connect_db.Connect_yfzd2();	
		Connection con1 = Connect_db.Connect_zddb();
		//初始化getdata函数
		Getdata data=new Getdata();		
		//通过用户表获取企业号用户相关属性
		String[] strs=new String[2];
		strs[0]=name;		
		String sql_pro="select 属性  from rb_user_qyh where QYHID="+bm;				
		String pro=data.get_String(sql_pro,con);
		strs[1]=pro;
		
		
		
		//第三层返回数据
		String qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";
		if(pro.equals("区县")){
			if(id.equals("abc")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";
				}
			else if(id.equals("zjgd_dd1")){
				qd="select e.UNITNAME 责任部门,M.MAINSN 工单流水号,M.DISPATCHTIME 派单时间 from SVR_PUB_DA_MAINQUEUE M join SVR_OP_BILLDATA B on M.MAINSN=B.MAINSN left join ORG_UNIT e on e.UNITID=m.REPAIRUNIT left join ORG_UNIT u on u.UNITID=m.REGIONID where (B.PRODUCTTYPE='ADSLD' or B.PRODUCTTYPE='ADSLS' or B.PRODUCTTYPE='VPDN' or B.PRODUCTTYPE='YFFWIFIKD'  or B.PRODUCTTYPE='HFFWIFIKD' or B.PRODUCTTYPE='YFFADSLD') and (B.WORKTYPE=1 or B.WORKACTION=0 or B.WORKACTION=2) and (b.ACCTYPE='ALT009' or b.ACCTYPE='ALT014') and (SYSDATE-M.FIRSTRECEPTTIME)>7 and substr(u.UNITNAME,0,2)='"+qy+"'";
						}
			else if(id.equals("zjgd_gjg1")){
				qd="select e.UNITNAME 责任部门,M.MAINSN 工单流水号,M.DISPATCHTIME 派单时间 from SVR_PUB_DA_MAINQUEUE M join SVR_OP_BILLDATA B on M.MAINSN=B.MAINSN left join ORG_UNIT e on e.UNITID=m.REPAIRUNIT left join ORG_UNIT u on u.UNITID=m.REGIONID where (B.PRODUCTTYPE='ADSLD' or B.PRODUCTTYPE='ADSLS' or B.PRODUCTTYPE='VPDN' or B.PRODUCTTYPE='YFFWIFIKD'  or B.PRODUCTTYPE='HFFWIFIKD' or B.PRODUCTTYPE='YFFADSLD') and (B.WORKTYPE=1 or B.WORKACTION=0 or B.WORKACTION=2) and (b.ACCTYPE='ALT009' or b.ACCTYPE='ALT014') and (SYSDATE-M.FIRSTRECEPTTIME)>7 and substr(u.UNITNAME,0,2)='"+qy+"'";
						}
			}
		
		
		else if(pro.equals("营服")){
			if(id.equals("abc")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";}
			else if(id.equals("zjgd_dd1")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<1";}
			else if(id.equals("zjgd_gjg1")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";}					
			
		}
		
		//第二层返回数据
		String rb_zjgd_yf="";
		String rb_gzd_yf="";
		if(qy.equals("全市")){
			rb_zjgd_yf="select 营服中心,sum(昨日到单),sum(昨日光宽竣工),sum(在途合计),sum(在途预约超时单),sum(在途超7天单)  from rb_zjgd_yf group by  营服中心";
			rb_gzd_yf="select 营服中心,sum(故障在途_合计),sum(昨日16点至今日16点),sum(昨日16点之前),sum(四小时内未外呼),sum(超四小时未外呼 ) from rb_gzd_yf group by  营服中心";
		}
		else if(qy.equals("罗定")||qy.equals("新兴")||qy.equals("郁南")||qy.equals("云城")||qy.equals("云安")){
			rb_zjgd_yf="select 营服中心,sum(昨日到单),sum(昨日光宽竣工),sum(在途合计),sum(在途预约超时单),sum(在途超7天单) from rb_zjgd_yf where substr(区域,1,2)='"+qy+"'group by  营服中心";
			rb_gzd_yf="select 营服中心,sum(故障在途_合计),sum(昨日16点至今日16点),sum(昨日16点之前),sum(四小时内未外呼),sum(超四小时未外呼 ) from rb_gzd_yf where substr(区域,1,2)='"+qy+"'group by  营服中心";			
		}
		else{
			rb_zjgd_yf="select 营服中心,sum(昨日到单),sum(昨日光宽竣工),sum(在途合计),sum(在途预约超时单),sum(在途超7天单) from rb_zjgd_yf where 营服中心='"+qy+"'group by  营服中心";
			rb_gzd_yf="select 班组,sum(故障在途_合计),sum(昨日16点至今日16点),sum(昨日16点之前),sum(四小时内未外呼),sum(超四小时未外呼 ) from rb_gzd_yf where 营服中心='"+qy+"'group by  班组";			
			
		}
		
		
		
		
        //第一层返回数据
		String rb_zjgd="";
		String rb_gzd="";
		if(pro.equals("区县")){
		    rb_zjgd ="select 区域,昨日到单,昨日光宽竣工,昨日非光宽竣工,在途新装单,在途移机单,在途合计,在途预约超时单,在途超7天单   FROM rb_zjgd a,rb_user_qyh b where QYHID="+bm+ " AND A.区域=B.单位 ";
		    rb_gzd ="select 区域,昨日到单_合计,昨日归档_合计, 故障在途_合计,故障超时_合计,超时_铜,超时_光,宽带超时,昨日16点至今日16点,昨日16点之前,四小时内未外呼,超四小时未外呼  FROM rb_gzd a,rb_user_qyh b where QYHID="+bm+ " AND A.区域=B.单位 ";		    
		}
		else if(pro.equals("本部")){
			rb_zjgd ="select 区域,昨日到单,昨日光宽竣工,昨日非光宽竣工,在途新装单,在途移机单,在途合计,在途预约超时单,在途超7天单  FROM rb_zjgd";
			rb_gzd ="select 区域,昨日到单_合计,昨日归档_合计, 故障在途_合计,故障超时_合计,超时_铜,超时_光,宽带超时,昨日16点至今日16点,昨日16点之前,四小时内未外呼,超四小时未外呼   FROM rb_gzd";	
		}
		else{
			rb_zjgd ="select 营服中心,昨日到单,昨日光宽竣工,昨日非光宽竣工,在途新装单,在途移机单,在途合计,在途预约超时单,在途超7天单  FROM rb_zjgd_yf a,rb_user_qyh b where QYHID="+bm+" AND A.营服中心=B.单位 ";
		    rb_gzd ="select 营服中心,sum(昨日到单_合计),sum(昨日归档_合计),sum(故障在途_合计),sum(故障超时_合计),sum(超时_铜),sum(超时_光),sum(宽带超时),sum(昨日16点至今日16点),sum(昨日16点之前),sum(四小时内未外呼),sum(超四小时未外呼) FROM rb_gzd_yf a,rb_user_qyh b where QYHID="+bm+ " AND A.营服中心=B.单位  group by 营服中心";
		   
		}
		
		
		List<Data_arr> strList1=data.get_data9(rb_zjgd,con);
		List<Data_arr> strList2=data.get_data12(rb_gzd,con);
		List<Data_arr> strList3=data.get_data6(rb_zjgd_yf,con);
		List<Data_arr> strList4=data.get_data6(rb_gzd_yf,con);	
		List<Data_arr> strList5=data.get_data3a(qd,con1);	
		
		//关闭数据库链接
		try
		{
			if (con != null)
				{con.close();System.out.println("数据库连接已关闭！");}
			if (con1 != null)
			    {con.close();System.out.println("数据库连接已关闭！");}
				
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		
		//结果写入json
		JSONArray json1 = JSONArray.fromObject(strList1);
		JSONArray json2 = JSONArray.fromObject(strList2);
		JSONArray json3 = JSONArray.fromObject(strList3);		
		JSONArray json4 = JSONArray.fromObject(strList4);		
		JSONArray json5 = JSONArray.fromObject(strList5);
		JSONArray json6 = JSONArray.fromObject(strs);	
		String ret="";
		ret = String.format("[{\"a\":%s, \"b\":%s, \"c\":%s,\"d\":%s,\"e\":%s,\"f\":%s}]", json1,json2,json3,json4,json5,json6);
		
		//送入前端
		response.getWriter().print(ret); 
		System.out.println("数据送前端!");
			
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
