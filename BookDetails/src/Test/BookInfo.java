package Test;

import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class BookInfo extends GenericServlet {

	public void init()
	throws ServletException
	{}

	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	String bCode=req.getParameter("code");
	String bName=req.getParameter("name");
	String bAuthor=req.getParameter("author");
	float bPrice=Float.parseFloat(req.getParameter("price"));
	
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
		PreparedStatement ps=con.prepareStatement("insert into book9 values(?,?,?,?)");
		ps.setString(1, bCode);
		ps.setString(2, bName);
		ps.setString(3, bAuthor);
		ps.setFloat(4, bPrice);
		
		int k=ps.executeUpdate();
		
		if(k==1)
		{
			pw.println("Record is updated");
		}
	}

	catch(Exception e)
	{
		System.out.println(e);
		
	}
	
}
	
	public void distroy()
	{}
	
	}
		
	

