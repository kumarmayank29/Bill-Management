package com.higradius;
import java.util.*;
import java.sql.*;

public class TableToArrayList {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws Exception {
		System.out.println("a. Fetch and display the whole table data"+"\n"+"b. Fetch Alias, Quote column data using Serial");
		System.out.println("Enter choice : ");
		String c = sc.next();
		char ch = c.charAt(0);
//Registering the Driver
		//Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
//Getting the connection
		String mysqlUrl = "jdbc:mysql://localhost/infinitywars";
		
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
		switch(ch)
		 {
		 	case 'a' :
		 		//Creating a PreparedStatement object
				 String sql = "SELECT * FROM Avengers";
				 PreparedStatement pstmt = con.prepareStatement(sql);
				 //Retrieving the data
				 ResultSet rs = pstmt.executeQuery();
				//Creating an ArrayList object
				 ArrayList<Avengers> avengersList = new ArrayList<>();
				 //Adding the Records of the table to the Array List
				 while(rs.next()) 
				 {
					 Avengers obj= new Avengers();
					 obj.setfirst_name(rs.getString("first_name"));
					 obj.setlast_name(rs.getString("last_name"));
					 obj.setserial(rs.getInt("serial"));
					 obj.setalias(rs.getString("alias"));
					 obj.setquote(rs.getString("quote"));
					 avengersList.add(obj);
				 }
				 //Displaying the contents of ArrayList
				 for (Avengers obj : avengersList)
				 {
					 System.out.print("First name : "+obj.getfirst_name()+", ");
					 System.out.print("Last_Name : "+obj.getlast_name()+", ");
					 System.out.print("Serial : "+obj.getserial()+", ");
					 System.out.print("Alias : "+obj.getalias()+", ");
					 System.out.println("Quote : "+obj.getquote()); 
					 System.out.println();
				 }
			break;
		 	case 'b' :
		 		//Creating a PreparedStatement object
		 		PreparedStatement prep_stmt = con.prepareStatement("SELECT alias, quote FROM avengers where serial = ?");
		 		System.out.println("Enter the serial number : ");
		 		int x= sc.nextInt();
		 		prep_stmt.setInt(1, x);
		 		//Retrieving the data
		 		ResultSet rs1 = prep_stmt.executeQuery(); 
		 		//Creating an ArrayList object
				 ArrayList<Avengers> avgList = new ArrayList<>();
				 //Adding the Records of the table to the Array List
				 while(rs1.next()) 
				 {
					 Avengers obj= new Avengers();
					
					 obj.setalias(rs1.getString("alias"));
					 obj.setquote(rs1.getString("quote"));
					 avgList.add(obj);
				 }
				//Displaying the contents of ArrayList
				 for (Avengers obj : avgList)
				 {
					 
					 System.out.print("Alias : "+obj.getalias()+", ");
					 System.out.println("Quote : "+obj.getquote()); 
				 }
			break;
			default :
				System.out.println("Oops! Wrong choice");
				 
		 }
	}
}