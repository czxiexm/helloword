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

<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>

<style type="text/css">
        th {
           
            color: #000;
            border-bottom: 1px solid #000;
            background-color: ;
            line-height: 20px;
            height: 30px;
            width:30px;
            text-align: center;
        }
        td {
            color: #fff;
            background-color: #6495ED;
            padding: 6px 11px;
            border-bottom: 1px solid #000;
            vertical-align: top;
            text-align: center;
            font-size:13px
        }       


    </style>
<script>
//打开网页启动默认函数
$(function(){	
	var url1 = '<%=request.getContextPath()%>/servlet_report_yz?qy=全市'+'&id=abc';	
	 $.ajax({
       	url:url1,
       	dataType:"json",
       	type:'post',
       	success:function(json){       	
       		var values=json;       		
			$.each(values,function(i,n){
				var rb_zjgd=n.a;
				var rb_gzd=n.b;
				var name=n.f;				
				var htmln= '欢迎你:'+name[0]+'---';
				$('#name').html(htmln);
				$('#name1').html(htmln);
				
				//员工属性为本部，可查看全市报表，
				if(name[1]=='本部'){				
				var tj2=0,tj3=0,tj4=0,tj5=0,tj6=0,tj7=0,tj8=0,tj9=0;					
				var html11= '<tr><td>部门</td><td>昨日到单</td><td>昨日光宽竣工</td><td>昨日非光宽竣工</td></tr>';
				var html12= '<tr><td>部门</td><td>在途新增</td><td>在途移机</td><td>在途合计</td></tr>';
				var html13= '<tr><td>部门</td><td>在途合计</td><td>在途超预约</td><td>在途超7天</td></tr>';	
				$.each(rb_zjgd,function(i,n){
					html11 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th><th>'+n.tj4+'</th></tr>';
					html12 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj5+'</th><th>'+n.tj6+'</th><th>'+n.tj7+'</th></tr>';
					html13 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj7+'</th><th>'+n.tj7+'</th><th>'+n.tj9+'</th></tr>';
					tj2+=n.tj2/1;
					tj3+=n.tj3/1;
					tj4+=n.tj4/1;
					tj5+=n.tj5/1;
					tj6+=n.tj6/1;
					tj7+=n.tj7/1;
					tj8+=n.tj8/1;
					tj9+=n.tj9/1;
				}); 
				html11 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj2+'</th><th>'+tj3+'</th><th>'+tj4+'</th></tr>';
				html12 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj5+'</th><th>'+tj6+'</th><th>'+tj7+'</th></tr>';
				html13 +='<tr><th onclick="zjgd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj7+'</th><th>'+tj7+'</th><th>'+tj9+'</th></tr>';				
				html11=html11+html12+html13; 
				$('#example1').html(html11);
				
				var tj2=0,tj3=0,tj4=0,tj5=0,tj6=0,tj7=0,tj8=0,tj9=0,tj10=0,tj11=0,tj12=0;
				var html21='<tr><td>部门</td><td>昨日到单</td><td>昨日归档</td><td>在途工单</td><td>超时工单</td></tr>';
				var html22='<tr><td>部门</td><td>超时工单</td><td>光超时</td><td>铜超时</td><td>宽带超时</td></tr>';
				var html23='<tr><td>部门</td><td>今日4点前工单</td><td>昨日四点前工单</td><td>未超时未外呼</td><td>已超时未外呼</td></tr>';
				$.each(rb_gzd,function(i,n){
					html21 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th><th>'+n.tj4+'</th><th>'+n.tj5+'</th></tr>';	
					html22 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj5+'</th><th>'+n.tj6+'</th><th>'+n.tj7+'</th><th>'+n.tj8+'</th></tr>';
					html23 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">'+n.tj1+'</th><th>'+n.tj9+'</th><th>'+n.tj10+'</th><th>'+n.tj11+'</th><th>'+n.tj12+'</th></tr>';
					tj2+=n.tj2/1;
					tj3+=n.tj3/1;
					tj4+=n.tj4/1;
					tj5+=n.tj5/1;
					tj6+=n.tj6/1;
					tj7+=n.tj7/1;
					tj8+=n.tj8/1;
					tj9+=n.tj9/1;
					tj10+=n.tj10/1;
					tj11+=n.tj11/1;
					tj12+=n.tj12/1;
				}); 
				html21 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj2+'</th><th>'+tj3+'</th><th>'+tj4+'</th><th>'+tj5+'</th></tr>';	
				html22 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj5+'</th><th>'+tj6+'</th><th>'+tj7+'</th><th>'+tj8+'</th></tr>';
				html23 +='<tr><th onclick="gzd_yf(this)" style="color:#6495ED;text-decoration:underline">全市</th><th>'+tj9+'</th><th>'+tj10+'</th><th>'+tj11+'</th><th>'+tj12+'</th></tr>';
				html21=html21+html22+html23;				
				$('#example2').html(html21);				
				}
				
				//员工属性为区县或者营服，只可查看本单位报表 ，
				else{
					
					var html1='';
					var html2='';
					
					$.each(rb_zjgd,function(i,n){
						html1='<caption onclick="zjgd_yf_show(\''+n.tj1+'\')">'+n.tj1+'装移机单情况---点击看详情</caption>';
						html1+='<tr><th>昨日到单</th><th onclick="qd_show(\''+n.tj1+'\',\'zjgd_dd1\')">'+n.tj2+'</th></tr>';						
						html1+='<tr><th>昨日光宽竣工</th><th onclick="qd_show(\''+n.tj1+'\',\'zjgd_gjg1\')">'+n.tj3+'</th></tr>';
						html1+='<tr><th>昨日非光宽竣工</th><th>'+n.tj4+'</th></tr>';
						html1+='<tr><th>在途新增</th><th>'+n.tj5+'</th></tr>';
						html1+='<tr><th>在途移机</th><th>'+n.tj6+'</th></tr>';
						html1+='<tr><th>在途合计</th><th>'+n.tj7+'</th></tr>';
						html1+='<tr><th>在途超预约</th><th>'+n.tj8+'</th></tr>';
						html1+='<tr><th>在途超7天</th><th>'+n.tj9+'</th></tr>';
																		
						});
					$.each(rb_gzd,function(i,n){
						html2='<caption onclick="gzd_yf_show(\''+n.tj1+'\')">'+n.tj1+'故障单情况---点击看详情</caption>';
						html2+='<tr><th>昨日到单</th><th>'+n.tj2+'</th></tr>';
						html2+='<tr><th>昨日归档</th><th>'+n.tj3+'</th></tr>';
						html2+='<tr><th>昨日工单</th><th>'+n.tj4+'</th></tr>';
						html2+='<tr><th>超时工单</th><th>'+n.tj5+'</th></tr>';
						html2+='<tr><th>光业务超时</th><th>'+n.tj6+'</th></tr>';
						html2+='<tr><th>铜业务超时</th><th>'+n.tj7+'</th></tr>';
						html2+='<tr><th>宽带超时</th><th>'+n.tj8+'</th></tr>';
						html2+='<tr><th>今日4点前工单</th><th>'+n.tj9+'</th></tr>';
						html2+='<tr><th>昨日4点前工单</th><th>'+n.tj10+'</th></tr>';
						html2+='<tr><th>未超时未外呼</th><th>'+n.tj11+'</th></tr>';
						html2+='<tr><th>已超时未外呼</th><th>'+n.tj12+'</th></tr>';
						});
						
					$('#example1').html(html1);
					$('#example2').html(html2);
					
				}							
			});
       	}	
	 });
});

