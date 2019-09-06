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
 * Servlet implementation class User_View
 */
@WebServlet("/User_View")
public class User_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_View() {
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
		
		String User_id=request.getParameter("User_id");
		
		System.out.print(User_id);
		try{
			
			Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
			String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
			String user="root";//登录数据库的用户名
			String password="root";//登录数据库的用户名的密码
			Connection conn=DriverManager.getConnection(url,user,password);
			java.sql.Statement stmt=conn.createStatement();//获取statement对象
			String sql="select * from user_info where User_id=" + "'" + User_id + "'";//定义一个查询语句
			//String sql="select * from provider_info where Provider_number=?";
			
			 
			ResultSet rs=stmt.executeQuery(sql);
			
			
			List<String> list = new ArrayList<String>();         //list
		       while(rs.next()) {    
		    	 
		    	   list.add (rs.getString("User_id"));
		    	   list.add (rs.getString("User_name"));
		    	   list.add (rs.getString("User_sex"));
		    	   list.add (rs.getString("User_age"));
		    	   list.add (rs.getString("User_tel"));
		    	   list.add (rs.getString("User_address"));
		    	   list.add (rs.getString("User_flag"));
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
		request.getRequestDispatcher("userView.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
