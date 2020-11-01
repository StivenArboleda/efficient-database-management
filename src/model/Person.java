package model;


public class Person {
	
	public final static int FEMALE = 0;
	public final static int MALE = 1;
	
	private String cod;
	private String name;
	private String lastName;
	private int gender;
	private Date bornDate;
	private double height;
	private Nationality nationality;
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
	public Person(String cod, String name, String lastName, int gender, Date bornDate, double height,
			Nationality nationality, String photo) {
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
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the bornDate
	 */
	public Date getBornDate() {
		return bornDate;
	}

	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(Date bornDate) {
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
	public Nationality getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	public String getCountry() {
		return nationality.getCountry();
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
