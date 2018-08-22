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
		String uName=req.getParameter("username");
		String pWord=req.getParameter("password");
		String fName=req.getParameter("firstname");
		String lName=req.getParameter("lastname");
		String addr=req.getParameter("address");
		String pHno=req.getParameter("phoneno");
		String mId=req.getParameter("mailid");
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into regtrain9 values(?,?,?,?,?,?,?)");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, addr);
			ps.setString(6, pHno);
			ps.setString(7, mId);
			
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