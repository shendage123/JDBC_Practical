package JDBC_Practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class School_form_jdbc {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID");
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		System.out.println("Enter Branch");
		String Branch=sc.next();
		System.out.println("Enter city");
		String city=sc.next();
		System.out.println("Enter Percentage");
		int percentage=sc.nextInt();
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
         PreparedStatement ps=con.prepareStatement("insert into school_form values(?,?,?,?,?,?,?)");
         ps.setInt(1,id);
         ps.setString(2, name);
         ps.setString(3, email);
         ps.setString(4, password);
         ps.setString(5, Branch);
         ps.setString(6, city);
         ps.setInt(7, percentage);
         int i=ps.executeUpdate();
         if(i>0)
         {
        	 System.out.println("Succefully Added");
         }
         else {
			System.err.println("Error");
		}
		
	}

}
