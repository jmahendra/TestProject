import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassLoad2 {

	public static void main(String[] args)
	{
		Connection con=null;
				
		PreparedStatement pstmt=null;
		
		String sql="insert into emp values(?,?,?)";
				
		try 
		{
			// 1st step: class load
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("donuu");
			
			//2nd step:connection
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","dinga");
			
			System.out.println("connection established..");
			
			//3rd step:platform creation
			
			pstmt=con.prepareStatement(sql);
			
			System.out.println("platfrom created..");
			
			pstmt.setInt(1, 14);
			
			pstmt.setString(2, "Dingi");
			
			pstmt.setInt(3, 56000);
			
			int affect=pstmt.executeUpdate();
			
			System.out.println("affect row-->"+affect);
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
