package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class droptable {
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
			String sql ="drop table " + src.next() ;
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			
			int i= pmst.executeUpdate();
			if(i==0) {
				System.out.println("table dropped");
			}
			else {
				System.out.println("error!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



       
			
        	
