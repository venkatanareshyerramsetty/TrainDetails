package Test;

import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class TrainData extends GenericServlet {
	public void init()throws ServletException
	{}


	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		PrintWriter  pw = res.getWriter();
		res.setContentType("text/html");
		String trainNo=req.getParameter("trainno");
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from traindata9 where trainNo=?");
			ps.setString(1, trainNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pw.println("<br>trainNo:"+rs.getString(1));
				pw.println("<br>trainName:"+rs.getString(2));
				pw.println("<br>from_Station:"+rs.getString(3));
				pw.println("<br>to_Station:"+rs.getString(4));
				pw.println("<br>availibility:"+rs.getString(5));
				
				
				RequestDispatcher rd=req.getRequestDispatcher("train.html");
				 
								
			}
			else {
				pw.println("<br>Invalid TrainNo");
				 RequestDispatcher rd=req.getRequestDispatcher("train.html");
				  rd.include(req, res);
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
	
	


