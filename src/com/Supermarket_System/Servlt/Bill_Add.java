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
 * Servlet implementation class Bill_Add
 */
@WebServlet("/Bill_Add")
public class Bill_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_Add() {
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
		String Bill_Pname=request.getParameter("Bill_Pname");
		String Bill_Punit=request.getParameter("Bill_Punit");
		String Bill_Pquantity=request.getParameter("Bill_Pquantity");
		String Bill_Total=request.getParameter("Bill_Total");
		String Bill_Pprovider=request.getParameter("Bill_Pprovider");
		String Bill_State=request.getParameter("Bill_State");
		//System.out.print(Provider_ctime);
		try {
			  Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
		      String url="jdbc:mysql://localhost:3306/supermarket_system?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
		      String user="root";//登录数据库的用户名
		      String password="root";//登录数据库的用户名的密码
		      Connection conn=DriverManager.getConnection(url,user,password);
		      //java.sql.Statement stmt=conn.createStatement();//获取statement对象
		     // pstate=conn.prepareStatement("update user set name=?,age=? where name=?");
		      String sql="insert into Bill_info(Bill_number,Bill_Pname,Bill_Punit,Bill_Pquantity,Bill_Total,Bill_Pprovider,Bill_State) values(?,?,?,?,?,?,?)";
		      java.sql.PreparedStatement ps=conn.prepareStatement(sql);

		      ps.setString(1,Bill_number);
	          ps.setString(2,Bill_Pname);
		      ps.setString(3,Bill_Punit);
		      ps.setString(4,Bill_Pquantity);
		      ps.setString(5,Bill_Total);
		      ps.setString(6,Bill_Pprovider);
		      ps.setString(7,Bill_State);
		   
		      ps.executeUpdate();
		      ps.close();
		      conn.close();
		      /*PrintWriter out=response.getWriter();//取得输出流
	    		out.println("<html>");//输出的内容要放在HTML中
	    		out.println("<body>");
	    		out.println("账单信息添加成功！<a href=\"billList.jsp\">点击返回</a>");
	    		out.println("</body>");
	    		out.println("</html>");*/
		     
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
