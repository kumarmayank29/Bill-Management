package com.higradius;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Edit extends HttpServlet{
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
  // Database credentials
  static final String USER = "root";
  static final String PASS = "root";
    public static Connection conn;
    public static PreparedStatement statement;
    public static String Edit = "UPDATE invoice_details SET total_open_amount = ?,notes=? WHERE invoice_id=?";

    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
      
      try {
        String index=request.getParameter("index");
        Class.forName(JDBC_DRIVER);
        System.out.println(request.getParameter("amount"));
        System.out.println(request.getParameter("notes"));
        System.out.println(request.getParameter("invoice"));
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        statement = conn.prepareStatement(Edit);
        statement.setDouble(1, Double.parseDouble(request.getParameter("amount")));
        statement.setString(2, request.getParameter("notes"));
        statement.setLong(3, (long)Double.parseDouble(request.getParameter("invoice")));
        System.out.println(statement);
        int rs = statement.executeUpdate();      
      
      }catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
