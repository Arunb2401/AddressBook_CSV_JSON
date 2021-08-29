package com.address.book;

public class ContactInfo {
	public final String firstName;
	public final String lastName;
	public final String address;
	public final String city;
	public final String state;
	public final Integer zip;
	public final String phoneNumber;
	public final String email;

	@Override
	public String toString() {
		return "ContactPerson{" + "firstName=" + firstName + '\'' + ", lastName='" + lastName + ", address='" + address
				+ '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip=" + zip + ", phoneNumber='"
				+ phoneNumber + '\'' + ", email='" + email + '\'' + '}';
	}

	public ContactInfo(String firstName, String lastName, String address, String city, String state, Integer zip,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}