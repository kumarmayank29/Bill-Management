package com.higradius;
import java.sql.*;
import java.util.Scanner;

public class TestConnection{
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/infinitywars";
// Database credentials
static final String USER = "root";
static final String PASS = "root";
public static void main(String[] args) {
Connection conn = null;
Statement stmt = null;
try{
//STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
//STEP 3: Open a connection
conn = DriverManager.getConnection(DB_URL,USER,PASS);
//STEP 4: Execute a query
stmt = conn.createStatement();
String sql;
//STEP 5: Extract data from result set
System.out.println("Enter if you want to \n a)Fetch and display whole table data \n b)Fetch alias quote column data using serial");
Scanner sc=new Scanner(System.in);
char optionab=sc.nextLine().charAt(0);
if(optionab=='a') {
	sql="SELECT * FROM avengers";
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next())
	{
		//Fetch by Column Names
		int id=rs.getInt("serial");
		String first=rs.getString("first_name");
		String last=rs.getString("last_name");
		String hero_name=rs.getString("alias");
		String quoted=rs.getString("quote");
		
		//Print Values
		System.out.print("ID "+id);
		System.out.print(", First Name: "+first);
		System.out.println(", Last Name: "+ last);
		System.out.println("Hero Name: "+ hero_name);
		System.out.println("Has Quated" +quoted);
	}
	rs.close();
	
}
else if(optionab=='b') {
	String x="SELECT alias,quote FROM avengers where serial=";
	System.out.println("Enter the serial number you want the Alias and Quote of: ");
	String y=sc.nextLine();
	sql=x+y;
	ResultSet rs=stmt.executeQuery(sql);
	//Extract Data from Result Set
	while(rs.next()) 
	{
		String aname=rs.getString(1);
		String quotex=rs.getString(2);
		
		//Print Values
		System.out.println(aname);
		System.out.println(quotex);
		
	}
	rs.close();

}
else
{
	System.out.println("Input Invalid");
}
//STEP 6: Clean-up environment
sc.close();
stmt.close();
conn.close();
}catch(SQLException se){
//Handle errors for JDBC
se.printStackTrace();
}catch(Exception e){
//Handle errors for Class.forName
e.printStackTrace();
}finally{
//finally block used to close resources
try{
if(stmt!=null)
stmt.close();
}catch(SQLException se2){
}// nothing we can do
try{
if(conn!=null)
conn.close();
}catch(SQLException se){
se.printStackTrace();
}
}
System.out.println("Goodbye!");
}
}
