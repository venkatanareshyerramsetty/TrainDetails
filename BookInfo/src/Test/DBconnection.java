package Test;
import java.sql.*;

import org.eclipse.jdt.internal.compiler.util.CompoundNameVector;

public class DBconnection {
	private static Connection con=null;
	
	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
			
			
		}
		
		  catch(Exception e)
		{
			  System.out.println(e);
		}
		
	}
	
	    public static Connection getCon()
	    {
	    	return con;
	    }

}