//通过区域名称钻取下一个报表 ，区域可钻取营服，营服可钻取装维班报表
function zjgd_yf(This){
	
	var table=document.getElementById('example1');	
	var obj=This.parentElement; 	
	var rowNum=obj.rowIndex;	
	//var colNum=obj.cellIndex;	
	var qy=table.rows[rowNum].cells[0].innerHTML.toString();
	zjgd_yf_show(qy);
	}
function zjgd_yf_show(qy){
	
	var url = '<%=request.getContextPath()%>/servlet_report_yz?qy='+qy+'&id=abc';	
	$.ajax({
       	url:url,
       	dataType:"json",
       	type:'post',
       	success:function(json){       	
       		var values=json;       		
			$.each(values,function(i,n){
				var rb_zjgd_yf=n.c;
				
				var html3= '<tr><td>营服中心</td><td>昨日到单</td><td>昨日光宽竣工</td><td>在途合计</td><td>在途超预约</td><td>在途超7天</td></tr>';								
				$.each(rb_zjgd_yf,function(i,n){
					html3 +='<tr><th>'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th><th>'+n.tj4+'</th><th>'+n.tj5+'</th><th>'+n.tj6+'</th></tr>';					
														
				}); 
				$('#example3').html(html3);						
				window.location.href="#page_zjgd_yf";
							
			});
       	}
	});		       		
}

function gzd_yf(This){
	
	var table=document.getElementById('example2');	
	var obj=This.parentElement; 	
	var rowNum=obj.rowIndex;	
	//var colNum=obj.cellIndex;	
	var qy=table.rows[rowNum].cells[0].innerHTML.toString();
	//alert(qy);
	gzd_yf_show(qy)
	}
function gzd_yf_show(qy){
	var url = '<%=request.getContextPath()%>/servlet_report_yz?qy='+qy+'&id=abc';	
	$.ajax({
       	url:url,
       	dataType:"json",
       	type:'post',
       	success:function(json){       	
       		var values=json;       		
			$.each(values,function(i,n){
				
				var rb_gzd_yf=n.d;				
				var html4= '<tr><td>营服中心</td><td>在途工单</td><td>今日4点前工单</td><td>昨日四点前工单</td><td>未超时未外呼</td><td>已超时未外呼</td></tr>';				
							
				$.each(rb_gzd_yf,function(i,n){
					html4 +='<tr><th>'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th><th>'+n.tj4+'</th><th>'+n.tj5+'</th><th>'+n.tj6+'</th></tr>';					
				}); 
				$('#example4').html(html4);
				window.location.href="#page_gzd_yf";						
			});
       	}
	});		       		
}


//通过数据钻取清单列表
function qd_show(qy,id){
	var url = '<%=request.getContextPath()%>/servlet_report_yz?qy='+qy+'&id='+id;	
	$.ajax({
       	url:url,
       	dataType:"json",
       	type:'post',
       	success:function(json){       	
       		var values=json;       		
			$.each(values,function(i,n){
				
				var qd=n.e;				
				var html= '<tr><td>工单号</td><td>业务号</td><td>派单时间</td></tr>';				
							
				$.each(qd,function(i,n){
					html +='<tr><th>'+n.tj1+'</th><th>'+n.tj2+'</th><th>'+n.tj3+'</th></tr>';					
				}); 
				$('#example5').html(html);
				window.location.href="#page_qd";						
			});
       	}
	});		       		
}

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
   <div id="name1" width="100%"></div>
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
     <div id="name" width="100%"></div>   
      <table id="example2"  class="xs_table" cellspacing="0" width="100%"></table>
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

<div data-role="page" id="page_qd">
<div data-role="header">
  <a href="#" onClick="javascript:history.back(-1);" data-role="button">返回前一页</a>
  <h1>清单</h1>
  </div>
  <div data-role="content">        
     <table id="example5" class="display" cellspacing="0" width="100%"></table>
  </div> 
</div>

</body>
</html>