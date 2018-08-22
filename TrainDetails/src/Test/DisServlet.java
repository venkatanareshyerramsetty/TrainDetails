package Test;
import java.io.*;
import javax.servlet.*;

public class DisServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) 
	throws ServletException, IOException {
		
	 PrintWriter pw = res.getWriter();
	 res.setContentType("text/html");
	 String uName=req.getParameter("username");
	 pw.println("<br> loginn successufull");
	 pw.println("<br> Welcome:"+uName);
	}

}
