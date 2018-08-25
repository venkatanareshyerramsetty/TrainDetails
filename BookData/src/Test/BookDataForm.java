package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BookDataForm extends GenericServlet{
	public void init()
			throws ServletException
			{
				
			}

			public void service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException
			{
				PrintWriter pw = res.getWriter();
				res.setContentType("text/html");
				String bCode = req.getParameter("code");
				String bName = req.getParameter("name");
				String bAuthor = req.getParameter("author");
				float bPrice= Float.parseFloat((req.getParameter("price")));
				
				pw.println("<br> product code:"+bCode);
				pw.println("<br> product Name:"+bName);
				pw.println("<br> product Author:"+bAuthor);
				pw.println("<br> product Price:"+bPrice);
				
				
				
			}
			
			public void distroy()
			{
				
			}
		}


