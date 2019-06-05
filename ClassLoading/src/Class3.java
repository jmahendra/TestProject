import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class3 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="insert into emp values(15,'mangi',78000)";
		
		String sql1="insert into emp values(16,'mangi',78000)";
		String sql2="insert into emp values(17,'mangi',78000)";
		String sql3="insert into emp values(18,'mangi',78000)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("donuu");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","dinga");
			System.out.println("connection established..");
			
			stmt=con.createStatement();
			
		stmt.addBatch(sql);
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
	
		
	int[] n=	stmt.executeBatch();
	
	System.out.println(n.length+" row affected//");
	
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
