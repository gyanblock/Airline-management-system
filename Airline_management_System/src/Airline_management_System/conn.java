package Airline_management_System;

import java.sql.Connection;



import java.sql.DriverManager;


import java.sql.Statement;

public class conn {
	Connection c;
	Statement s;

	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql:///airline_management_system","root","FpS21Gk])@;]");
			s=c.createStatement();
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
}
	
	
