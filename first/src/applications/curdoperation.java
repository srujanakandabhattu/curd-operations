package applications;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class curdoperation {
	private static final String Driver ="com.mysql.cj.jdbc.Driver";
	
	private static final  String Username="root";
	private static final String Password="root";
	public static void main(String[] args) {
		
		int ch;
		do {
			System.out.println("curd operation :");
			System.out.println("*********");
			display();
			Scanner src = new Scanner(System.in);
			System.out.println("enter your choice :");
			ch = Integer.parseInt(src.next());
			System.out.println("***********");
			
			switch(ch) {
			case 1: 
				createdatabase();
				break;
			
			case 2: 
				createtable();
				break;
			
			case 3: 
				insertion();
				break;
			case 4: 
				update();
				break;
			case 5: 
				delete();
				break;
			case 6: 
				getall();
				break;
			case 7: 
				getbyemail();
				break;
			case 8: 
				droptable();
				break;
			case 9: 
				dropdatabase();
				break;
			case 10: 
				System.exit(0);
				break;
			default: 
				System.out.println("INVALID OPERATION");
				break;
			}
		} while(ch>0);
	}

	private static void createtable() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next() ;
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
			String sql ="create table " + src.next() + "(id int,name varchar(20),email varchar(30))"; ;
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			
			int i= pmst.executeUpdate();
			if(i==0) {
				System.out.println("TABLE CREATED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	private static void droptable() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
			String sql ="drop table " + src.next() ;
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			
			int i= pmst.executeUpdate();
			if(i==0) {
				System.out.println("TABLE DROPPED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void insertion() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
			String sql ="insert into " +src.next() +"(id,name,email) values(?,?,?)";
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			System.out.println("Enter id:");
			pmst.setInt(1, src.nextInt());
			System.out.println("Enter name:");
			pmst.setString(2, src.next());
			System.out.println("Enter email");
			pmst.setString(3, src.next());
			
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("DATA INSERTED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void update() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
			String sql ="update  " +src.next() + " set name = ? ,email = ? where id = ?";
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			System.out.println("Enter name :");
			pmst.setString(1, src.next());
			System.out.println("Enter email :");
			pmst.setString(2, src.next());
			System.out.println("Enter id :");
			pmst.setInt(3, src.nextInt());
			
			
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("DATA UPDATED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
			String sql ="delete from " +src.next() +" where email = ? ";
		
			PreparedStatement pmst =conn.prepareStatement(sql);
	
			System.out.println("Enter email");
			pmst.setString(1, src.next());
			
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("DATA DELETED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	private static void getall() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter the table name :");
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

	private static void getbyemail() {
		try {
		     Scanner src = new Scanner(System.in);
		     System.out.println("Enter database name :");
		     String Url="jdbc:mysql://localhost:3306/" +src.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("enter the table name :");
			String sql ="select * from " + src.next() + " where email = ? ";
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			System.out.println("Enter email :");
			pmst.setString(1, src.next());
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

	private static void dropdatabase() {
		try {
		     Scanner src = new Scanner(System.in);
			Class.forName(Driver);
			String Url="jdbc:mysql://localhost:3306/";
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("enter the database name :");
			String sql ="drop database " + src.next() ;
		
			PreparedStatement pmst =conn.prepareStatement(sql);
			
			int i= pmst.executeUpdate();
			if(i==0) {
				System.out.println("DATABASE DROPPED");
			}
			else {
				System.out.println("ERROR!");
			}
			
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void createdatabase() {
			try {
				     Scanner src = new Scanner(System.in);
				     String Url="jdbc:mysql://localhost:3306/";
					Class.forName(Driver);
					 
					
					Connection conn = DriverManager.getConnection(Url, Username, Password);
					System.out.println("enter the database name :");
					String sql ="create database " + src.next() ;
				
					PreparedStatement pmst =conn.prepareStatement(sql);
					
					int i= pmst.executeUpdate();
					if(i>0) {
						System.out.println("DATABASE CREATED");
					}
					else {
						System.out.println("ERROR!");
					}
					
					conn.close();
					pmst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	private static void display() {
		System.out.println("\t1. Create database");
		System.out.println("\t2. Create table");
		System.out.println("\t3. Insertion");
		System.out.println("\t4. Update");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Get all");
		System.out.println("\t7. Ge tby email");
		System.out.println("\t8. Drop table");
		System.out.println("\t9. Drop database");
		System.out.println("\t10. Exit");
		
	}

}
