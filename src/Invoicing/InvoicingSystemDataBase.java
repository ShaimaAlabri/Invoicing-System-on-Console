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
//			 System.out.println("Done");
			 
				option();
				printMenu(1);
				menu.put("case 0", menu.get("case 0")+1);
			    System.out.println("Enter Your option:");
			    Scanner sc = new Scanner(System.in);
			    int select = sc.nextInt();
			    
			    switch (select) {
			        case 1:
			        	//Shop Settings print
			        	menu.put("case 1", menu.get("case 1")+1);
			        	printMenu(2);
			        	settingsMenu();
			        	break;
			        case 2:
			        	//Shop Items
			        	menu.put("case 2", menu.get("case 2")+1);
			        	printMenu(3);
			        	itemsMenu();
			        	break;
			        case 3:
			        	// Create New Invoice
			        	menu.put("case 3", menu.get("case 3")+1);
			        	addNewInvoice();
			        case 4:
			        	//Report: Statistics
			        	menu.put("case 4", menu.get("case 4")+1);
			        	statistics(); 
			        case 5:
			        	//All Invoices
			        	menu.put("case 5", menu.get("case 5")+1);
			        	printAllInvoices(); 
			        case 6:
			        	//search Invoice
			        	menu.put("case 6", menu.get("case 6")+1);
			        	searchInvoice(); //
			        case 7:
			        	menu.put("case 7", menu.get("case 7")+1);
			        	//Program Statistics
			        	programStatistics(); 
			        case 8:
			        	//exit
			        	menu.put("case 8", menu.get("case 8")+1);
			        	System.out.println("Do you want to exit?!(yes/no))");
			        	if(sc.next().equals("yes")) {
			        	 System.exit(0);
			        	}else {
			        		main(null);
			        	}
			        	 break;
			    }		
			}

			//the program will call this function if want to print menus (main, settings and items)
			private static void printMenu(int menuNum) {
			    switch (menuNum) {
			    case 1: // main menu
					System.out.println(" Welcome to Invoice Store ");
					System.out.println(" ===================================== ");
					System.out.println("1 Shop Settings");
			        System.out.println("2 Manage items");
			        System.out.println("3 Create New Invoice");
			        System.out.println("4 Statistics");
			        System.out.println("5 All Invoices");
			        System.out.println("6 Search Invoice");
			        System.out.println("7 Program Statistics");
			        System.out.println("8 Exit");
			        break;
			    case 2: // setting menu
					System.out.println("1 Load Data (Items and invoices)");
			        System.out.println("2 Set Shop Name");
			        System.out.println("3 Set Invoice Header (Tel/Fax/Email/Website)");
			        System.out.println("4 Go Back");
			        break;
			    case 3: // items menu
					System.out.println("1 Add Items");
			        System.out.println("2 Delete Items");
			        System.out.println("3 Change Item Price");
			        System.out.println("4 Report All Items");
			        System.out.println("5 Go Back");
			        break;
			    }
			}
			 
			 
			 
			 
			 
			 
			 }catch (Exception e) {
				 System.err.println(e);
			}
	
	}
}

