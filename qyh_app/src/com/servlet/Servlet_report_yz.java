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
		
		//��ȡǰ���ͻ���������		
		String qy=request.getParameter("qy");
		qy=new String(qy.getBytes("iso8859-1"),"UTF-8");
		String id=request.getParameter("id");
		id=new String(id.getBytes("iso8859-1"),"UTF-8");
		//session�Ͳ���
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpSession session=httpRequest.getSession();
		String bm=session.getAttribute("bm").toString();
		String name=session.getAttribute("name").toString();
		//�������ݿ�
		Connection con = Connect_db.Connect_yfzd2();	
		Connection con1 = Connect_db.Connect_zddb();
		//��ʼ��getdata����
		Getdata data=new Getdata();		
		//ͨ���û����ȡ��ҵ���û��������
		String[] strs=new String[2];
		strs[0]=name;		
		String sql_pro="select ����  from rb_user_qyh where QYHID="+bm;				
		String pro=data.get_String(sql_pro,con);
		strs[1]=pro;
		
		
		
		//�����㷵������
		String qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";
		if(pro.equals("����")){
			if(id.equals("abc")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";
				}
			else if(id.equals("zjgd_dd1")){
				qd="select e.UNITNAME ���β���,M.MAINSN ������ˮ��,M.DISPATCHTIME �ɵ�ʱ�� from SVR_PUB_DA_MAINQUEUE M join SVR_OP_BILLDATA B on M.MAINSN=B.MAINSN left join ORG_UNIT e on e.UNITID=m.REPAIRUNIT left join ORG_UNIT u on u.UNITID=m.REGIONID where (B.PRODUCTTYPE='ADSLD' or B.PRODUCTTYPE='ADSLS' or B.PRODUCTTYPE='VPDN' or B.PRODUCTTYPE='YFFWIFIKD'  or B.PRODUCTTYPE='HFFWIFIKD' or B.PRODUCTTYPE='YFFADSLD') and (B.WORKTYPE=1 or B.WORKACTION=0 or B.WORKACTION=2) and (b.ACCTYPE='ALT009' or b.ACCTYPE='ALT014') and (SYSDATE-M.FIRSTRECEPTTIME)>7 and substr(u.UNITNAME,0,2)='"+qy+"'";
						}
			else if(id.equals("zjgd_gjg1")){
				qd="select e.UNITNAME ���β���,M.MAINSN ������ˮ��,M.DISPATCHTIME �ɵ�ʱ�� from SVR_PUB_DA_MAINQUEUE M join SVR_OP_BILLDATA B on M.MAINSN=B.MAINSN left join ORG_UNIT e on e.UNITID=m.REPAIRUNIT left join ORG_UNIT u on u.UNITID=m.REGIONID where (B.PRODUCTTYPE='ADSLD' or B.PRODUCTTYPE='ADSLS' or B.PRODUCTTYPE='VPDN' or B.PRODUCTTYPE='YFFWIFIKD'  or B.PRODUCTTYPE='HFFWIFIKD' or B.PRODUCTTYPE='YFFADSLD') and (B.WORKTYPE=1 or B.WORKACTION=0 or B.WORKACTION=2) and (b.ACCTYPE='ALT009' or b.ACCTYPE='ALT014') and (SYSDATE-M.FIRSTRECEPTTIME)>7 and substr(u.UNITNAME,0,2)='"+qy+"'";
						}
			}
		
		
		else if(pro.equals("Ӫ��")){
			if(id.equals("abc")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";}
			else if(id.equals("zjgd_dd1")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<1";}
			else if(id.equals("zjgd_gjg1")){
				qd="select POSTID,POSTNAME,ISVALID from ORG_POST where rownum<2";}					
			
		}
		
		//�ڶ��㷵������
		String rb_zjgd_yf="";
		String rb_gzd_yf="";
		if(qy.equals("ȫ��")){
			rb_zjgd_yf="select Ӫ������,sum(���յ���),sum(���չ����),sum(��;�ϼ�),sum(��;ԤԼ��ʱ��),sum(��;��7�쵥)  from rb_zjgd_yf group by  Ӫ������";
			rb_gzd_yf="select Ӫ������,sum(������;_�ϼ�),sum(����16��������16��),sum(����16��֮ǰ),sum(��Сʱ��δ���),sum(����Сʱδ��� ) from rb_gzd_yf group by  Ӫ������";
		}
		else if(qy.equals("�޶�")||qy.equals("����")||qy.equals("����")||qy.equals("�Ƴ�")||qy.equals("�ư�")){
			rb_zjgd_yf="select Ӫ������,sum(���յ���),sum(���չ����),sum(��;�ϼ�),sum(��;ԤԼ��ʱ��),sum(��;��7�쵥) from rb_zjgd_yf where substr(����,1,2)='"+qy+"'group by  Ӫ������";
			rb_gzd_yf="select Ӫ������,sum(������;_�ϼ�),sum(����16��������16��),sum(����16��֮ǰ),sum(��Сʱ��δ���),sum(����Сʱδ��� ) from rb_gzd_yf where substr(����,1,2)='"+qy+"'group by  Ӫ������";			
		}
		else{
			rb_zjgd_yf="select Ӫ������,sum(���յ���),sum(���չ����),sum(��;�ϼ�),sum(��;ԤԼ��ʱ��),sum(��;��7�쵥) from rb_zjgd_yf where Ӫ������='"+qy+"'group by  Ӫ������";
			rb_gzd_yf="select ����,sum(������;_�ϼ�),sum(����16��������16��),sum(����16��֮ǰ),sum(��Сʱ��δ���),sum(����Сʱδ��� ) from rb_gzd_yf where Ӫ������='"+qy+"'group by  ����";			
			
		}
		
		
		
		
        //��һ�㷵������
		String rb_zjgd="";
		String rb_gzd="";
		if(pro.equals("����")){
		    rb_zjgd ="select ����,���յ���,���չ����,���շǹ����,��;��װ��,��;�ƻ���,��;�ϼ�,��;ԤԼ��ʱ��,��;��7�쵥   FROM rb_zjgd a,rb_user_qyh b where QYHID="+bm+ " AND A.����=B.��λ ";
		    rb_gzd ="select ����,���յ���_�ϼ�,���չ鵵_�ϼ�, ������;_�ϼ�,���ϳ�ʱ_�ϼ�,��ʱ_ͭ,��ʱ_��,�����ʱ,����16��������16��,����16��֮ǰ,��Сʱ��δ���,����Сʱδ���  FROM rb_gzd a,rb_user_qyh b where QYHID="+bm+ " AND A.����=B.��λ ";		    
		}
		else if(pro.equals("����")){
			rb_zjgd ="select ����,���յ���,���չ����,���շǹ����,��;��װ��,��;�ƻ���,��;�ϼ�,��;ԤԼ��ʱ��,��;��7�쵥  FROM rb_zjgd";
			rb_gzd ="select ����,���յ���_�ϼ�,���չ鵵_�ϼ�, ������;_�ϼ�,���ϳ�ʱ_�ϼ�,��ʱ_ͭ,��ʱ_��,�����ʱ,����16��������16��,����16��֮ǰ,��Сʱ��δ���,����Сʱδ���   FROM rb_gzd";	
		}
		else{
			rb_zjgd ="select Ӫ������,���յ���,���չ����,���շǹ����,��;��װ��,��;�ƻ���,��;�ϼ�,��;ԤԼ��ʱ��,��;��7�쵥  FROM rb_zjgd_yf a,rb_user_qyh b where QYHID="+bm+" AND A.Ӫ������=B.��λ ";
		    rb_gzd ="select Ӫ������,sum(���յ���_�ϼ�),sum(���չ鵵_�ϼ�),sum(������;_�ϼ�),sum(���ϳ�ʱ_�ϼ�),sum(��ʱ_ͭ),sum(��ʱ_��),sum(�����ʱ),sum(����16��������16��),sum(����16��֮ǰ),sum(��Сʱ��δ���),sum(����Сʱδ���) FROM rb_gzd_yf a,rb_user_qyh b where QYHID="+bm+ " AND A.Ӫ������=B.��λ  group by Ӫ������";
		   
		}
		
		
		List<Data_arr> strList1=data.get_data9(rb_zjgd,con);
		List<Data_arr> strList2=data.get_data12(rb_gzd,con);
		List<Data_arr> strList3=data.get_data6(rb_zjgd_yf,con);
		List<Data_arr> strList4=data.get_data6(rb_gzd_yf,con);	
		List<Data_arr> strList5=data.get_data3a(qd,con1);	
		
		//�ر����ݿ�����
		try
		{
			if (con != null)
				{con.close();System.out.println("���ݿ������ѹرգ�");}
			if (con1 != null)
			    {con.close();System.out.println("���ݿ������ѹرգ�");}
				
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		
		//���д��json
		JSONArray json1 = JSONArray.fromObject(strList1);
		JSONArray json2 = JSONArray.fromObject(strList2);
		JSONArray json3 = JSONArray.fromObject(strList3);		
		JSONArray json4 = JSONArray.fromObject(strList4);		
		JSONArray json5 = JSONArray.fromObject(strList5);
		JSONArray json6 = JSONArray.fromObject(strs);	
		String ret="";
		ret = String.format("[{\"a\":%s, \"b\":%s, \"c\":%s,\"d\":%s,\"e\":%s,\"f\":%s}]", json1,json2,json3,json4,json5,json6);
		
		//����ǰ��
		response.getWriter().print(ret); 
		System.out.println("������ǰ��!");
			
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
