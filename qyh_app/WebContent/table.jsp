<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>数据可视化</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/yunfu.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>

</head>
<body>

<div data-role="page" id="pageone">
<div data-role="header">
  <a href="index.jsp" data-role="button">返回首页</a>
  <h1>数据可视化</h1>
  <div data-role="navbar">
      <ul>
        <li><a href="#" >图1</a></li>
        <li><a href="#pagetwo" >图2</a></li>
        <li><a href="#pagethree" >图3</a></li>
      </ul>
  </div>
  </div>
  <div data-role="content"> 
    <div id="main" style="width:100%;height:500px;"></div>
  </div> 
</div>


<div data-role="page" id="pagetwo">
<div data-role="header">
  <a href="index.jsp" data-role="button">返回首页</a>
  <h1>数据可视化</h1>
  <div data-role="navbar">
      <ul>
        <li><a href="#pageone" >图1</a></li>
        <li><a href="#" >图2</a></li>
        <li><a href="#pagethree" >图3</a></li>
      </ul>
  </div>
  </div>
  <div data-role="content">   
    <div id="main3"  style="width:400px;height:300px;margin:0 auto;"></div>
    <div id="main4"  style="width:400px;height:300px;margin:0 auto;"></div>  
  </div> 
</div>

<div data-role="page" id="pagethree">
<div data-role="header">
  <a href="index.jsp" data-role="button">返回首页</a>
  <h1>数据可视化</h1>
  <div data-role="navbar">
      <ul>
        <li><a href="#pageone" >图1</a></li>
        <li><a href="#pagetwo" >图2</a></li>
        <li><a href="#" >图3</a></li>
      </ul>
  </div>
  </div>
  <div data-role="content" >    
   
    <div id="main1"  style="width:400px;height:300px;margin:0 auto;"></div>
    <div id="main2"  style="width:400px;height:300px;margin:0 auto;"></div>
  </div> 
</div>

</body>


