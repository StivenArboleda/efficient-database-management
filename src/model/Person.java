package model;

import java.util.Calendar;


public class Person {
	
	private String cod;
	private String name;
	private String lastName;
	private String gender;
	private String bornDate;
	private double height;
	private String nationality;
	private String photo;
	
	/**
	 * @param cod
	 * @param name
	 * @param lastName
	 * @param gender
	 * @param bornDate
	 * @param height
	 * @param nationality
	 * @param photo
	 */
	public Person(String cod, String name, String lastName, String gender, String bornDate, double height,
			String nationality, String photo) {
		super();
		this.cod = cod;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.bornDate = bornDate;
		this.height = height;
		this.nationality = nationality;
		this.photo = photo;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the bornDate
	 */
	public String getBornDate() {
		return bornDate;
	}

	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	
}
