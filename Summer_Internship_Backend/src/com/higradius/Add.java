package com.higradius;
import java.io.IOException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet{
    public static Connection conn;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
    public static PreparedStatement statement;
    static final String USER = "root";
	static final String PASS = "root";
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
      String add = "INSERT INTO invoice_details (name_customer,cust_number,invoice_id,total_open_amount,due_in_date,notes,doc_id) VALUES (?,?,?,?,?,?,?)";
      try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        statement = conn.prepareStatement(add);
        addPojo obj = new addPojo();
        obj.setName_customer(req.getParameter("name_customer"));
        System.out.println(req.getParameter("name_customer"));
        obj.setCust_number(req.getParameter("cust_number"));
        System.out.println(req.getParameter("cust_number"));
        obj.setInvoice_id(req.getParameter("invoice_id"));
        System.out.println(req.getParameter("invoice_id"));
        obj.setTotal_open_amount(req.getParameter("total_open_amount"));
        System.out.println(req.getParameter("total_open_amount"));
        obj.setDue_in_date(req.getParameter("due_in_date"));
        System.out.println(req.getParameter("due_in_date"));
        obj.setNotes(req.getParameter("notes"));
        System.out.println(req.getParameter("notes"));
        
                statement.setString(1, obj.getName_customer());
                statement.setString(2, obj.getCust_number());
            	statement.setString(3, obj.getInvoice_id());
                statement.setString(4, obj.getTotal_open_amount());
                statement.setString(5, obj.getDue_in_date());
                statement.setString(6, obj.getNotes());
                statement.setString(7, obj.getInvoice_id());
               
            System.out.println(statement);
            boolean rs = statement.execute();
            System.out.println(rs);
      
      }catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
