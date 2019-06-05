import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassLoad1 
{
	public static void main(String[] args)
	{
		Connection con=null;
		
		Statement stmt=null;
		
		ResultSet rs=null;
		
		//String sql="insert into emp value(13,'Dinga',44000)";
		
	String sql1="select * from emp";
		
		String sql2="delete from emp  where eId=13";
		try
		{
			//1st step-->class Loading..
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class Laodede successfully");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","dinga");
			
			System.out.println("connection established succesfully...");
			
			stmt=con.createStatement();
			
			System.out.println("platform created.....");
			
			int n=stmt.executeUpdate(sql2);
			
			//System.out.println("data stored..");
			
			rs=stmt.executeQuery(sql1);
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
