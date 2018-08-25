package Test;
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class RServlet extends GenericServlet {
	public void init()throws ServletException
	{}


	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		PrintWriter  pw = res.getWriter();
		res.setContentType("text/html");
		String bCode=req.getParameter("Code");
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from book9 where bCode=?");
			ps.setString(1, bCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pw.println("<br>bCode:"+rs.getString(1));
				pw.println("<br>bName:"+rs.getString(2));
				pw.println("<br>bAuthor:"+rs.getString(3));
				pw.println("<br>bPrice:"+rs.getFloat(4));
				
			}
			else {
				pw.println("<br>Invalid Bookcode");
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
	
	