<script>
$(function(){
	
	var url1 = '<%=request.getContextPath()%>/servlet_tb';
	setlinechart(url1);
	});

     var data = [];
     var data1 = [];
     var geoCoordMap = {
		'冲花营销服务中心':[111.8181825763,22.7523906323],
		'船步营销服务中心':[111.613660187,22.6026003914],
		'都门营销服务中心':[111.290745,22.662487],
		'分界营销服务中心':[111.3397199475,22.5309699282],
		'附城营销服务中心':[111.5659824767,22.7886638693],
		'华石营销服务中心':[111.6823869938,22.7594451239],
		'加益营销服务中心':[111.1537306492,22.7220997153],
		'金鸡营销服务中心':[111.8181825763,22.7523906323],
		'黎少营销服务中心':[111.4660522767,22.7236651036],
		'连州营销服务中心':[111.4299484665,22.6488663846],
		'两塘营销服务中心':[111.6991517102,22.6230006969],
		'龙湾营销服务中心':[111.1860155982,22.6930694763],
		'龙园营销服务中心':[111.573617838,22.7696692139],
		'罗镜营销服务中心':[111.4368962928,22.5504831488],
		'罗平营销服务中心':[111.5654520186,22.6232172571],
		'苹塘营销服务中心':[111.7460647497,22.7479547721],
		'人民北营销服务中心':[111.561672,22.770853],
		'生江营销服务中心':[111.5157627526,22.7256613403],
		'双东营销服务中心':[111.6037780534,22.7838400749],
		'泗纶营销服务中心':[111.3139799274,22.7134836616],
		'素龙营销服务中心':[111.5999351174,22.729349299],
		'罗定太平营销服务中心':[111.4955126268,22.5295524262],
		'榃滨营销服务中心':[111.3917267994,22.8182244229],
		'围底营销服务中心':[111.66478035,22.7073304902],
		'新乐营销服务中心':[111.4598945795,22.857037544],
		'新榕营销服务中心':[111.4503350066,22.6113723224],
		'迎宾营销服务中心':[111.5751972254,22.7551776313],
		'车岗营销服务中心':[112.2294261633,22.7880921087],
		'船岗营销服务中心':[112.1821636099,22.6169911902],
		'大江营销服务中心':[112.118261186,22.4824740921],
		'东成营销服务中心':[112.3151488358,22.6911322491],
		'共成营销服务中心':[112.2797971385,22.6213945008],
		'河头营销服务中心':[112.0545001371,22.5841999812],
		'环城南营销服务中心':[112.2263724294,22.6988325631],
		'集成营销服务中心':[112.2130288842,22.6029278654],
		'勒竹营销服务中心':[112.1124144547,22.6989261038],
		'里洞营销服务中心':[112.1886683564,22.4771377175],
		'稔村营销服务中心':[112.3662138693,22.6624705076],
		'水台营销服务中心':[112.4641454808,22.6156980896],
		'天堂营销服务中心':[112.013749,22.561746],
		'新洲营销服务中心':[112.2283391507,22.717233842],
		'太平营销服务中心':[112.2514926588,22.6438237182],
		'宝珠营销服务中心':[111.612114,23.128169],
		'都城营销服务中心':[111.5303134691,23.2406802129],
		'大方营销服务中心':[111.5841545581,22.9744037165],
		'大全营销服务中心':[111.5322471699,22.9088291595],
		'大湾营销服务中心':[111.6290747036,22.8244402207],
		'东坝营销服务中心':[111.7370495877,22.9327956245],
		'桂圩营销服务中心':[111.4719776672,23.1549647381],
		'郁南河口营销服务中心':[111.7232660006,22.872348677],
		'建城营销服务中心':[111.5380215265,23.1424024385],
		'历洞营销服务中心':[111.6577198221,22.976578479],
		'连滩营销服务中心':[111.7205945828,22.9303534488],
		'罗旁营销服务中心':[111.5836145201,23.1848107156],
		'罗顺营销服务中心':[111.422697606,23.1015371555],
		'南江口营销服务中心':[111.8156609203,23.1286343127],
		'平台营销服务中心':[111.4155834978,23.2524295473],
		'千官营销服务中心':[111.5930557408,22.8787652618],
		'宋桂营销服务中心':[111.7673220087,22.9014353036],
		'通门营销服务中心':[111.4748198514,22.9971860653],
		'白石营销服务中心':[111.7888422988,22.8160264825],
		'茶洞营销服务中心':[111.9814796558,22.8412471281],
		'富林营销服务中心':[111.9079404732,22.6657258097],
		'高村营销服务中心':[111.8917492803,22.9400009958],
		'都骑营销服务中心':[112.1946353349,23.0702643892],
		'南乡营销服务中心':[111.8917492803,22.9400009958],
		'石城营销服务中心':[111.944304,22.742709],
		'杨柳营销服务中心':[112.1946353349,23.0702643892],
		'六都营销服务中心':[112.0025057418,23.0779149222],
		'镇安营销服务中心':[111.857832,22.76505],
		'南盛营销服务中心':[111.8917492803,22.9400009958],
		'安塘营销服务中心':[112.1909809717,22.9328845141],
		'高峰营销服务中心':[112.0392657719,22.9501046483],
		'建设南营销服务中心':[112.0433547093,22.933732934],
		'前锋营销服务中心':[112.1151096268,22.8132915299],
		'思劳营销服务中心':[112.2246743585,22.9219693277],
		'兴云中营销服务中心':[112.0397292754,22.9338655381],
		'腰古营销服务中心':[112.2845685866,22.8871283119],


         
        };

       function convertData(data) {
           var res = [];
           for (var i = 0; i < data.length; i++) {
               var geoCoord = geoCoordMap[data[i].qy];              
               if (geoCoord) {
                   res.push({
                       name: data[i].qy,
                       value: geoCoord.concat(data[i].tj1)
                   });
               }
           }
           return res;
        };
        
        
        function convertData1(data1) {
            var res = [];
            for (var i = 0; i < data1.length; i++) {
                var geoCoord = geoCoordMap[data1[i].qy];              
                if (geoCoord) {
                    res.push({
                        name: data1[i].qy,
                        value: geoCoord.concat(data1[i].tj1)
                    });
                }
            }
            return res;
         };
      

        

	
	
