package Test;
	
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class BookDetails extends GenericServlet {
public void init()throws ServletException
		{}


		public void service(ServletRequest req, ServletResponse res) 
				throws ServletException, IOException {
			PrintWriter  pw = res.getWriter();
			res.setContentType("text/html");
			String bookCode=req.getParameter("bookcode");
			try
			{
				Connection con = DBconnection.getCon();
				PreparedStatement ps = con.prepareStatement("select * from bookdata9 where bookCode=?");
				ps.setString(1, bookCode);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					pw.println("<br>bookCode:"+rs.getString(1));
					pw.println("<br>bookName:"+rs.getString(2));
					pw.println("<br>bookAuthor:"+rs.getString(3));
					pw.println("<br>bookPrice:"+rs.getString(4));
					pw.println("<br>bookQuality:"+rs.getString(5));
					
									
				}
				else {
					pw.println("<br>Invalid BookCode");
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
		
		




