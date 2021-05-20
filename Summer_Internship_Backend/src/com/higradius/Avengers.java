package com.higradius;
public class Avengers {
	private Integer id;
	private String fname;
	private String lname;
	private String aname;
	private String quote;

	public Integer getserial() {
		return this.id;
	}

	public void setserial(int id) {
		this.id = id;
	}

	public String getfirst_name() {
		return this.fname;
	}

	public void setfirst_name(String fname) {
		this.fname = fname;
	}

	public String getlast_name() {
		return this.lname;
	}

	public void setlast_name(String lname) {
		this.lname = lname;
	}
	
	public String getalias() {
		return this.aname;
	}

	public void setalias(String aname) {
		this.aname = aname;
	}
	
	public String getquote() {
		return this.quote;
	}

	public void setquote(String quote) {
		this.quote = quote;
	}

}