// JavaScript Document
require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-zhuanye')); 
                
                var option = {
					  title : {
						  text: '不同专业参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['果树嫁接','苹果栽培管理','猕猴桃栽培管理','枣栽培管理（冬枣）','核桃栽培管理','杂果栽培管理（桃、杏、樱桃）','设施蔬菜栽培管理','生猪饲养管理','奶山羊饲养管理','鸡饲养管理（肉鸡、蛋鸡）','兔饲养管理','牛饲养管理（肉牛、奶牛）','动物疫病防治','动物繁殖','蔬菜植物保护','农作物植物保护','果树植物保护','农作物种子繁殖','花卉园艺','绿化种苗','食用菌培养','农村经济管理']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考专业',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:0, name:'果树嫁接'},
								  {value:310, name:'苹果栽培管理'},
								  {value:234, name:'猕猴桃栽培管理'},
								  {value:135, name:'枣栽培管理（冬枣）'},
								  {value:1548, name:'核桃栽培管理'},
								  {value:0, name:'杂果栽培管理（桃、杏、樱桃）'},
								  {value:310, name:'设施蔬菜栽培管理'},
								  {value:234, name:'生猪饲养管理'},
								  {value:0, name:'奶山羊饲养管理'},
								  {value:1548, name:'鸡饲养管理（肉鸡、蛋鸡）'},
								  {value:335, name:'兔饲养管理'},
								  {value:0, name:'牛饲养管理（肉牛、奶牛）'},
								  {value:234, name:'动物疫病防治'},
								  {value:0, name:'动物繁殖'},
								  {value:1548, name:'蔬菜植物保护'},
								  {value:335, name:'农作物植物保护'},
								  {value:310, name:'果树植物保护'},
								  {value:234, name:'农作物种子繁殖'},
								  {value:135, name:'花卉园艺'},
								  {value:1548, name:'绿化种苗'},
								  {value:0, name:'食用菌培养'},
								  {value:0, name:'农村经济管理'}
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-shengfen')); 
                
                var option = {
					  title : {
						  text: '不同省参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['北京','天津','上海','重庆','河北省','山西省','内蒙古','辽宁省','吉林省','黑龙江省','江苏省','浙江省','安徽省','福建省','江西省','山东省','河南省','湖北省','湖南省','广东省','广西省','海南省','四川省','贵州省','云南省','西藏','陕西省','甘肃省','青海省','宁夏','新疆','香港','澳门','台湾省']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考省份',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:0, name:'北京'},
								  {value:310, name:'天津'},
								  {value:234, name:'上海'},
								  {value:135, name:'重庆'},
								  {value:1548, name:'河北省'},
								  {value:0, name:'山西省'},
								  {value:310, name:'内蒙古'},
								  {value:234, name:'辽宁省'},
								  {value:0, name:'吉林省'},
								  {value:1548, name:'黑龙江省'},
								  {value:335, name:'江苏省'},
								  {value:0, name:'浙江省'},
								  {value:234, name:'安徽省'},
								  {value:0, name:'福建省'},
								  {value:1548, name:'江西省'},
								  {value:335, name:'山东省'},
								  {value:310, name:'河南省'},
								  {value:234, name:'湖北省'},
								  {value:135, name:'湖南省'},
								  {value:1548, name:'广东省'},
								  {value:0, name:'广西省'},
								  {value:0, name:'海南省'},
								  {value:234, name:'四川省'},
								  {value:0, name:'贵州省'},
								  {value:1548, name:'云南省'},
								  {value:0, name:'西藏'},
								  {value:310, name:'陕西省'},
								  {value:0, name:'甘肃省'},
								  {value:135, name:'青海省'},
								  {value:1548, name:'宁夏'},
								  {value:335, name:'新疆'},
								  {value:310, name:'香港'},
								  {value:0, name:'澳门'},
								  {value:135, name:'台湾省'}
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-xingbie')); 
                
                var option = {
					  title : {
						  text: '男女参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['男','女']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考性别',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:256, name:'男'},
								  {value:310, name:'女'}
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-xueli')); 
                
                var option = {
					  title : {
						  text: '不同学历水平参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['小学','初中','高中','大专','本科','研究生','其他']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考学历水平',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:256, name:'小学'},
								  {value:310, name:'初中'},
								  {value:296, name:'高中'},
								  {value:580, name:'大专'},
								  {value:406, name:'本科'},
								  {value:150, name:'研究生'},
								  {value:203, name:'其他'}
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-nianling')); 
                
                var option = {
					  title : {
						  text: '不同年龄参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['20以下','20-30','34-40','40-50','50-60','60以上']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考年龄',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:25, name:'20以下'},
								  {value:310, name:'20-30'},
								  {value:234, name:'30-40'},
								  {value:135, name:'40-50'},
								  {value:1548, name:'50-60'},
								  {value:55, name:'60以上'}								  
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
		require.config({
            paths: {
                echarts: 'echarts-2.2.7/build/dist'
            }
        });
		require(
            [
                'echarts',
                'echarts/chart/pie',
				'echarts/chart/funnel'
            ],
			 function (ec) {
                var myChart = ec.init(document.getElementById('China-jibie')); 
                
                var option = {
					  title : {
						  text: '不同级别参加报考人员数量',
						  subtext: '',
						  x:'center'
					  },
					  tooltip : {
						  trigger: 'item',
						  formatter: "{a} <br/>{b} : {c} ({d}%)"
					  },
					  legend: {
						  orient : 'vertical',
						  x : 'left',
						  data:['农技员','农技师','高级农技师']
					  },
					  toolbox: {
						  show : true,
						  feature : {
							  mark : {show: true},
							  dataView : {show: true, readOnly: false},
							  magicType : {
								  show: true, 
								  type: ['pie', 'funnel'],
								  option: {
									  funnel: {
										  x: '25%',
										  width: '50%',
										  funnelAlign: 'left',
										  max: 1548
									  }
								  }
							  },
							  restore : {show: true},
							  saveAsImage : {show: true}
						  }
					  },
					  calculable : true,
					  series : [
						  {
							  name:'报考级别',
							  type:'pie',
							  radius : '55%',
							  center: ['50%', '60%'],
							  data:[
								  {value:256, name:'农技员'},
								  {value:310, name:'农技师'},
								  {value:234, name:'高级农技师'},
							  ]
						  }
					  ]
				  };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
$(function(){
	$('#ChinaMap').SVGMap({
		mapName: 'china',
		clickCallback: function(stateData, obj){
			var NewPage='<script type="text/javascript" src="js/autochart.js"></script>'+
			'<div title="山东省" data-options="iconCls:"icon-add",closable:true" style="padding:10px">'+
                    '<div><img src="images/map/shandong.jpg" width="705" height="406"  alt=""/></div>'+
                    '<div id="shandongwenzi"><pre style="font-size:16px">截止****年**月**日，***省共有****农民获得证书，涉及***个市***个县</pre></div>'+
                    '<div style="margin:20px 0 10px 0;"></div>'+
                   ' <div class="easyui-accordion" style="width:760px;height:800px;">'+
                        '<div id="shandong-zhuanye" title="专业" style="padding:10px;">'+
                        '</div>'+
                        '<div id="shandong-shengfen" title="省份" style="padding:10px;">'+
                        '</div>'+
                        '<div id="shandong-xingbie" title="性别" style="padding:10px;">'+
                        '</div>'+
                        '<div id="shandong-xueli" title="学历" style="padding:10px;">'+
                        '</div>'+
                        '<div id="shandong-nianling" title="年龄" style="padding:10px;">'+
                        '</div>'+
                        '<div id="shandong-jibie" title="级别" style="padding:10px;">'+
                        '</div>'+
                    '</div>'+
                    '<div style="margin:20px 0 10px 0;"></div>'+
                    '<div class="easyui-panel" title="条件查询" style="width:760px;height:200px;padding:10px;">'+
                    	 '<table cellpadding="5">'+
                            '<tr>'+
                            	'<td>选择查询城市：</td>'+
                            	'<td><select id="select1_shandong" style="width:150px;"editable="false" panelHeight="auto"></select></td>'+
                            '</tr>'+
                            '<tr>'+
                            	'<td>选择查询一级专业：</td>'+
                            	'<td><select id="select2_shandong" style="width:150px;"editable="false" panelHeight="auto"></select></td>'+
                                '<td>选择查询二级专业：</td>'+
                                '<td><select id="select3_shandong" style="width:150px;"editable="false" panelHeight="auto"></select></td>'+
                            '</tr>'+
                            '<tr>'+
                            	'<td>选择查询性别：</td>'+
                            	'<td>'+
                                	'<select class="easyui-combobox" name="state" editable="false" style="width:200px;"panelHeight="auto">'+
                                        '<option value="M">男</option>'+
                                        '<option value="W">女</option>'+
                                     '</select>'+
                                '</td>'+
                            '</tr>'+
                            '<tr>'+
                            	'<td>选择查询学历：</td>'+
                            	'<td>'+
                                	 '<select class="easyui-combobox" name="state" editable="false" style="width:200px;"panelHeight="auto">'+
                                        '<option value="XX">小学</option>'+
                                        '<option value="CZ">初中</option>'+
                                        '<option value="GZ">高中</option>'+
                                        '<option value="DZ">大专</option>'+
                                        '<option value="BK">本科</option>'+
                                        '<option value="YJS">研究生</option>'+
                                        '<option value="QT">其他</option>'+
                                     '</select>'+
                                '</td>'+
                            '</tr>'+
                            '<tr>'+
                            	'<td>选择查询年龄：</td>'+
                            	'<td>'+
                                	'<select class="easyui-combobox" name="state" editable="false" style="width:200px;"panelHeight="auto">'+
                                        '<option value="1">小于20</option>'+
                                        '<option value="2">20-30</option>'+
                                        '<option value="3">30-40</option>'+
                                        '<option value="4">40-50</option>'+
                                        '<option value="5">50-60</option>'+
                                        '<option value="6">60以上</option>'+
                                     '</select>'+
                                '</td>'+
                            '</tr>'+
                        '</table>'+
 						'<div style="margin:20px 0;">'+
                            '<a href="javascript:void(0)" class="easyui-linkbutton" onclick="center_shandong()">查询</a>'+
                        '</div>'+
                    '</div>'+
                '</div>'
				
			 $('#tt').tabs('add',{
                title: obj.name+'省',
                content: NewPage,
                closable: true,
				iconCls:'icon-add'
            });
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-zhuanye")); 
var option = {
title : {
text: "不同专业参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["果树嫁接","苹果栽培管理","猕猴桃栽培管理","枣栽培管理（冬枣）","核桃栽培管理","杂果栽培管理（桃、杏、樱桃）","设施蔬菜栽培管理","生猪饲养管理","奶山羊饲养管理","鸡饲养管理（肉鸡、蛋鸡）","兔饲养管理","牛饲养管理（肉牛、奶牛）","动物疫病防治","动物繁殖","蔬菜植物保护","农作物植物保护","果树植物保护","农作物种子繁殖","花卉园艺","绿化种苗","食用菌培养","农村经济管理"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考专业",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:0, name:"果树嫁接"},
{value:310, name:"苹果栽培管理"},
{value:234, name:"猕猴桃栽培管理"},
{value:135, name:"枣栽培管理（冬枣）"},
{value:1548, name:"核桃栽培管理"},
{value:0, name:"杂果栽培管理（桃、杏、樱桃）"},
{value:310, name:"设施蔬菜栽培管理"},
{value:234, name:"生猪饲养管理"},
{value:0, name:"奶山羊饲养管理"},
{value:1548, name:"鸡饲养管理（肉鸡、蛋鸡）"},
{value:335, name:"兔饲养管理"},
{value:0, name:"牛饲养管理（肉牛、奶牛）"},
{value:234, name:"动物疫病防治"},
{value:0, name:"动物繁殖"},
{value:1548, name:"蔬菜植物保护"},
{value:335, name:"农作物植物保护"},
{value:310, name:"果树植物保护"},
{value:234, name:"农作物种子繁殖"},
{value:135, name:"花卉园艺"},
{value:1548, name:"绿化种苗"},
{value:0, name:"食用菌培养"},
{value:0, name:"农村经济管理"}
]
}
]
};
myChart.setOption(option); 
}
);
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-shengfen")); 
var option = {
title : {
text: "不同省参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["北京","天津","上海","重庆","河北省","山西省","内蒙古","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西省","海南省","四川省","贵州省","云南省","西藏","陕西省","甘肃省","青海省","宁夏","新疆","香港","澳门","台湾省"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考省份",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:0, name:"北京"},
{value:310, name:"天津"},
{value:234, name:"上海"},
{value:135, name:"重庆"},
{value:1548, name:"河北省"},
{value:0, name:"山西省"},
{value:310, name:"内蒙古"},
{value:234, name:"辽宁省"},
{value:0, name:"吉林省"},
{value:1548, name:"黑龙江省"},
{value:335, name:"江苏省"},
{value:0, name:"浙江省"},
{value:234, name:"安徽省"},
{value:0, name:"福建省"},
{value:1548, name:"江西省"},
{value:335, name:"山东省"},
{value:310, name:"河南省"},
{value:234, name:"湖北省"},
{value:135, name:"湖南省"},
{value:1548, name:"广东省"},
{value:0, name:"广西省"},
{value:0, name:"海南省"},
{value:234, name:"四川省"},
{value:0, name:"贵州省"},
{value:1548, name:"云南省"},
{value:0, name:"西藏"},
{value:310, name:"陕西省"},
{value:0, name:"甘肃省"},
{value:135, name:"青海省"},
{value:1548, name:"宁夏"},
{value:335, name:"新疆"},
{value:310, name:"香港"},
{value:0, name:"澳门"},
{value:135, name:"台湾省"}
]
}
]
};
myChart.setOption(option); 
}
);
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-xingbie")); 
var option = {
title : {
text: "男女参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["男","女"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考性别",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:256, name:"男"},
{value:310, name:"女"}
]
}
]
};
myChart.setOption(option); 
}
);
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-xueli")); 

