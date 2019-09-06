package com.Supermarket_System.Servlt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Update
 */
@WebServlet("/User_Update")
public class User_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Update() {
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
		String User_name=request.getParameter("User_name");
		String User_sex=request.getParameter("User_sex");
		String User_age=request.getParameter("User_age");
		String User_tel=request.getParameter("User_tel");
		String User_address=request.getParameter("User_address");
		String User_flag=request.getParameter("User_flag");
		//System.out.print(Provider_ctime);
		try {
			  Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
		      String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
		      String user="root";//登录数据库的用户名
		      String password="root";//登录数据库的用户名的密码
		      Connection conn=DriverManager.getConnection(url,user,password);
		      //java.sql.Statement stmt=conn.createStatement();//获取statement对象
		     // pstate=conn.prepareStatement("update user set name=?,age=? where name=?");
		      String sql="update User_info set User_name=?,User_sex=?,User_age=?,User_tel=?,User_address=?,User_flag=? where User_id=?";
		      java.sql.PreparedStatement ps=conn.prepareStatement(sql);

		      
	          ps.setString(1,User_name);
		      ps.setString(2,User_sex);
		      ps.setString(3,User_age);
		      ps.setString(4,User_tel);
		      ps.setString(5,User_address);
		      ps.setString(6,User_flag);
		      ps.setString(7,User_id);
		      ps.executeUpdate();
		      ps.close();
		      conn.close();
		     
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("userList.jsp");
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
