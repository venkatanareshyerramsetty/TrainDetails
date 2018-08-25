package Test;
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class RegServlet extends GenericServlet {
	public void init()throws ServletException
	{}


	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		PrintWriter  pw = res.getWriter();
		res.setContentType("text/html");
		String pHno=req.getParameter("phoneno");
		String pWord=req.getParameter("password");
		String Name=req.getParameter("name");
		String mailId=req.getParameter("mailid");
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into regbook9 values(?,?,?,?)");
			ps.setString(1, pHno);
			ps.setString(2, pWord);
			ps.setString(3, Name);
			ps.setString(4, mailId);
			
			int k=ps.executeUpdate();
			if(k==1)
			{
				pw.println("<br> Registration successfull");
				
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
			
					
		}
		
		     catch(Exception e)
		{
		    	 System.out.println(e);
		}
		
		
	}
	
	   
}