package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletion {
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
			String sql ="delete from " +src.next() +" where email = ? ";
		
			PreparedStatement pmst =conn.prepareStatement(sql);
	
			System.out.println("enter email");
			pmst.setString(1, src.next());
			
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("data deleted");
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



       
			
        	
