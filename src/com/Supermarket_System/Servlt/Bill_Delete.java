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
 * Servlet implementation class Bill_Delete
 */
@WebServlet("/Bill_Delete")
public class Bill_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_Delete() {
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
		System.out.print(Bill_number);
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
		      String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
		      String user="root";//登录数据库的用户名
		      String password="root";//登录数据库的用户名的密码
		      Connection conn=DriverManager.getConnection(url,user,password);
		      //java.sql.Statement stmt=conn.createStatement();//获取statement对象
		      String sql="delete from bill_info where Bill_number=?";
		      java.sql.PreparedStatement ps=conn.prepareStatement(sql);
		   
		      ps.setString(1,Bill_number);
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
		response.sendRedirect("billList.jsp");
		
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
