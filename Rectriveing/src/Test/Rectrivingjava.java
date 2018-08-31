package Test;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Rectrivingjava {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
			PreparedStatement ps=con.prepareStatement("select * from product9");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+""+rs.getString(4));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
