package com.Supermarket_System.Servlt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		
		String User_id=request.getParameter("username");
		String User_password=request.getParameter("password");
		
		 try{
			  Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序
		      String url="jdbc:mysql://localhost:3306/Supermarket_System?useUnicode=true&characterEncoding=utf8";//连接数据库的url地址,后面的控制编码语句很重要
		      String user="root";//登录数据库的用户名
		      String password="root";//登录数据库的用户名的密码
		      Connection conn=DriverManager.getConnection(url,user,password);
		      
		      
		      if(conn!=null)
		      {
		    	  System.out.print("数据库连接成功！");
		      }
		      else
		      {
		    	  System.out.print("数据库连接失败！");
		      }
		      
		      //System.out.print(User_id);
		      Statement stmt=conn.createStatement();
		      String sql="select User_password from User_info where User_id=" + "'" + User_id + "'";//定义一个查询语句
			  ResultSet rs=stmt.executeQuery(sql);//运行上面的语句
			    if(rs.next())
			    {
			       
			        if(User_password.equals(rs.getObject("User_password"))){
			            response.sendRedirect("index.jsp");
			        }
			        else{
			        	
			        	PrintWriter out=response.getWriter();//取得输出流
			    		out.println("<html>");//输出的内容要放在HTML中
			    		out.println("<body>");
			    		out.println("<script language='javaScript'> alert('密码错误');</script>");
			    		out.println("</body>");
			    		out.println("</html>");
			           
			            response.setHeader("refresh", "0;url=login.jsp");
			        }
			    }
			    else 
			    {
			    	
			    	PrintWriter out=response.getWriter();//取得输出流
		    		out.println("<html>");//输出的内容要放在HTML中
		    		out.println("<body>");
		    		out.println("<script language='javaScript'> alert('账号错误');</script>");
		    		out.println("</body>");
		    		out.println("</html>");
			       
			        response.setHeader("refresh", "0;url=login.jsp");
			    }
		      
		 }
	      catch(ClassNotFoundException e)
	 		{
			e.printStackTrace();
	 		}
	 	  catch(SQLException e)
	 		{
			e.printStackTrace();
	 		}
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
