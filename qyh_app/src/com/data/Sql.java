package com.data;

public class Sql {
	
	//=================yfzd2 table=======================	
	public static final String zb_gdxh="select * from  zb_gdxh";				
	public static final String rb_zjgdtj="select 区域,在途合计,在途预约超时单,在途超7天单 from rb_zjgd";
	public static final String rb_gzdtj="select 区域, 故障在途_合计,故障超时_合计,昨日16点至今日16点  from rb_gzd";
	public static final String rb_ztgd="select a.区域,a.故障在途_合计+b.在途合计  from rb_gzd a join rb_zjgd b on a.区域=b.区域";
	public static final String zjgd_yf_cyy="select 营服中心,在途预约超时单  from rb_zjgd_yf where 在途预约超时单 >0";
	public static final String gzd_yf_cs="select 营服中心,故障超时_合计 from rb_gzd_yf where 故障超时_合计>0";
	
	
	public static String rb_zjgd="select * from rb_zjgd";
	public static String rb_gzd="select * from rb_gzd";
	public static String rb_zjgd_yf="select * from rb_zjgd_yf";
	public static String rb_gzd_yf="select * from rb_gzd_yf";
	
	public static final String gzd_yf_top10="select 营服中心,故障超时_合计 from (select * from rb_gzd_yf order by 故障超时_合计 desc) where rownum < 11";
	public static final String zjgd_yf_top10="select 营服中心,在途预约超时单  from (select  * from rb_zjgd_yf  order by 在途预约超时单 desc) where rownum < 11";

}
