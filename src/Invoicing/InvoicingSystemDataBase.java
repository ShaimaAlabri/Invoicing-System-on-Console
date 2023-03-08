package Invoicing;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InvoicingSystemDataBase {
	public static void main(String[] args) {
	String url = "jdbc:sqlserver://localhost:1433;" +
			 "databaseName= InvoicingSystem ;" +
			 "encrypt=true;" + "trustServerCertificate=true";
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("enter user");
			 String user = scanner.nextLine();
			 System.out.println("enter pass");
			 String pass = scanner.nextLine();
			 if (user.equals(user) && pass.equals(pass)) {}else {
			 System.out.println("worng username and password ");
			 }
			 Connection con = null;
			 System.out.println("System is in prograss:");
			 try {
			 // create a new table
			 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			 DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection(url, user, pass);
			 Statement st = con.createStatement();
			 ////
			// setting menu
			 Shope shope=new Shope();
			 shope.setShopName("Market");
			 shope.setPhoneNumber(24555454);
			 shope.setFaxNo(111);
			 shope.setEmail("market@hotmail.com");
			 shope.setWebsite("www.market.com");
			 
			 String sql1= "Create table shope (r\n"
					 + " shop Name text not null,r\n"
					 + " phone Number Integer not null ,r\n"
					 + " faxNo Integer not null,r\n"
					 + " email String not null, r\n"
					 + "website String not null, r\\n"
					 + ");\r\n";
			 String sql = "INSERT INTO Hotels (shop Name, phone Number,faxNo ,email,website)"+
	                    "VALUES ("+"'"+shope.getShopName()+"','"+shope.getPhoneNumber()+"','"+shope.getFaxNo()+"','"+shope.getEmail()+"','"+shope.getWebsite()+ ")";
			 ResultSet resultSet = st.executeQuery(sql1);
					 
					 
				
			 
			 
			 
			 }catch (Exception e) {
				 System.err.println(e);
			}
	
	}
}