var option = {
title : {
text: "不同学历水平参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["小学","初中","高中","大专","本科","研究生","其他"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考学历水平",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:256, name:"小学"},
{value:310, name:"初中"},
{value:296, name:"高中"},
{value:580, name:"大专"},
{value:406, name:"本科"},
{value:150, name:"研究生"},
{value:203, name:"其他"}
]
}
]
};
myChart.setOption(option); 
}
);
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-nianling")); 

var option = {
title : {
text: "不同年龄参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["20以下","20-30","34-40","40-50","50-60","60以上"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考年龄",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:25, name:"20以下"},
{value:310, name:"20-30"},
{value:234, name:"30-40"},
{value:135, name:"40-50"},
{value:1548, name:"50-60"},
{value:55, name:"60以上"}								  
]
}
]
};
myChart.setOption(option); 
}
);
require.config({
paths: {
echarts: "echarts-2.2.7/build/dist"
}
});
require(
[
"echarts",
"echarts/chart/pie",
"echarts/chart/funnel"
],
function (ec) {
var myChart = ec.init(document.getElementById("shandong-jibie")); 

var option = {
title : {
text: "不同级别参加报考人员数量",
subtext: "",
x:"center"
},
tooltip : {
trigger: "item",
formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
orient : "vertical",
x : "left",
data:["农技员","农技师","高级农技师"]
},
toolbox: {
show : true,
feature : {
mark : {show: true},
dataView : {show: true, readOnly: false},
magicType : {
show: true, 
type: ["pie", "funnel"],
option: {
funnel: {
x: "25%",
width: "50%",
funnelAlign: "left",
max: 1548
}
}
},
restore : {show: true},
saveAsImage : {show: true}
}
},
calculable : true,
series : [
{
name:"报考级别",
type:"pie",
radius : "55%",
center: ["50%", "60%"],
data:[
{value:256, name:"农技员"},
{value:310, name:"农技师"},
{value:234, name:"高级农技师"},
]
}
]
};
myChart.setOption(option); 
}
);
$(function(){
var obj = province;
var select1=document.getElementById("select1_shandong");
for(i=select1.length;i>=0;i--){
select1.remove(i);
}	
for(i=0;i<obj.length;i++){
var newOption= document.createElement("OPTION");
newOption.text=obj[i].text;
newOption.value=obj[i].id;
select1.options.add(newOption);  
}
$("#select1").combobox({
onChange : function(newValue, oldValue) {}
});
});
$(function(){
var obj = Major;
var select2=document.getElementById("select2_shandong");
for(i=select2.length;i>=0;i--){
select2.remove(i);
}
for(i=0;i<obj.length;i++){
var newOption= document.createElement("OPTION");
newOption.text=obj[i].text;
newOption.value=obj[i].id;
select2.options.add(newOption);  
}
$("#select2_shandong").combobox({
onChange : function(newValue, oldValue) {
switch (newValue) {
case "0":
var data=[];
break;
case "1":
var data=Major1;
break;
case "2":
var data=Major2;
break;
case "3":
var data=Major3;
break;
case "4":
var data=Major4;
break;
case "5":
var data=Major5;
break;
default:
break;
}
$("#select3_shandong").combobox("loadData", data);
}
});
$("#select3_shandong").combobox(
{
onChange : function(newValue, oldValue) {
}
})
});
function alert_shandong(){
$.messager.alert("My Title","Here is a message!");
}
// JavaScript Document
        }
		
	});
	
});
var province=[{"id": "0","text": "--选择省份--"},{"id": "1","text": "安徽"},{"id": "2","text": "北京"},{"id": "3","text": "福建"},{"id": "4","text": "甘肃"},{"id": "4","text": "广东"},{"id": "6","text": "广西"},{"id": "7","text": "贵州"},{"id": "8","text": "海南"},{"id": "9","text": "河北"},{"id": "10","text": "河南"},{"id": "11","text": "黑龙江"},{"id": "12","text": "湖北"},{"id": "13","text": "湖南"},{"id": "14","text": "吉林"},{"id": "15","text": "江苏"},{"id": "16","text": "江西"},{"id": "17","text": "辽宁"},{"id": "18","text": "内蒙古"},{"id": "19","text": "宁夏"},{"id": "20","text": "青海"},{"id": "21","text": "山东"},{"id": "22","text": "山西"},{"id": "23","text": "陕西"},{"id": "24","text": "上海"},{"id": "25","text": "四川"},{"id": "26","text": "天津"},{"id": "27","text": "新疆"},{"id": "28","text": "西藏"},{"id": "29","text": "云南"},{"id": "30","text": "浙江"},{"id": "31","text": "重庆"},{"id": "32","text": "香港"},{"id": "33","text": "澳门"},{"id": "34","text": "台湾"},{"id": "35","text": "国外"}];
var Major=[{"id": "0","text": "--选择专业--"},{"id":"1","text":"果树管理"},{"id":"2","text":"设施蔬菜"},{"id":"3","text":"畜牧养殖"},{"id":"4","text":"植物保护"},{"id":"5","text":"其它"}];
var Major1=[{"id":"1","text":"果树嫁接"},{"id":"2","text":"苹果栽培管理"},{"id":"3","text":"猕猴桃栽培管理"},{"id":"4","text":"枣栽培管理（冬枣）"},{"id":"5","text":"核桃栽培管理"},{"id":"6","text":"杂果栽培管理（桃、杏、樱桃）"}];
var Major2=[{"id":"1","text":"设施蔬菜栽培管理"}];
var Major3=[{"id":"1","text":"生猪饲养管理"},{"id":"2","text":"奶山羊饲养管理"},{"id":"3","text":"鸡饲养管理（肉鸡、蛋鸡）"},{"id":"4","text":"兔饲养管理"},{"id":"5","text":"牛饲养管理（肉牛、奶牛）"},{"id":"6","text":"动物疫病防治"},{"id":"7","text":"动物繁殖"}];
var Major4=[{"id":"1","text":"蔬菜植物保护"},{"id":"2","text":"农作物植物保护"},{"id":"3","text":"果树植物保护"}];
var Major5=[{"id":"1","text":"农作物种子繁殖"},{"id":"2","text":"花卉园艺"},{"id":"3","text":"绿化种苗"},{"id":"4","text":"食用菌培养"},{"id":"5","text":"农村经济管理"}];

