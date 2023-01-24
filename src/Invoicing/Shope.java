package Invoicing;

import java.io.Serializable;

public class Shope implements Serializable {
	private static final long serialVersionUID = 1L;
	private String shopName;
	private Integer phoneNumber;
	private Integer faxNo;
	private String email;
	private String website;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(Integer faxNo) {
		this.faxNo = faxNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	

}
