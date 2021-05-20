package com.higradius;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;



public class DataToTable {
  public static Connection conn;
  public static PreparedStatement statement;
//  public static String query="insert into invoice_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  public static String query="insert into Invoice_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String line;
    try {
      int count=0;
     
    //Registering the Driver
    		//Class.forName("com.mysql.jdbc.Driver");
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    		Class.forName("com.mysql.jdbc.Driver");
    		
      
	
    //Getting the connection
    		String mysqlUrl = "jdbc:mysql://localhost/h2h_internship";
    		
    		Connection conn = DriverManager.getConnection(mysqlUrl, "root", "root");
    		
    		
      BufferedReader br = new BufferedReader(new FileReader("1806039_Copy.csv"));  
      while((line = br.readLine()) != null) {
              String[] tempArr = line.split(",");
              ProjectPojo pojo=new ProjectPojo();
              statement=conn.prepareStatement(query);
              if(count!=0) {
              pojo.setBusiness_code(tempArr[0]);
              pojo.setCust_number(tempArr[1]);
              pojo.setName_customer(tempArr[2]);
              java.sql.Date tempArr_3;
              if(tempArr[3].isEmpty()) {
                tempArr_3=null;
              }
              else {
                try {
                	tempArr_3=new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(tempArr[3] + ":00").getTime());
                } catch(Exception e) {
                	System.out.println(line);
                	throw e;
                }
              }
              pojo.setClear_date(tempArr_3);
              pojo.setBuisness_year((int)Float.parseFloat(tempArr[4]));
              pojo.setDoc_id((long)Double.parseDouble(tempArr[5]));
              java.sql.Date tempArr_6=new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(tempArr[6]).getTime());
              pojo.setPosting_date(tempArr_6);
              java.sql.Date tempArr_7=new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse(tempArr[7]).getTime());
              pojo.setDocument_create_date(tempArr_7);
              java.sql.Date tempArr_8=new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse(tempArr[8]).getTime());
             pojo.setDocument_create_date_1(tempArr_8);
              java.sql.Date tempArr_9=new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse(tempArr[9]).getTime());
              pojo.setDue_in_date(tempArr_9);
              pojo.setInvoice_currency(tempArr[10]);
              pojo.setDocument_type(tempArr[11]);
              pojo.setPosting_id((int)Float.parseFloat(tempArr[12]));
              if(tempArr[13].isEmpty()) {
                tempArr[13]=null;
              }
              pojo.setArea_business(tempArr[13]);
              pojo.setTotal_open_amount(Float.parseFloat(tempArr[14]));
              java.sql.Date tempArr_15=new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse(tempArr[15]).getTime());
              pojo.setBaseline_create_date(tempArr_15);
              pojo.setCust_payment_terms(tempArr[16]);
              if(tempArr[17].isEmpty()) {
                tempArr[17]=null;
              }
              pojo.setInvoice_id(tempArr[17]);
              pojo.setIsOpen(Integer.parseInt(tempArr[18]));
              statement.setString(1,pojo.getBusiness_code());
              statement.setString(2,pojo.getCust_number());
              statement.setString(3, pojo.getName_customer());
              statement.setDate(4,pojo.getClear_date());
              statement.setInt(5,pojo.getBuisness_year());
              statement.setLong(6, pojo.getDoc_id());
              statement.setDate(7, pojo.getPosting_date());
              //statement.setDate(8, pojo.getDocument_create_date());
              statement.setDate(8, pojo.getDocument_create_date_1());
              statement.setDate(9,pojo.getDue_in_date());
              statement.setString(10, pojo.getInvoice_currency());
              statement.setString(11, pojo.getDocument_type());
              statement.setInt(12, pojo.getPosting_id());
              statement.setString(13, pojo.getArea_business());
              statement.setFloat(14, pojo.getTotal_open_amount());

              statement.setDate(15,pojo.getBaseline_create_date());
              statement.setString(16, pojo.getCust_payment_terms());
              statement.setString(17, pojo.getInvoice_id());
              statement.setInt(18, pojo.getIsOpen());
              statement.addBatch();
              System.out.println(statement);
        statement.executeBatch();
              }
              
              count++;
             
           }
      
      statement.close();
          br.close();    
          conn.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
   
  }
}