$(function(){
	var obj = province;
	
	var select1=document.getElementById("select1");
	
	
	for(i=select1.length;i>=0;i--){
		select1.remove(i);
	}	

	for(i=0;i<obj.length;i++){
		var newOption= document.createElement("OPTION");
		newOption.text=obj[i].text;
		newOption.value=obj[i].id;
        select1.options.add(newOption);  
	}
	$("#select1").combobox({
				onChange : function(newValue, oldValue) {}
			});
});

$(function(){
	var obj = Major;
	
	var select2=document.getElementById("select2");
	
	for(i=select2.length;i>=0;i--){
		select2.remove(i);
	}

	for(i=0;i<obj.length;i++){
		var newOption= document.createElement("OPTION");
		newOption.text=obj[i].text;
		newOption.value=obj[i].id;
        select2.options.add(newOption);  
	}
	
	$("#select2").combobox({
				onChange : function(newValue, oldValue) {
					switch (newValue) {
					case "0":
						var data=[];
					break;
					case "1":
						var data=Major1;
						break;
					case "2":
						var data=Major2;
						break;
					case "3":
						var data=Major3;
						break;
					case "4":
						var data=Major4;
						break;
					case "5":
						var data=Major5;
						break;
					default:
						break;
					}
					$("#select3").combobox("loadData", data);
				}
			});
	$("#select3").combobox(
					{
						onChange : function(newValue, oldValue) {
						}
					})
					
});
function center(){
            $.messager.show({
                title:'查询结果',
                msg:'查询结果为',
                showType:'fade',
                style:{
                    right:'',
                    bottom:''
                }
            });
        }
		
		
