package com.data;

public class Sql {
	
	//=================yfzd2 table=======================	
	public static final String zb_gdxh="select * from  zb_gdxh";				
	public static final String rb_zjgdtj="select ����,��;�ϼ�,��;ԤԼ��ʱ��,��;��7�쵥 from rb_zjgd";
	public static final String rb_gzdtj="select ����, ������;_�ϼ�,���ϳ�ʱ_�ϼ�,����16��������16��  from rb_gzd";
	public static final String rb_ztgd="select a.����,a.������;_�ϼ�+b.��;�ϼ�  from rb_gzd a join rb_zjgd b on a.����=b.����";
	public static final String zjgd_yf_cyy="select Ӫ������,��;ԤԼ��ʱ��  from rb_zjgd_yf where ��;ԤԼ��ʱ�� >0";
	public static final String gzd_yf_cs="select Ӫ������,���ϳ�ʱ_�ϼ� from rb_gzd_yf where ���ϳ�ʱ_�ϼ�>0";
	
	
	public static String rb_zjgd="select * from rb_zjgd";
	public static String rb_gzd="select * from rb_gzd";
	public static String rb_zjgd_yf="select * from rb_zjgd_yf";
	public static String rb_gzd_yf="select * from rb_gzd_yf";
	
	public static final String gzd_yf_top10="select Ӫ������,���ϳ�ʱ_�ϼ� from (select * from rb_gzd_yf order by ���ϳ�ʱ_�ϼ� desc) where rownum < 11";
	public static final String zjgd_yf_top10="select Ӫ������,��;ԤԼ��ʱ��  from (select  * from rb_zjgd_yf  order by ��;ԤԼ��ʱ�� desc) where rownum < 11";

}
