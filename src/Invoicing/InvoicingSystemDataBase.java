package Invoicing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class InvoicingSystemDataBase {
	//public static void main(String[] args) {
	
			 ////
			// setting menu
//			 Shope shope=new Shope();
//			 shope.setShopName("Market");
//			 shope.setPhoneNumber(24555454);
//			 shope.setFaxNo(111);
//			 shope.setEmail("market@hotmail.com");
//			 shope.setWebsite("www.market.com");
//			 
//			 String sql1= "Create table shop ("
//					 + " shop_Name text not null,"
//					 + " phone_Number Integer not null ,"
//					 + " faxNo Integer not null,"
//					 + " email text not null, "
//					 + " website text not null "
//					 + ");";
//			 String sql = "INSERT INTO Shop (shop_Name, phone_Number,faxNo ,email,website)"+
//	                    "VALUES ("+"'"+shope.getShopName()+"','"+shope.getPhoneNumber()+"','"+shope.getFaxNo()+"','"+shope.getEmail()+"','"+shope.getWebsite()+ "')";
//			 st.execute(sql);
//			 ResultSet resultSet = st.executeQuery(sql1);
//			 System.out.println("Done");
	private static void createTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=InvoicingSystem;encrypt=true;trustServerCertificate=true";

		 Connection con = null;
		 System.out.println("System is in prograss:");
		 try {
		 // create a new table
		 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		 DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(url, "sa", "root");
		 Statement st = con.createStatement();
		 
		 Scanner sc = new Scanner(System.in);
		    int select = sc.nextInt();
		    if (select==1) {
		    	
		    	 String sql1= "Create table shop ("
						 + " shop_Name text not null,"
						 + " phone_Number Integer not null ,"
						 + " faxNo Integer not null,"
						 + " email text not null, "
						 + " website text not null "
						 + ");";
		    	 System.out.println("databas craeted");
		st.execute(sql1);
		    	con.close();
		    }
			}catch (Exception e) {
				System.err.println(e);
		 }
	}
			 public static HashMap<String, Integer> menu = new HashMap<String, Integer>();

				public static ArrayList<Invoice> invoices = new ArrayList<Invoice>();
				public static ArrayList <Items> items=new ArrayList<Items>();
				public static Shope shope=new Shope();
				
			public static void main(String[] args) {
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
//			    case 4: // create table
//			    	System.out.println("1 create setting menu");
			    }
			}
			

			//options for settings menu
			private static void settingsMenu() {
			    Scanner sc = new Scanner(System.in);
			    int select = sc.nextInt();
			    Shope shope=new Shope();
			    
			    // Load Data
			    if(select == 1) {
			    	//load settings from file
			    	loadSettings();
			    	//load items from file
			    	loadItems();
			    	//load invoices from file
			    	loadInvoices();
			    	System.out.println("Data Loaded Seccssfully");
			    	
			    }else if(select == 2) {
			    	System.out.println("Enter Shop Name:");
					String shopName = sc.next();
					main.shope.setShopName(shopName);
					System.out.println("New Shop Name Saved");
					saveSettings();

			    	
			    }else if(select == 3) {
			    	System.out.println("Enter phone Number:");
					int TelNum = sc.nextInt();
					main.shope.setPhoneNumber(TelNum );
					
					System.out.println("Enter Fax:");
					int faxNo = sc.nextInt();
					main.shope.setFaxNo(faxNo);
					
					System.out.println("Enter Email  Address:");
					String Email = sc.next();
					main.shope.setEmail(Email);
					
					System.out.println("Enter website:");
					String Website = sc.next();
					main.shope.setWebsite(Website);
					
					 String sql = "INSERT INTO Shop (shop_Name, phone_Number,faxNo ,email,website)"+
			                    "VALUES ("+"'"+shope.getShopName()+"','"+shope.getPhoneNumber()+"','"+shope.getFaxNo()+"','"+shope.getEmail()+"','"+shope.getWebsite()+ "')";
					 createTable();
					 
					saveSettings();
					System.out.println("New Shop Data Saved");

						
			        }else if(select == 4) {
			        	main(null);
			        }
			        
			        // repete menu if get here
					printMenu(2);
					settingsMenu();
			          
				}

				
				//options for item menu
				

					//options for item menu
					private static void itemsMenu() {
				        Scanner sc = new Scanner(System.in);
				        int select = sc.nextInt();
				        
				     // add new item
				        if(select == 1) {
				        	
				        	//ask user to enter item data
				        	Items newitem = new Items();
				        	
				        	System.out.println("Enter item ID: ");
				        	int idOfItem = sc.nextInt();
							newitem.setItemId(idOfItem);
							
				        	System.out.println("Enter item Name: ");
							String nameOfItem = sc.next();
							newitem.setItemName(nameOfItem);
							
							System.out.println("Enter item Price: ");
							double itemPrice = sc.nextDouble();
							newitem.setItemprice(itemPrice);
							
							System.out.println("Enter the Stock: ");
							int stockOfItems = sc.nextInt();
							newitem.setStock(stockOfItems);
							
							//add new item to the global items array
							main.items.add(newitem);
							saveItems();
							System.out.println("New Item Saved");
							
							
							//delete item
				        }else if(select == 2) {
				        	
				        	boolean found = false;
				        
				        	System.out.println("Enter item ID: ");
				        	int idOfItem = sc.nextInt();
				        	
				        	for(int i =0; i < main.items.size(); i++) {
				        		if(main.items.get(i).getItemId() == idOfItem) {
				        			main.items.remove(i);
				        			found = true;
				        		}
				        	}
				        	
				        	if(found) {
					        	saveItems();
								System.out.println("Item Deleted");
				        	}else {
				        		System.out.println("Item not Found");
				        	}

				        	//change item price
				        }else if(select == 3) {
				        	
				        	System.out.println("Enter item ID: ");
				        	int idOfItem = sc.nextInt();
				        	
				        	for(int i =0; i < main.items.size(); i++) {
				        		if(main.items.get(i).getItemId() == idOfItem) {
				        			
				        			System.out.println("Item Found Enter New Price: ");
				        			double priceOfItem = sc.nextDouble();
				        			
				        			main.items.get(i).setItemprice(priceOfItem);
				        			System.out.println("New Item Price Saved");
				        			saveItems();
				        		}
				        	}
				        	
				        	//print all items
				        }else if(select == 4) {
				        	System.out.println("-------------------");
				        	
				        	for(Items item : main.items) {
				        		System.out.format("ID:%d Name%s Price:%f Stock:%d \r\n",item.getItemId(), item.getItemName(), item.getItemprice(), item.getStock());
				        	}

				        	System.out.println("-------------------");
				        }else if(select == 5) {
				        	main(null);
				        }
				        
						printMenu(3);
						itemsMenu();
					}
					
					//save settings to file
					private static void saveSettings() {
						FileOutputStream fileOutputStream;

						try {
							
							fileOutputStream = new FileOutputStream("settings.txt");
						    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
						    
						    objectOutputStream.writeObject(main.shope);
						    objectOutputStream.flush();
						    objectOutputStream.close();
					    
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					    
					}
					
					
					//load settings from file
					private static void loadSettings() {

						try {
							FileInputStream fileInputStream = new FileInputStream("settings.txt");
							
						    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					    
						    //cast object to type setting
						    main.shope = (Shope) objectInputStream.readObject();

						    objectInputStream.close();
						 
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					//save items to file
					private static void saveItems() {
						FileOutputStream fileOutputStream;

						try {
							
							fileOutputStream = new FileOutputStream("items.txt");
						    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
						    
						    objectOutputStream.writeObject(main.items);
						    objectOutputStream.flush();
						    objectOutputStream.close();
					    
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					    
					}
					
					//load items from file
					private static void loadItems() {

						try {
							FileInputStream fileInputStream = new FileInputStream("items.txt");
							
						    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					    
						    main.items = (ArrayList<Items>) objectInputStream.readObject();

						    objectInputStream.close();
						 
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					//save invoices to file
					private static void saveInvoices() {
						FileOutputStream fileOutputStream;

						try {
							
							fileOutputStream = new FileOutputStream("invoices.txt");
						    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
						    
						    objectOutputStream.writeObject(main.invoices );
						    objectOutputStream.flush();
						    objectOutputStream.close();
					    
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					    
					}
					
					//load invoices from file
					private static void loadInvoices() {

						try {
							FileInputStream fileInputStream = new FileInputStream("invoices.txt");
							
						    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					    
						    main.invoices = (ArrayList<Invoice>) objectInputStream.readObject();

						    objectInputStream.close();
						 
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					// add new invoice
					private static void addNewInvoice() {
						
				        Scanner sc = new Scanner(System.in);
				    	Invoice newInvoice = new Invoice();
				    	
				    	//get current date in string format
				    	Date date = new Date();  
				    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
				    	newInvoice.setInvoiceDate( formatter.format(date));
				    	
				    	//if no invoices size = 0 then this it the first invoice so id should be 1
				    	int newInvoiceId = 1;

				    	//if there is an invoice get last one number and add 1 to it
				    	if(main.invoices.size() != 0) {
				    		newInvoiceId = (main.invoices.get(main.invoices.size() - 1).getInvoiceNo()) + 1;
				    	}
				    	newInvoice.setInvoiceNo(newInvoiceId);
				    	
				    	
				    	System.out.println("Enter Customer Name: ");
				    	String customerName = sc.next();
				    	newInvoice.setCustomerName(customerName);
				    	
				    	System.out.println("Enter Customer Phone: ");
				    	int customerphone = sc.nextInt();
				    	newInvoice.setCustomerNumber(customerphone);
				    	

				    	//start loop to select items
				    	boolean checkout = false;
				    	
				    	ArrayList<Items> newInvoiceItems = newInvoice.getItemsList();
				    	
				    	while (!checkout) {
				    		System.out.println("Select Item: ");
				    		
				    		//print all items list
				    		for(Items item : main.items) {
				    			System.out.format("ID:%d Name:%s\r\n",item.getItemId(), item.getItemName());
				    		}
				    		
				    		int itemId = sc.nextInt();
				    		
				    		System.out.println("Enter Quantity: ");
				    		int itemQuantity = sc.nextInt();
				    		
				    		//search for the item and add it to invoice items + set quantity
				    		for(int i=0 ; i < main.items.size(); i++) {
				    			if(main.items.get(i).getItemId() == itemId) {
				    				
				    				Items newItem = main.items.get(i);
				    				newItem.setQuantity(itemQuantity);
				    				newInvoiceItems.add(main.items.get(i));
				    				
				    			}
				    		}
				        	
				    		System.out.println("Do you weant to Add Another Item?");
				    		int next = sc.nextInt();
				    		
				    		if(next == 0) {
				    			checkout = true;
				    		}
				    		
				    	}
				    	
				    	//calculate total price and items 
				    	double totalAmount = 0;
				    	
				    	for(int i=0 ; i < newInvoiceItems.size(); i++) {
				    		//price = item price * quantity
				    		totalAmount += ( newInvoiceItems.get(i).getItemprice() * newInvoiceItems.get(i).getQuantity());
						}
				    	
				    	// save items to the invoice
						newInvoice.setItemsList(newInvoiceItems);
						

						//save total price and quantity to invoice
						newInvoice.setNoOfItems(newInvoiceItems.size());
				    	newInvoice.setTotalAmount(totalAmount);
				    	
				    	System.out.format("Total Amount:%f\r\n",newInvoice.getTotalAmount());
				    	
						System.out.println("How much did the customer pay?");
						double paid = sc.nextDouble();
						
						newInvoice.setPaidAmount(paid);
						
						double remaining = paid - newInvoice.getTotalAmount();
						newInvoice.setPaymentPrice(remaining);
						
						System.out.format("you should return:%f to the customer\r\n",remaining);

						
						//add new invoice to the list
						main.invoices.add(newInvoice);
						//save to file
						saveInvoices();
						
						System.out.print("Invoice Saved Successfully");
						//return to main menu
						main(null);
					}


					//Report: Statistics
					private static void statistics() {
						System.out.println("Number of Items: " + main.items.size());
						
						System.out.println("Number of Invoices: " + + main.invoices.size());
						
						
						
						double total = 0;
						for(int i = 0; i < main.invoices.size(); i++ ) {
							total += main.invoices.get(i).getTotalAmount();
						
						}
						
						System.out.println("Total Sales:" + total);
						
				
						main(null);
					}

					//All Invoices
					private static void printAllInvoices() {
						for(Invoice invoice : main.invoices ) {
							
							System.out.format("#%s | Date:%s | Customer Name:%s | Customer Number:%s  | Price:%s \r\n", invoice.getInvoiceNo(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getCustomerNumber(), invoice.getTotalAmount());
							
							for(Items item : invoice.getItemsList() ) {
								System.out.format("---- #%d | Name:%s | Price:%f | Quantity:%d | Total:%f \r\n", item.getItemId(), item.getItemName(), item.getItemprice(), item.getQuantity(), (item.getItemprice()*item.getQuantity()) );
							}
						}
						
					
						
						main(null);
					}

					//search Invoice
					private static void searchInvoice() {
						Scanner sc = new Scanner(System.in);
						
						System.out.println("Enter Invoice Number:");
						int invoiceNumber = sc.nextInt();
						
						boolean found = false;
						for(Invoice invoice : main.invoices ) {
							
							if(invoice.getInvoiceNo() == invoiceNumber) {	
								found = true;
								System.out.format("#%s | Date:%s | Customer Name:%s | Customer Number:%s  | Price:%s \r\n", invoice.getInvoiceNo(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getCustomerNumber(), invoice.getTotalAmount());
								
								for(Items item : invoice.getItemsList() ) {
									System.out.format("---- #%d | Name:%s | Price:%f | Quantity:%d | Total:%f \r\n", item.getItemId(), item.getItemName(), item.getItemprice(), item.getQuantity(), (item.getItemprice()*item.getQuantity()) );
								}
								break;
							}
						}
						
						if(!found) {
							System.out.println("Invoice Not Found!");
						}
						main(null);
					}

					//Program Statistics
					private static void programStatistics() {
						System.out.println("main menu:"+menu.get("case 0"));
						System.out.println("Shop Settings menu:"+menu.get("case 1"));
						System.out.println("Manage items menu:"+menu.get("case 2"));
						System.out.println("Create New Invoice menu:"+menu.get("case 3"));
						System.out.println("Statistics menu:"+menu.get("case 4"));
						System.out.println("All Invoices menu:"+menu.get("case 5"));
						System.out.println("Search Invoice menu:"+menu.get("case 6"));
						System.out.println("Program Statistics menu:"+menu.get("case 7"));
						System.out.println("Exit menu:"+menu.get("case 8"));
					}
					private static void option() {
						if(! menu.containsKey("case 0")) {
							menu.put("case 0",0 );
							menu.put("case 1",0 );
							menu.put("case 2",0 );
							menu.put("case 3",0 );
							menu.put("case 4",0 );
							menu.put("case 5",0 );
							menu.put("case 6",0 );
							menu.put("case 7",0 );
							menu.put("case 8",0 );
						}
					
					}
					
}