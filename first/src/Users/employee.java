package Users;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class employee {
	private static final String Driver ="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/";
	private static final  String Username="root";
	private static final String Password="root";
	
	
	public static void main(String[] args) {
		try {
		     Scanner src = new Scanner(System.in);
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("enter the database name :");
			String sql ="create database " + src.next() ;
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created");
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



       
			
        	
