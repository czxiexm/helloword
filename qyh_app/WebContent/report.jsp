<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>数据可视化</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/yunfu.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>

<style type="text/css">
        th {
           
            color: #000;
            border-bottom: 1px solid #000;
            background-color: #ECF6FC;
            line-height: 20px;
            height: 30px;
            width:30px;
            text-align: center;
        }
        td {
            color: #fff;
            background-color: #3E83C9;
            padding: 6px 11px;
            border-bottom: 1px solid #000;
            vertical-align: top;
            text-align: center;
        }       


    </style>
<script>
$(function(){
	
	var url1 = '<%=request.getContextPath()%>/servlet_report';	
	var html11= '<tr><td>区域</td><td>昨日到单</td><td>昨日光宽竣工</td><td>昨日非光宽竣工</td></tr>';
	var html12= '<tr><td>区域</td><td>在途新增</td><td>在途移机</td><td>在途合计</td></tr>';
	var html13= '<tr><td>区域</td><td>在途合计</td><td>在途超预约</td><td>在途超7天</td></tr>';
	
	var html21='<tr><td>区域</td><td>昨日到单</td><td>昨日归档</td><td>在途工单</td><td>超时工单</td></tr>';
	var html22='<tr><td>区域</td><td>超时工单</td><td>光超时</td><td>铜超时</td><td>宽带超时</td></tr>';
	var html23='<tr><td>区域</td><td>今日4点前工单</td><td>昨日四点前工单</td><td>未超时未外呼</td><td>已超时未外呼</td></tr>';
	
	var html3= '<tr><td>营服中心</td><td>昨日到单</td><td>昨日光宽竣工</td><td>在途合计</td><td>在途超预约</td><td>在途超7天</td></tr>';
	var html4= '<tr><td>营服中心</td><td>在途工单</td><td>今日4点前工单</td><td>昨日四点前工单</td><td>未超时未外呼</td><td>已超时未外呼</td></tr>';
	
	$("#qy").click(function(){	
		       alert(qy);
	          //$("form").action("/servelt_login");	       	       
	   });  
	 
	 $.ajax({
       	url:url1,
       	dataType:"json",
       	type:'post',
       	success:function(json){
       	
       		values=json;
       		
			$.each(values,function(i,n){
				var rb_zjgd=n.a;
				var rb_gzd=n.b;
				var rb_zjgd_yf=n.c;
				var rb_gzd_yf=n.d;
				
				$.each(rb_zjgd,function(i,n){
					html11 +='<tr><th><a href="#page_zjgd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th></tr>';
					html12 +='<tr><th><a href="#page_zjgd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj4+'</th><th>'+n.tj5+'</th><th>'+n.tj6+'</th></tr>';
					html13 +='<tr><th><a href="#page_zjgd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj6+'</th><th>'+n.tj7+'</th><th>'+n.tj8+'</th></tr>';
				}); 
				html11=html11+html12+html13;
				$('#example1').html(html11);
				
				$.each(rb_gzd,function(i,n){
					html21 +='<tr><th><a href="#page_gzd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj5+'</th><th>'+n.tj8+'</th><th>'+n.tj11+'</th><th>'+n.tj12+'</th></tr>';	
					html22 +='<tr><th><a href="#page_gzd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj12+'</th><th>'+n.tj13+'</th><th>'+n.tj17+'</th><th>'+n.tj23+'</th></tr>';
					html23 +='<tr><th><a href="#page_gzd_yf" id="qy">'+n.qy+'</a></th><th>'+n.tj24+'</th><th>'+n.tj25+'</th><th>'+n.tj26+'</th><th>'+n.tj27+'</th></tr>';
				}); 
				html21=html21+html22+html23;
				
				$('#example2').html(html21);
				
				
				$.each(rb_zjgd_yf,function(i,n){
					html3 +='<tr><th>'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th><th>'+n.tj7+'</th><th>'+n.tj8+'</th><th>'+n.tj9+'</th></tr>';					
														
				}); 
				$('#example3').html(html3);
			
				$.each(rb_gzd_yf,function(i,n){
					html4 +='<tr><th>'+n.tj2+'</th><th>'+n.tj13+'</th><th>'+n.tj26+'</th><th>'+n.tj27+'</th><th>'+n.tj28+'</th><th>'+n.tj29+'</th></tr>';					
				}); 
				$('#example4').html(html4);
				
			});
       	}	
	 });
});
	 
    

</script> 
</head>
<body>

<div data-role="page" id="page_zjgd">
<div data-role="header">
  <a href="index.jsp" data-role="button">返回首页</a>
  <h1>装维日报</h1>
  <div data-role="navbar">
      <ul>
        <li><a href="#" >装机工单</a></li>
        <li><a href="#page_gzd" >故障单</a></li>        
      </ul>
  </div>

  </div>
  <div data-role="content"> 

   <table id="example1"  class="xs_table" cellspacing="0" width="100%"></table>
  </div> 
</div>


<div data-role="page" id="page_gzd">
<div data-role="header">
  <a href="index.jsp" data-role="button">返回首页</a>
  <h1>装维日报</h1>
  <div data-role="navbar">
      <ul>
        <li><a href="#page_zjgd" >装机工单</a></li>
        <li><a href="#" >故障单</a></li>
      </ul>
  </div>
  </div>
  <div data-role="content">    
     <table id="example2" class="display" cellspacing="0" width="100%"></table>
  </div> 
</div>

<div data-role="page" id="page_zjgd_yf">
<div data-role="header">
  <a href="#page_zjgd" data-role="button">返回上一级</a>
  <h1>装机日报—营服</h1>
  </div>
  <div data-role="content">        
     <table id="example3" class="display" cellspacing="0" width="100%"></table>
  </div> 
</div>

<div data-role="page" id="page_gzd_yf">
<div data-role="header">
  <a href="#page_gzd" data-role="button">返回上一级</a>
  <h1>故障单日报—营服</h1>
  </div>
  <div data-role="content">        
     <table id="example4" class="display" cellspacing="0" width="100%"></table>
  </div> 
</div>


</body>
</html>