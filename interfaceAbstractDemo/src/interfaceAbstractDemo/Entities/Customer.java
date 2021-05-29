package interfaceAbstractDemo.Entities;

import interfaceAbstractDemo.Abstract.Entity;

public class Customer implements Entity{
	private int id;
	private String firstName;
	private String lastName;
	private int yearOfBirth;
	private String nationalityId;
	
	public Customer(int id, String nationalityId, String firstName, String lastName, int dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDateOfBirth() {
		return yearOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		this.yearOfBirth = dateOfBirth;
	}
	public String getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}
}