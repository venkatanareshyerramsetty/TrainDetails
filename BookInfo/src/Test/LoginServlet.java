package Test;

import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class LoginServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res)
	throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pHno=req.getParameter("phoneno");
		String pWord=req.getParameter("password");
		
		try 
		{
		  Connection con = DBconnection.getCon();
		  PreparedStatement ps = con.prepareStatement
		  ("select * from regbook9 where pHno=? and pWord=?");
		  ps.setString(1, pHno);
		  ps.setString(2, pWord);
		  ResultSet rs=ps.executeQuery();
		  if(rs.next())
		  {
			  
			  RequestDispatcher ri=req.getRequestDispatcher("book.html");
			  ri.include(req, res);
		  }
		  else
		  {
			  pw.println("<br>invalid username or password");
			  RequestDispatcher rd=req.getRequestDispatcher("login.html");
			  rd.include(req, res);
		  }
		  
		}
		 catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}
	

}
