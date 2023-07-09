package JDBC_Practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_pecm {
	public static void main(String[] args) throws Exception {
		//------User Values------------
		String name1 = "naresh";
		String email1 = "naresh@gamil.com";
		String password1 = "naresh123";
		String gender1 = "male";
		String city1 = "U.S.A";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
		// Thise is a first way: PreparedStatement ps = con.prepareStatement(
        //				"insert into register values('nisha','nisha@gamil.com','nisha123','female','pahur')");
        //thise is c=second way to insert to data		PreparedStatement ps = con.prepareStatement("insert into register values('" + name1 + "','" + email1 + "','"
       //				+ password1 + "','" + gender1 + "','" + city1 + "')");
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, name1);
		ps.setString(2, email1);
		ps.setString(3, password1);
		ps.setString(4, gender1);
		ps.setString(5, city1);
		int i = ps.executeUpdate();
		if (i > 0) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");

		}
	}

}
