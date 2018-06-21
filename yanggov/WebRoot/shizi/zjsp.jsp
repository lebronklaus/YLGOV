<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<style type="text/css">
.tables thead
{
  font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
  font-weight: bold;
  font-size: 20px;
  text-align:center;

}
.tables tbody
{
font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
font-size:14px
}
pre {
    display: block;
    padding: 9.5px;
    margin: 0 0 10px;
    font-size: 13px;
    line-height: 1.42857143;
    color: #333;
    word-break: break-all;
    word-wrap: break-word;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
}
p {
	font-size: 14px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

<link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/kjzy_sp.css" />

<script type="text/javascript" src="shizi/shizijs/jquery1.42.min.js"></script>
<script type="text/javascript" src="shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
<script language="javascript" src="shizi/shizijs/main.js"></script>
<script type="text/javascript">
	function gotosearch(){
		var val = $('#val').val();
		$('#search').attr("method","post");
		$('#search').attr("action","./teacher/gotosearch.action?name="+val);
	}
</script>
</head>
<body>

<div class="top">
	<div class="ding">
		<div class="ding_top">
			<div class="ding_aa">
						 <a href="../FTMS/pages/Register.jsp" ">农民注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						 <!-- <a href="../FTMS/pages/YuanQiRegister.jsp">园企注册</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
						 <a href="./connectus.jsp">联系我们</a>
					</div>
		</div>
	</div>	
	<div class="logo">
		<a href=""><img src="images/logo.png" /></a>
	</div>
</div>

<div class="hang">
	<div class="dao_hang">
		<div class="dao_left">
			<ul>
						<li class="bian">
							<a href="<%=path %>/getAllList.action">首页</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/before/jianjie/jianjie.jsp">中心简介</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewsdt.action">工作动态</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenews.action">通知公告</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewszc.action">政策信息</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/peixun.action">培训资源</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewskx.action">三农快讯</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/xuqiu.action">需求征集</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/yuanqi.action">园企信息</a>
						</li>
					</ul>	
		</div>		
		<div class="dao_right">
					<form id="search" action="">
						<input id="val" class="sub" />
						<input class="sou" type="submit" value="搜索" onclick="gotosearch()" />
					</form>
				</div>
	</div>
	<div style="clear:both;"></div>
</div>

<!-- 网页内容                     ----------------------------------------  -->
<div class="xq_zhong_3">
		<div class="xq_div2_div1_3">
				<div class="xq_div2_top">
					<div class="xq_top_img">
						<img src="images/xq_wu.png" />
					</div>
					<div class="xq_top_wen_3">
						<span>您当前位置： 培训资源 ><a id ="peixun">专家视频库</a></span>					
					</div>				
				</div>
		</div>
	  <div style="width:100%;height:20%;">
    	<%-- <div class="left_top">
    		<div id="title"><s:property value="tzhi.resources_title"/>养牛专业户</div>
        	<div id="writer">作者：<s:property value="tzhi.resources_author"/><span>发布时间：<s:property value="tzhi.resources_time"/></span><span>来源：<s:property value="tzhi.resources_from"/></span></div>
   	    </div> --%>

			<table class="tables" style="width: 100%;  margin-top:10px">
				<thead>
					<tr>
						<td><s:property value="tzhi.resources_title"></s:property></td>
					</tr>
				</thead>
			</table>

			<div 
				style="  width:100%;height: 20px; line-height: 20px;  margin-top: 10px;   font-size: 12px;  color: #6d6d6d; text-align: center;">
				<span>作者：</span>
				<s:property value="tzhi.resources_author" />&nbsp;|
				<span>发布日期：</span>
				<s:property value="tzhi.resources_time" />&nbsp;|
				<span>视频来源：</span>
				<s:property value="tzhi.resources_from" />
			</div>
			<!--分割线-->
    <div class="left_article_line_right" style="width:1178px;"></div>
    <div style="height:30px"></div>
    <!--视频-->
    <input type="hidden" value="<s:property value="path"/>" id="addr"/>
 	 <div id="video" class="tempsp"><div id="a1" style="position: relative; display: block; width: 660px; height: 400px;"></div></div> 
 	 
    <script type="text/javascript" src="ckplayer/ckplayer.js" charset="utf-8"></script>
    <script type="text/javascript">
	//如果你不需要某项设置，可以直接删除，注意var flashvars的最后一个值后面不能有逗号
	 var addr=document.getElementById("addr").value;
	 //alert(addr);
   
	 var flashvars={
	    //f:'http://movie.ks.js.cn/flv/other/01.mp4',//视频地址
	    //alert("123"+addr);
	    f:addr,
	
		a:'',//调用时的参数，只有当s>0的时候有效
		s:'0',//调用方式，0=普通方法（f=视频地址），1=网址形式,2=xml形式，3=swf形式(s>0时f=网址，配合a来完成对地址的组装)
		c:'0',//是否读取文本配置,0不是，1是
		x:'',//调用xml风格路径，为空的话将使用ckplayer.js的配置
		i:'http://localhost:8080/Transfer/images/topshow.png',//初始图片地址
		u:'',//暂停时如果是图片的话，加个链接地址
		t:'10|10',//视频开始前播放swf/图片时的时间，多个用竖线隔开
		y:'',//这里是使用网址形式调用广告地址时使用，前提是要设置l的值为空
		e:'3',//视频结束后的动作，0是调用js函数，1是循环播放，2是暂停播放并且不调用广告，3是调用视频推荐列表的插件，4是清除视频流并调用js功能和1差不多，5是暂停播放并且调用暂停广告
		v:'80',//默认音量，0-100之间
		p:'1',//视频默认0是暂停，1是播放
		h:'0',//播放http视频流时采用何种拖动方法，=0不使用任意拖动，=1是使用按关键帧，=2是按时间点，=3是自动判断按什么(如果视频格式是.mp4就按关键帧，.flv就按关键时间)，=4也是自动判断(只要包含字符mp4就按mp4来，只要包含字符flv就按flv来)
		q:'',//视频流拖动时参考函数，默认是start
		m:'1',//默认是否采用点击播放按钮后再加载视频，0不是，1是,设置成1时不要有前置广告
		o:'',//当m=1时，可以设置视频的时间，单位，秒
		w:'',//当m=1时，可以设置视频的总字节数
		g:'',//视频直接g秒开始播放
		j:'',//视频提前j秒结束
		k:'30|60',//提示点时间，如 30|60鼠标经过进度栏30秒，60秒会提示n指定的相应的文字
		//n:'这是提示点的功能，如果不需要删除n的值|提示点测试60秒',//提示点文字，跟k配合使用，如 提示点1|提示点2
		
		my_url:encodeURIComponent(window.location.href)//本页面地址
		//调用自定义播放器参数结束
		};
	var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};//这里定义播放器的其它参数如背景色（跟flashvars中的b不同），是否支持全屏，是否支持交互
	var attributes={id:'ckplayer_a1',name:'ckplayer_a1',menu:'false'};
	//下面一行是调用播放器了，括号里的参数含义：（播放器文件，要显示在的div容器，宽，高，需要flash的版本，当用户没有该版本的提示，加载初始化参数，加载设置参数如背景，加载attributes参数，主要用来设置播放器的id）
	CKobject.embedSWF('ckplayer/ckplayer.swf','a1','ckplayer_a1','660','400',flashvars,params);
	//swfobject.embedSWF('ckplayer/ckplayer.swf', 'a1', '743', '430', '10.0.0','ckplayer/expressInstall.swf', flashvars, params, attributes);
	/*播放器地址，容器id，宽，高，需要flash插件的版本，flashvars,params,attributes
	  如果你因为目前的swfobject和你项目中的存在冲突，不想用swfobject.embedSWF调用，也可以用如下代码进行调用
	  CKobject.embedSWF('ckplayer/ckplayer.swf','a1','ckplayer_a1','600','400',flashvars,params);
	  CKobject.embedSWF(播放器路径,容器id,播放器id/name,播放器宽,播放器高,flashvars的值,其它定义也可省略);
	  此时可以删除ckplayer.js中的最后一行，交互的部分也要改成CKobject.getObjectById('ckplayer_a1')
	*/
	//调用ckplayer的flash播放器结束
	/*
	下面三行是调用html5播放器用到的
	var video='视频地址和类型';
	var support='支持的平台或浏览器内核名称';	
	*/
	//var video={'http://movie.ks.js.cn/flv/other/02.mp4':'video/mp4'};
	/*var video={'http://localhost:8080/Transfer/video/aganA.mp4':'video/mp4'};
	var support=['iPad','iPhone','ios','android+false','msie10+false'];//默认的在ipad,iphone,ios设备中用html5播放,android,ie10上没有安装flash的也调用html5
	CKobject.embedHTML5('video','ckplayer_a1',600,400,video,flashvars,support);
	/*
	如果不想使用html5播放器，只要把上面三行去掉就可以了
	=================================================================
	以下代码并不是播放器里的，只是播放器应用时用到的
	=================================================================
	*/
	function playerstop(){
		//只有当调用视频播放器时设置e=0或4时会有效果
		alert('播放完成');	
	}
	var _nn=0;//用来计算实时监听的条数的，超过100条记录就要删除，不然会消耗内存
	var watt=false;
	function ckplayer_status(str){
		_nn+=1;
		if(_nn>200){
			_nn=0;
			document.getElementById('statusvalue').value='';
		}
		document.getElementById('statusvalue').value=str+'\n'+document.getElementById('statusvalue').value;
		if(str=='video:play'){
			if(!watt){
				watt=true;
				setInterval('getstart()',1000);
			}
		}

	}
	function getstart(){
		var a=swfobject.getObjectById('ckplayer_a1').ckplayer_getstatus();
		var ss='';
		for (var k in a){
			ss+=k+":"+a[k]+'\n';
		}
		document.getElementById('obj').innerHTML=ss;
	}
	function aboutstr(str,f){//查看str字符里是否有f
		var about=false;
		var strarray=new Array();
		var farray=new Array();
		farray=f.split(",");
		if(str){
			for(var i=0;i<farray.length;i++){
				strarray=str.split(farray[i]);
				if(strarray.length>1){
					about=true;
					break;
				}
			}
		}
		return about;
	}
	function ckadjump(){
		alert("你点击了跳过广告按钮，注册成为本站会员，可不用观看前置广告");
	}
	//开关灯
	var box = new LightBox();
	function closelights(){//关灯
		box.Show();
		CKobject._K_('video').style.width='940px';
		CKobject._K_('video').style.height='550px';
		swfobject.getObjectById('ckplayer_a1').width=940;
		swfobject.getObjectById('ckplayer_a1').height=550;
	}
	function openlights(){//开灯
		box.Close();
		CKobject._K_('video').style.width='600px';
		CKobject._K_('video').style.height='400px';
		swfobject.getObjectById('ckplayer_a1').width=600;
		swfobject.getObjectById('ckplayer_a1').height=400;
	}
  </script>
  
  
    <!--简介-->
    <div id="info">
    	<div class="title">内容简介</div>
        <!-- <pre style="line-height: 20px;padding-left: 10px; border: dashed 1px #cacaca; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-spacing: break-word;"> -->
        <div style="display: block;line-height: 20px;    padding: 9.5px;padding-left: 10px; border: dashed 1px #cacaca;border-radius: 4px;font-size: 14px;font-family: 微软雅黑;" >
	        <s:property value="tzhi.resources_profile" escape="false"/>
        </div>
    </div>
  </div>
  
</div>
<div style="clear:both;"></div>


<div class="di">
	<p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
	<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p>
</div>

<!--lunbo------->
<script type="text/javascript">
		jQuery(".slideBoxx").slide({mainCell:".bd ul",autoPlay:true});
</script>
<!--lunbo------->


<!--------文字上下滚动-------------->


<script type="text/javascript">
	jQuery(".xq_left_div2").slide({mainCell:".xq_div1_div2 ul",autoPlay:true,effect:"topMarquee",vis:6,interTime:50});
</script>

</body>
</html>
