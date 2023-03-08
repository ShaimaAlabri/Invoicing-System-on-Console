package Invoicing;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InvoicingSystemDataBase {
	public static void main(String[] args) {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("enter user");
			 String user = scanner.nextLine();
			 System.out.println(user);
			 System.out.println("enter pass");
			 String pass = scanner.nextLine();
			 System.out.println(pass);

			 if (user.equals(user) && pass.equals(pass)) {}else {
			 System.out.println("worng username and password ");
			 }
			 Connection con = null;
			 System.out.println("System is in prograss:");
			 try {
			 // create a new table
			 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			 DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection(url, "sa", "root");
			 Statement st = con.createStatement();
			 ////
			// setting menu
			 Shope shope=new Shope();
			 shope.setShopName("Market");
			 shope.setPhoneNumber(24555454);
			 shope.setFaxNo(111);
			 shope.setEmail("market@hotmail.com");
			 shope.setWebsite("www.market.com");
			 
			 String sql1= "Create table shop ("
					 + " shop_Name text not null,"
					 + " phone_Number Integer not null ,"
					 + " faxNo Integer not null,"
					 + " email text not null, "
					 + " website text not null "
					 + ");";
			 String sql = "INSERT INTO Shop (shop_Name, phone_Number,faxNo ,email,website)"+
	                    "VALUES ("+"'"+shope.getShopName()+"','"+shope.getPhoneNumber()+"','"+shope.getFaxNo()+"','"+shope.getEmail()+"','"+shope.getWebsite()+ "')";
			 st.execute(sql);
//			 ResultSet resultSet = st.executeQuery(sql1);
			 System.out.println("Done");
			 
			 }catch (Exception e) {
				 System.err.println(e);
			}
	
	}
}

