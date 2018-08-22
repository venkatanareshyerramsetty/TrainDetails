package Test;

import java.sql.Connection;
import java.sql.DriverManager;

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



