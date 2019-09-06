package com.Supermarket_System.Servlt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Provider_Add
 */
@WebServlet("/Provider_Add")
public class Provider_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Provider_Add() {
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
		
		String Provider_number=request.getParameter("Provider_number");
		String Provider_name=request.getParameter("Provider_name");
		String Provider_contact=request.getParameter("Provider_contact");
		String Provider_tel=request.getParameter("Provider_tel");
		String Provider_fax=request.getParameter("Provider_fax");
		String Provider_ctime=request.getParameter("Provider_ctime");
		//System.out.print(Provider_ctime);
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
		      String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
		      String user="root";//登录数据库的用户名
		      String password="root";//登录数据库的用户名的密码
		      Connection conn=DriverManager.getConnection(url,user,password);
		      //java.sql.Statement stmt=conn.createStatement();//获取statement对象
		      String sql="insert into Provider_info(Provider_number,Provider_name,Provider_contact,Provider_tel,Provider_fax,Provider_ctime) values(?,?,?,?,?,?)";
		      java.sql.PreparedStatement ps=conn.prepareStatement(sql);

		      ps.setString(1,Provider_number);
	          ps.setString(2,Provider_name);
		      ps.setString(3,Provider_contact);
		      ps.setString(4,Provider_tel);
		      ps.setString(5,Provider_fax);
		      ps.setString(6,Provider_ctime);
		      ps.executeUpdate();
		      ps.close();
		      conn.close();
		      
		     /* 
		      PrintWriter out=response.getWriter();//取得输出流
	    		out.println("<html>");//输出的内容要放在HTML中
	    		out.println("<body>");
	    		out.println("供应商信息添加成功！<a href=\"providerList.jsp\">点击返回</a>");
	    		out.println("</body>");
	    		out.println("</html>");*/
		     
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("providerList.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
