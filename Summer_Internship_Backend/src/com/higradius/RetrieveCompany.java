package com.higradius;
import java.sql.*;
import java.util.*;

public class RetrieveCompany {
	
	public List<ProjectPojo> fetchmilestone_pojoRecords()
	{
		List<ProjectPojo> Pojo1List=new ArrayList<>();
		try(Connection con = DatabaseConnection.initializeDatabase()){
			
			PreparedStatement statement = con.prepareStatement("SELECT * FROM invoice_details LIMIT 500");
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				ProjectPojo Pojo1Record=new ProjectPojo();
				Pojo1Record.setBusiness_code(result.getString("business_code"));
				Pojo1Record.setCust_number(result.getString("cust_number"));
				Pojo1Record.setName_customer(result.getString("name_customer"));
				Pojo1Record.setClear_date(result.getDate("clear_date"));
				Pojo1Record.setBuisness_year(result.getInt("business_year"));
				Pojo1Record.setPosting_date(result.getDate("posting_date"));
				Pojo1Record.setDoc_id(result.getLong("doc_id"));
				Pojo1Record.setDocument_create_date(result.getDate("document_create_date"));
				Pojo1Record.setDue_in_date(result.getDate("due_in_date"));
				Pojo1Record.setInvoice_currency(result.getString("invoice_currency"));
				Pojo1Record.setDocument_type(result.getString("document_type"));
				Pojo1Record.setPosting_id(result.getInt("posting_id"));
				Pojo1Record.setArea_business(result.getString("area_business"));
				Pojo1Record.setTotal_open_amount(result.getFloat("total_open_amount"));
				Pojo1Record.setBaseline_create_date(result.getDate("baseline_create_date"));
				Pojo1Record.setCust_payment_terms(result.getString("cust_payment_terms"));
				Pojo1Record.setInvoice_id(result.getString("invoice_id"));
				Pojo1Record.setIsOpen(result.getInt("isOpen"));
				Pojo1List.add(Pojo1Record);
			}
			return Pojo1List;
		}catch (Exception e) { 
			e.printStackTrace(); 
			return Pojo1List;
		}
	}
}
