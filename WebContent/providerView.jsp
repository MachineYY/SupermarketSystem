<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.jsp">账单管理</a></li>
                <li id="active"><a href="providerList.jsp">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
           <!--  <p><strong>供应商编码：</strong><span>PRO-CODE—001</span></p>  
            <p><strong>供应商名称：</strong><span></span></p>
            <p><strong>联系人：</strong><span></span></p>
            <p><strong>联系电话：</strong><span></span></p>
            <p><strong>传真：</strong><span></span></p>
            <p><strong>描述： -->


			<%
				// 获取信息集合

					List<String> list = (List<String>)request.getAttribute("list");
					
					// 判断集合是否有效
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历
						for(int i=0;i<list.size();i++){
							
							if(i==0){out.println("<p><strong>供应商编码：</strong><span>");}
							if(i==1){out.println("<p><strong>供应商名称：</strong><span>");}
							if(i==2){out.println("<p><strong>联系人：</strong><span>");}
							if(i==3){out.println("<p><strong>联系电话：</strong><span>");}
							if(i==4){out.println("<p><strong>传真：</strong><span>");}
							if(i==5){out.println(" <p><strong>描述：</strong><span>");}
							//out.println("</strong><span>");
							//out.println("<p>"+list.get(i)+"</span></p>");
							out.println(list.get(i)+"</strong></p>");
						
					}
				}
			%>
            <a href="providerList.jsp">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>

</html>