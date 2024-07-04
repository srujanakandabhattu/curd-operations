package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getall {
	private static final String Driver ="com.mysql.cj.jdbc.Driver";
	private static final  String Username="root";
	private static final String Password="root";
	
	
	public static void main(String[] args) {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("provide database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("enter the table name :");
			String sql ="select * from " + src.next();
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			ResultSet rs =pmst.executeQuery();
			while(rs.next()){
				System.out.println("**********");
				System.out.println("id :" + rs.getInt("id"));
				System.out.println("name :" + rs.getString("name"));
				System.out.println("email :" + rs.getString("email"));
				System.out.println("**********");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



       
			
        	

