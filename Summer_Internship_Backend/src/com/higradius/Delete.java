package com.higradius;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet{
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
  // Database credentials
  static final String USER = "root";
  static final String PASS = "root";
    public static Connection conn;
    public static PreparedStatement statement;
    public static String delete = "DELETE FROM invoice_details WHERE doc_id in(?)";
    

    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
      
      try {
        //String index=request.getParameter("index");
        Class.forName(JDBC_DRIVER);
        System.out.println(request.getParameter("invoice"));
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        statement = conn.prepareStatement(delete);
        statement.setLong(1, (long)Double.parseDouble(request.getParameter("invoice")));
        System.out.println(statement);
        int rs = statement.executeUpdate();      
      
      }catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
