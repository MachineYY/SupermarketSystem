package com.Supermarket_System.Servlt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bill_View
 */
@WebServlet("/Bill_View")
public class Bill_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");//控制servlet打印的内容编码方式（重要）
		request.setCharacterEncoding("UTF-8");
		
		String Bill_number=request.getParameter("Bill_number");
		
		//System.out.print(Provider_number);
		try{
			
			Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
			String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
			String user="root";//登录数据库的用户名
			String password="root";//登录数据库的用户名的密码
			Connection conn=DriverManager.getConnection(url,user,password);
			java.sql.Statement stmt=conn.createStatement();//获取statement对象
			String sql="select * from bill_info where Bill_number=" + "'" + Bill_number + "'";//定义一个查询语句
			//String sql="select * from provider_info where Provider_number=?";
			
			 
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
			request.setAttribute("list", list);
			rs.close();
			stmt.close();
			conn.close();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("billView.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