function randomData() {
    return Math.round(Math.random()*1000);
}


 function setlinechart(url1){	
	 var Chart=echarts.init(document.getElementById("main"));
	 Chart.showLoading(
			 {text: 'Loding...'  });
	 var Chart1=echarts.init(document.getElementById("main1"));
	 Chart1.showLoading(
			 {text: 'Loding...'  });
	 var Chart2=echarts.init(document.getElementById("main2"));
	 Chart2.showLoading(
			 {text: 'Loding...'  });
	 var Chart3=echarts.init(document.getElementById("main3"));
	 Chart3.showLoading(
			 {text: 'Loding...'  });
	 var Chart4=echarts.init(document.getElementById("main4"));
	 Chart4.showLoading(
			 {text: 'Loding...'  });
	 var date=[];
	 var gddd=[];
	 var gdgd=[];
	 var gzddd=[];
	 var gzdgd=[];
	 
	 var qy1=[];
	 var tj11=[];
	 var tj12=[];
	 var tj13=[];
	 var qy2=[];
	 var tj21=[];
	 var tj22=[];
	 var tj23=[];
	 
	 var qy=[];
	 var tj=[];
	 
	 
	 $.ajax({
       	url:url1,
       	dataType:"json",
       	type:'post',
       	success:function(json){
       	
       		values=json;
       		
			$.each(values,function(i,n){
				var gdxh=n.a;				
				$.each(gdxh,function(i,n){
					date[i]=n.qy;						
					gddd[i]=n.tj1;
					gdgd[i]=n.tj2;
					gzddd[i]=n.tj3;
					gzdgd[i]=n.tj4;					
				}); 
				var zjgdtop=n.b;
				$.each(zjgdtop,function(i,n){
					qy1[i]=n.qy;						
					tj11[i]=n.tj1;
					tj12[i]=n.tj2;
					tj13[i]=n.tj3;
									
				}); 
				var gzdtop=n.c;

				$.each(gzdtop,function(i,n){
					qy2[i]=n.qy;						
					tj21[i]=n.tj1;
					tj22[i]=n.tj2;
					tj23[i]=n.tj3;										
				}); 
				
				var gzdtop=n.d;
				$.each(gzdtop,function(i,n){
					qy[i]=n.qy;						
					tj[i]=n.tj1;
					
				}); 
				
				data=n.e;
				data1=n.f;
				
			});
			var option = {
					   //backgroundColor: '#404a59',//北景颜色
		    		   title: {
		    		        text: '在途工单情况',
		    		        subtext: '',	
		    		        left:'center',
		    		        y:'0px',
		    		        textStyle: {
		    		            color: '#000'
		    		        }
		    		        
		    		    },
		    		    legend: {		    		    	
		    		    	y:'30px',
			       	        data:['装机超预约工单','故障超时工单']
			       	        },
		    		    tooltip: {},
		    		    visualMap: {
		    		        min: 0,
		    		        max: 1000,
		    		        left: 'left',
		    		        top: 'bottom',
		    		        text: ['High','Low'],
		    		        seriesIndex: [2],
		    		        inRange: {
		    		            color: ['#e0ffff', '#006edd']
		    		        },
		    		        calculable : true
		    		    },
		    		    
		    		    geo: {
		    		        map: 'yunfu',
		    		        roam: false,
		    		        y:'100px',		    		       		    		       	    		       
		    		    },
		    		    bmap: {
		    		        center: [112.0433547093,22.933732934],
		    		        zoom: 10,
		    		        roam: true,
		    		        
		    		    },
		    		   
		    		    
		    		 series: [		    		       		    		       
			    		        {
			    		        	name: '装机超预约工单',
			    		            type: 'scatter',
			    		            coordinateSystem: 'geo',			    		           
			    		            data: convertData(data),
			    		            symbolSize: function (val) {
			    		                return val[2] /1.2+5;
			    		            },	
			    		            zlevel: 2,
			    		            rippleEffect: {
			    		                brushType: 'stroke'
			    		            },
			    		            
				    		        label: {
				    		               normal: {
				    		                   formatter: '{b}',
				    		                   position: 'right',
				    		                   show: false
				    		               },
				    		               emphasis: {
				    		                   show: true
				    		               }
				    		           },
				    		        itemStyle: {
				    		               normal: {
				    		                    color: '#BB3D00'
				    		               }
				    		           }
				    		        },
				    		        
				    		        {
				    		        	name: '故障超时工单',
				    		            type: 'scatter',
				    		            coordinateSystem: 'geo',			    		           
				    		            data: convertData1(data1),
				    		            symbolSize: function (val) {
				    		                return val[2] /1.2+5;
				    		            },	
					    		        label: {
					    		               normal: {
					    		                   formatter: '{b}',
					    		                   position: 'right',
					    		                   show: false
					    		               },
					    		               emphasis: {
					    		                   show: true
					    		               }
					    		           },
					    		        itemStyle: {
					    		               normal: {
					    		                    color: '#000003'
					    		               }
					    		           }
					    		        },
					    		        {
					    		        	name: '在途装机单和在途故障单',
					    		            type: 'map',
					    		            mapType: 'yunfu',
					    		            geoIndex: 2,
					    		            y:'100px',
					    		            label: {
					    		                normal: {
					    		                    show:true,
					    		                    textStyle: {
					    		                        color: 'rgba(0,0,0,1)' //文字颜色
					    		                    }
					    		                }
					    		            },
						    		        itemStyle: {
						    		            normal:{
						    		                borderColor: 'rgba(0,0, 0,0.4)',//边框颜色
						    		                //areaColor: '#97CBFF',//区域颜色
						    		               		    		                
						    		            },
						    		            
						    		            emphasis:{
						    		                areaColor: null,
						    		                shadowOffsetX: 0,
						    		                shadowOffsetY: 0,
						    		                shadowBlur: 20,
						    		                borderWidth: 0,
						    		                shadowColor: 'rgba(0, 0, 0, 0.1)'
						    		            }
						    		        },
					    		            data: 
					    		            	[
					    		            	 {name: qy[0], value: tj[0]},
					    		            	 {name: qy[1], value: tj[1]},
					    		            	 {name: qy[2], value: tj[2]}, 
					    		            	 {name: qy[3], value: tj[3]}, 
					    		            	 {name: qy[4], value: tj[4]},
					    		            	 					    		            	 
					    		                   ]
						    		           
						    		     },
					    		        
    		        
		    		       
		    		    ]
		       		};
			var option1 = {
					

		    		   title : {
		       		        text: '在途装机单',
		       		        subtext: ''
		       		    },
		       		 //backgroundColor: '#404a59',
		       		 tooltip: {
			       	        trigger: 'axis',
			       	        axisPointer: {
			       	            type: 'shadow'
			       	        }
			       	    },
			       	 legend: {
			       		    x: 'right',
			       	        data:['在途单','超预约','超7天']
			       	        },
			       	    
			       	    grid: {
			       	        left: '3%',
			       	        right: '4%',
			       	        bottom: '3%',
			       	        containLabel: true
			       	    },
			       	    yAxis: {
			       	        type: 'value',
			       	        boundaryGap: [0, 0.01]
			       	    },
			       	    xAxis: {
			       	        type: 'category',
			       	        data:qy1
			       	    },
			       	    series: [
			       	        {
			       	            name: '在途单',
			       	            type: 'bar',
			       	            data: tj11
			       	        },
			       	        {
			       	            name: '超预约',
			       	            type: 'bar',
			       	            data: tj12
			       	        },
			       	        {
			       	            name: '超7天',
			       	            type: 'bar',
			       	            data: tj13
			       	        }
			       	        
			       	        
			       		    ]
		    		};
		       var option2 = {
		    		   
		    		   title : {
		       		        text: '在途故障单',
		       		        subtext: ''
		       		    },
		       		 //backgroundColor: '#404a59',
		       		  tooltip: {
		       	        trigger: 'axis',
		       	        axisPointer: {
		       	            type: 'shadow'
		       	           }
		       	        },
		       	     legend: {
		       	    	x: 'right',
		       	        data:['在途单','超时单','四点钟工单']
		       	        },
		       	    
		       	    grid: {
		       	        left: '3%',
		       	        right: '4%',
		       	        bottom: '3%',
		       	        containLabel: true
		       	    },
		       	    yAxis: {
		       	        type: 'value',
		       	        boundaryGap: [0, 0.01]
		       	    },
		       	    xAxis: {
		       	        type: 'category',
		       	        data:qy2
		       	    },
		       	    series: [
		       	        {
		       	            name: '在途单',
		       	            type: 'bar',
		       	            data: tj21
		       	        },
		       	        {
		       	            name: '超时单',
		       	            type: 'bar',
		       	            data: tj22
		       	        },
		       	        {
		       	            name: '四点钟工单',
		       	            type: 'bar',
		       	            data: tj23
		       	        }
		       	        
		       		    ]
		    		};
		       
		       	
		       
		       	
	       var option3 = {
	    		    title : {
	    		        text: '装机单七天消化情况',
	    		        subtext: ''
	    		    },
	    		    //backgroundColor: '#404a59',
	    		    tooltip : {
	    		        trigger: 'axis'
	    		    },
	    		    legend: {
	    		    	x: 'right',
	    		        data:['到单','竣工']
	    		    },
	    		    
	    		    calculable : true,
	    		    xAxis : [
	    		        {
	    		            type : 'category',
	    		            boundaryGap : false,
	    		            data :date
	    		        }
	    		    ],
	    		    yAxis : [
	    		        {
	    		            type : 'value',
	    		            axisLabel : {
	    		                formatter: '{value} '
	    		            }
	    		        }
	    		    ],
	    		    series : [
	    		        {
	    		            name:'到单',
	    		            type:'line',
	    		            data:gddd,
	    		            markPoint : {
	    		                data : [
	    		                    {type : 'max', name: '最大值'},
	    		                    {type : 'min', name: '最小值'}
	    		                ]
	    		            },
	    		            markLine : {
	    		                data : [
	    		                    {type : 'average', name: '平均值'}
	    		                ]
	    		            }
	    		        },
	    		        {
	    		            name:'竣工',
	    		            type:'line',
	    		            data:gdgd,
	    		            markPoint : {
	    		                data : [
	    		                    {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
	    		                ]
	    		            },
	    		            markLine : {
	    		                data : [
	    		                    {type : 'average', name : '平均值'}
	    		                ]
	    		            }
	    		        }
	    		       
	    		    ]
	    		};
	       var option4 = {
	    		    title : {
	    		        text: '故障单七天消化情况',
	    		        subtext: ''
	    		    },
	    		    //backgroundColor: '#404a59',
	    		    tooltip : {
	    		        trigger: 'axis'
	    		    },
	    		    legend: {
	    		    	x: 'right',
	    		        data:['到单','归档']
	    		    },
	    		    
	    		    calculable : true,
	    		    xAxis : [
	    		        {
	    		            type : 'category',
	    		            boundaryGap : false,
	    		            data :date
	    		        }
	    		    ],
	    		    yAxis : [
	    		        {
	    		            type : 'value',
	    		            axisLabel : {
	    		                formatter: '{value} '
	    		            }
	    		        }
	    		    ],
	    		    series : [
	    		        
	    		        {
	    		            name:'到单',
	    		            type:'line',
	    		            data:gzddd,
	    		            markPoint : {
	    		                data : [
	    		                    {type : 'max', name: '最大值'},
	    		                    {type : 'min', name: '最小值'}
	    		                ]
	    		            },
	    		            markLine : {
	    		                data : [
	    		                    {type : 'average', name: '平均值'}
	    		                ]
	    		            }
	    		        },
	    		        {
	    		            name:'归档',
	    		            type:'line',
	    		            data:gzdgd,
	    		            markPoint : {
	    		                data : [
	    		                    {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
	    		                ]
	    		            },
	    		            markLine : {
	    		                data : [
	    		                    {type : 'average', name : '平均值'}
	    		                ]
	    		            }
	    		        }
	    		    ]
	    		};
	       
	       
	        Chart.hideLoading();
	       	Chart.setOption(option);
	       	Chart1.hideLoading();
	       	Chart1.setOption(option1);	 
	       	Chart2.hideLoading();
	       	Chart2.setOption(option2);
	       	Chart3.hideLoading();
	       	Chart3.setOption(option3);	 
	       	Chart4.hideLoading();
	       	Chart4.setOption(option4);
	       	}
       	});
 } 
</script> 

</html>