package Invoicing;

import java.io.Serializable;
import java.util.ArrayList;





public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
//	public static void main(String[] args) {
	private Integer invoiceNo;
	private String invoiceDate;
	//data of customer in invoice
	private String CustomerName;
	private Integer CustomerNumber;
	//data of items in invoice with price
	
	private Integer noOfItems;
	
	private double totalAmount;
	private double paidAmount;
	private double balance;
	private double PaymentPrice;
	ArrayList<Items> itemsList = new ArrayList<Items>();
	
	public double getPaymentPrice() {
		return PaymentPrice;
	}
	public void setPaymentPrice(double paymentPrice) {
		PaymentPrice = paymentPrice;
	}

	
	public ArrayList<Items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(ArrayList<Items> itemsList) {
		this.itemsList = itemsList;
	}
	public Integer getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public Integer getCustomerNumber() {
		return CustomerNumber;
	}
	public void setCustomerNumber(Integer customerNumber) {
		CustomerNumber = customerNumber;
	}
	public Integer getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	}


