package Invoicing;

import java.io.Serializable;

//import MainTest.Invoice;

public class Items implements Serializable{

		private static final long serialVersionUID = 1L;
		private String itemName;
		private Integer itemId;
		private double itemprice;
		private Integer stock;
		private Integer quantity;
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public Integer getItemId() {
			return itemId;
		}
		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}
		public double getItemprice() {
			return itemprice;
		}
		public void setItemprice(double itemprice) {
			this.itemprice = itemprice;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	    }
	    
	

