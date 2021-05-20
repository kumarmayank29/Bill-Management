package com.higradius;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.google.gson.Gson;


@WebServlet(name = "/RetrieveCompanies", urlPatterns = {"/RetrieveCompanies"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RetrieveCompany service=new RetrieveCompany();
    /**
     * @see HttpServlet#HttpServlet()
     */
    String jdbcURL = "jdbc:mysql://localhost/h2h_internship";
	String username = "root";
	String password = "root";

	
	String csvFilePath = "C:\\Users\\KIIT\\Desktop\\HRC datatset\\1806039 _Copy";
    public Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<ProjectPojo> data=new ArrayList<>();
		data=service.fetchmilestone_pojoRecords();
		
		Gson gson=new Gson();
		String myJSON=gson.toJson(data);
		
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		writer.write(myJSON);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



