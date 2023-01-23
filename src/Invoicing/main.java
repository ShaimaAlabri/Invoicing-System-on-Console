package Invoicing;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Items itm = new Items();
		Invoice invo= new Invoice();
//		int menu=3;
	
//		switch (menu) {
//		case 1:
//			
//			System.out.println("Invoice");
//			break;
//		case 2:
//			System.out.println("Items Ditailes");
//			break;
//			
//		case 3:
//			
//			
//		}
		boolean addItems = true;
		while(addItems) {
			Scanner sc = new Scanner(System.in);
			Integer total = 0;
			 System.out.println(" Invoice Number: ");
			 int invoiceNo = sc.nextInt();
			 invo.setInvoiceNoumber(invoiceNo);
			 System.out.println(" Invoice Date: ");
			 String invoiceDate = sc.next();
			 
			 System.out.println("Customer Name: ");
			 String CustomerName = sc.next();
			 invo.setCoustomerName(CustomerName);
			 System.out.println(" Customer Number: ");
			 int CustomerNumber = sc.nextInt();
			 invo.setPhoneNumber(CustomerNumber );;
			 System.out.println(" Items Number: ");
			 int noOfItems = sc.nextInt();
			 invo.setNoOfItems(noOfItems);
			
			 for (int i = 0; i < noOfItems; i++) {
		  
		  System.out.println("Enter Item Name:");
		  String name=sc.next();
		itm.setItemsName(name);
		
		  System.out.println("Enter Item ID:");
		  
		  Integer id=sc.nextInt();
		  itm.setId(id);
		  System.out.println("Item price:");
		    double price=sc.nextDouble();
		  itm.setUnitPrice(price);
		  System.out.println("Enter the Quantity of the items: ");
		  int QuantityOfItems = sc.nextInt();
		  System.out.println();
		  System.out.println("Do you want to Enter Other items? (yes/no): ");
		  String answer = sc.next();
		  invo.equals(invo);
		  if (answer.equals("yes")) {
		  System.out.println("Next item:");
		  addItems = true;
		  } else if (answer.equals("no")) {
			  addItems= false;
		  System.out.println("Total price: ");
		  total =  (int) ( price * QuantityOfItems);
		  System.out.println(total);
		  
	
			 
//		  for(int j =i;j<i;j++) {
			  System.out.println(" paid Amount:");
			  double paidAmount =sc.nextDouble();
			Double  totalPaid= total - paidAmount;
			if(totalPaid<0) {
				System.out.println("the shope will return:"+totalPaid);
				
			}else if(totalPaid>0){
				System.out.println("the coustoer must to add"+totalPaid);
			}
		  }
			break;
		  }
		  }
		}
		
		
		}
			  
	

		  



