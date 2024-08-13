package com.ofss.main.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="customer_master")
public class CustomerDetails {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="customer_id")
	private int customerId;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	
	public CustomerDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + "]";
	}
	public CustomerDetails(int customerId, String first_name, String last_name, String address1, String address2,
			String address3, String city, String state, String zip, String phone, String email) {
		super();
		this.customerId = customerId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
