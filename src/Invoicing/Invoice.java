package Invoicing;

public class Invoice {

//	public static void main(String[] args) {
		private String coustomerName;
		private	Integer phoneNumber;
		private	Integer invoiceDate;
		private String shopName;
		private double paidAmount;
		private double totalAmount;
		private	Integer invoiceNoumber;
		private Integer noOfItems;
		
		public Integer getInvoiceNoumber() {
			return invoiceNoumber;
		}

		public void setInvoiceNoumber(Integer invoiceNoumber) {
			this.invoiceNoumber = invoiceNoumber;
		}

		public Integer getNoOfItems() {
			return noOfItems;
		}

		public void setNoOfItems(Integer noOfItems) {
			this.noOfItems = noOfItems;
		}


		private	void paidAmount() {

		
		}
		
		private	void totalAmount() {
			
		}
		private	void loudData() {
			
		}

		private	void invoiceHeader(){
			
		}
		public double getPaidAmount() {
			return paidAmount;
		}

		public void setPaidAmount(double paidAmount) {
			this.paidAmount = paidAmount;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		private	void goBack() {
			
		}

		public String getCoustomerName() {
			return coustomerName;
		}

		public void setCoustomerName(String coustomerName) {
			this.coustomerName = coustomerName;
		}

		public Integer getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Integer phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Integer getInvoiceDate() {
			return invoiceDate;
		}

		
		public void setInvoiceDate(Integer invoiceDate) {
			this.invoiceDate = invoiceDate;
		}

		public String getShopName() {
			return shopName;
		}

		public void setShopName(String shopName) {
			this.shopName = shopName;
		}
	}


