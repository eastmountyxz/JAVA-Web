<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session = "true" %>
<jsp:directive.page import="DAO.TrainManageDAO"/>  
<jsp:directive.page import="bean.TrainManage"/>
<jsp:directive.page import="java.util.List"/> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>火车卡订票系统管理系统</title>
  </head>
  <body>
    <div align="center">
	   <div class="trainCSS">
	   <table width="1024"  height="150" cellpadding="0" cellspacing="0">
			<tr><td colspan="2">
				<img src="./image/logo.jpg" alt="logo" width="1024" height="149">		
			</td></tr>		
			<tr><td width="205"  bgcolor="#b7d7ec">
				<p align="center">
				<script language=JavaScript>
				today=new Date();
				function initArray(){
				this.length=initArray.arguments.length;
				for(var i=0;i<this.length;i++)
				this[i+1]=initArray.arguments[i];  }
				var d=new initArray(
				"星期日","星期一","星期二","星期三","星期四",	"星期五","星期六");
				document.write("<font color=##ff0000 style='font-size:12pt;font-family: 宋体'> ",
				today.getYear()+1900,"年",today.getMonth()+1,"月",today.getDate(),"日    ",d[today.getDay()+1],
							  "</font>" );
				</script> 
				</p>	
			    </td>	
				<td width="819" bgcolor="#b7d7ec">
				<marquee  direction="left" onmouseover=this.stop() onmouseout=this.start() scrollAmount=3 scrollDelay=100>
	             <FONT style="FONT-SIZE: 18px"color=blue>欢迎使用火车票订票系统管理系统 ，如有不足，敬请指导！</FONT>
	            </marquee>
	            </td>
	        </tr>
	        <tr><td height="12"></td></tr>
	  </table>
	  </div>
	  
	  <div class="trainCSS">
		<table border="0" width="1024" cellpadding="0" cellspacing="0">
		<tr><td width="130" bgcolor="#dfeaf1" valign="top">
		  <table width="100%" cellpadding="0" cellspacing="0"  border="0">
		  	<tr><td height="10"></td></tr>
			<tr><td align="center">	<font size="3" color="blue">管理员：xxx，欢迎您！</font></td></tr>
			<tr><td height="10"></td></tr>
			<tr>
				<td align="center"><p><a href="trainManage.jsp">
				<img src="image/ccxxgl-xz.jpg" width="194" height="37" border="0"></a><td>&nbsp;</td>
			</tr>
			<tr><td height="10"></td></tr>
			<tr><td align="center"><a href="buyManage.jsp">
				<img src="image/dpgl.jpg" width="194" height="37" border="0"></a>
			</td></tr>
			<tr><td height="10"></td></tr>
			<tr><td align="center"><a href="peopleManage.jsp">
				<img src="image/hygl.jpg" width="194" height="37" border="0"></a>
			</td></tr>					
			<tr><td height="10"></td></tr>
			<tr><td align="center"><a href="serverManage.jsp">									  
				<img src="image/spqktj.jpg" width="194" height="37" border="0"></a>
			</td></tr>
			<tr><td height="10"></td></tr>
			<tr><td align="center"><a href="infoManage.jsp">
				<img src="image/lygl.jpg" width="194" height="37" border="0"></a>								
			</td></tr>
			<tr><td height="10"></td></tr>
			<tr><td align="center"><a href="exitManage.jsp">
				<img src="image/exit.jpg" width="194" height="37" border="0"></a>								
			</td></tr>
		   </table>
		   </td>
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#dfeaf1">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="homepage.jsp">首页</a> &gt; 
						<a href="trainManage.jsp">车次信息管理</a> &gt; 插入车次</div>
					<br /><br />
				<form action="/TrainDatabase/servlet/InsertTrainAction" method="post">
				<table border="1" bordercolor="#12A0F5" align=center> 
					<tr>
						<td>火车车次:</td><td><input type="text" id="trainid" 
							name="trainid" style='font-size:18px' width=200/></td>
					</tr>
					<tr>
						<td>出发地:</td><td><input type="text" id="start" 
							name="start" style='font-size:18px' width=200/></td>
					</tr>
					<tr>
						<td>到达地:</td><td><input type="text" id="end" 
							name="end" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>行车时间:</td><td><input type="text" id="time" 
							name="time" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>硬座票价:</td><td><input type="text" id="yzprice" 
							name="yzprice" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>软座票价:</td><td><input type="text" id="rzprice" 
							name="rzprice" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>硬卧票价:</td><td><input type="text" id="ywprice" 
							name="ywprice" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>软卧票价:</td><td><input type="text" id="rwprice" 
							name="rwprice" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>车辆路线:</td><td>
							<textarea id="root" name="root" rows="5" 
								style="width:300px;font-size:18px"></textarea> 
						</td>
					</tr>
					<tr>
						<td colspan=2 align=center><input type="submit" 
							name="Submit" value="提交" style='font-size:18px' width=200/></td>
					</tr>
				</table>
				</form>
		        <br /><br />												
				</TD></tr>
			 </table>
			</td>
		</tr>
		<tr><td height="20"></td></tr>
		</table>
	  </div>
	  
	<div class="div">
	<!-- 底部版权所有界面 -->
	<TABLE class=wrapper border=0 cellSpacing=0 cellPadding=0 width="100%" align=center>
		 <TBODY>
		  <TR><TD style="LINE-HEIGHT: 100%" align="center"> 
		      <HR style="WIDTH: 96%; HEIGHT: 4px; COLOR: #02457c">
		     <font size="2"> <SCRIPT language=javascript src=""></SCRIPT>
		     <!-- target=_blank开启新的网页 -->
		     <BR><A href="aboutme.jsp">关于我们</A> | <A href="wzsm.jsp" 
				>网站声明</A> <BR>版权所有&copy;2014-2015 北京邮电大学 Eastmount<BR>
		      	京ICP备10009636号 </font>
		  </TD></TR>
		  </TBODY>
	 </TABLE>
	</div>
	</div>
  </body>
</html>
