package com.simplon.BriefSpring.form;

public class CustomerForm {
	private String name;
	private String siret; 
	private String address; 
	private String postalCode; 
	private String city;
	
	@Override
	public String toString() {
		return (name +" "+ siret +" "+ address+ " "+ postalCode+ " "+ city );
	}

	public CustomerForm(String name, String siret, String address, String postalCode, String city) {
		super();
		this.name = name;
		this.siret = siret;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public CustomerForm() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
