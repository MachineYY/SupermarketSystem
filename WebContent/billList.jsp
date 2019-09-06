<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
    <%@ page import="java.util.*"%>
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
                    <li id="active"><a href="billList.jsp">账单管理</a></li>
                    <li><a href="providerList.jsp">供应商管理</a></li>
                    <li><a href="userList.jsp">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>账单管理页面</span>
            </div>
            <div class="search">
                <span>商品名称：</span>
                <input type="text" placeholder="请输入商品的名称"/>
                
                <span>供应商：</span>
                <select name="tigong" >
                    <option value="">--请选择--</option>
                    <option value="">北京市粮油总公司</option>
                    <option value="">邯郸市五得利面粉厂</option>
                </select>

                <span>是否付款：</span>
                <select name="fukuan">
                    <option value="">--请选择--</option>
                    <option value="">已付款</option>
                    <option value="">未付款</option>
                </select>

                <input type="button" value="查询"/>
                <a href="billAdd.jsp">添加订单</a>
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账单编码</th>
                    <th width="10%">商品名称</th>
                    <th width="10%">商品单位</th>
                    <th width="10%">商品数量</th>
                    <th width="10%">账单金额</th>
                    <th width="10%">供应商</th>
                    <th width="10%">是否付款</th>
                    <th width="30%">操作</th>
                   
                </tr>
                <tr>
                <%
			try{
				
				Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
				String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
				String user="root";//登录数据库的用户名
				String password="root";//登录数据库的用户名的密码
				Connection conn=DriverManager.getConnection(url,user,password);
				java.sql.Statement stmt=conn.createStatement();//获取statement对象
				
				
				String sql="select * from bill_info";
				//out.println(S_number);
				ResultSet rs=stmt.executeQuery(sql);
				List<String> list = new ArrayList<String>();         //list
			       while(rs.next()) {    
			    	   list.add (rs.getString("Bill_number"));
			    	   list.add (rs.getString("Bill_Pname"));
			    	   list.add (rs.getString("Bill_Punit"));
			    	   list.add (rs.getString("Bill_Pquantity"));
			    	   list.add (rs.getString("Bill_Total"));
			    	   list.add (rs.getString("Bill_Pprovider"));
			    	   list.add (rs.getString("Bill_State"));
						//将Name加入到list中
			           
			       } 
			
					// 判断集合是否有效
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历
						
						for(int m=0;m<list.size();m++){
							if(0==(m%7)&&(m!=0)){out.println("<tr>");}
							
							out.println("<td>"+list.get(m)+"</td>");
							
							if(0==((m+1)%7)&&(m!=0)){
								%> 
								
                       <!--  <a href="billView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="billUpdate.jsp"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a> -->
									<td>
					                <a href="Bill_View?Bill_number=<%=list.get(m-6)%>"><img src="img/read.png" alt="查看" title="查看"/></a>
					                <a href="billUpdate.jsp?Bill_number=<%=list.get(m-6)%>"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
					                <a href="Bill_Delete?Bill_number=<%=list.get(m-6)%>" class="removeProvider"><img src="img/schu.png" alt="删除" title="删除"/></a>
					                </td>
					            <%
					            }
					}
				}
					
					
				rs.close();
				stmt.close();
				conn.close() ;
			}
        catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
			
			
		%>
                
            </tr>
        </table>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>

</html>