package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dataStructure.AVL;

public class Controller {
	
	public final static String COUNTRIES = "data/countries.csv";
	public final static String LASTNAMES = "data/lastNames.csv";
	public final static String NAMES = "data/names.csv";
	
	private int actualCod;
	private AVL<String, Person> names;
	private AVL<String, Person> lastNames;
	private AVL<String, Person> completeNames;
	private AVL<String, Person> cod;
	private String[] countries;
	private double[] percentage;
	private String[] aNames;
	private String[] aLastNames;

	public Controller(String[] c, double[] p, String[] an, String[] al) {
		actualCod = 1;
		countries = new String[51];
		percentage = new double[51];
		aNames = new String[6781];
		aLastNames = new String[162252];
	}
	
	public String generateCod() {
		return "A00" + actualCod++;
	}
	
	public void addPerson(String photo) {
		String cod = generateCod();
		Date date = generateDate();
		int gender = generateGender();
		double height = generateHeight();
		String nationality = generateNationality();
		String[] completeName = generateName();
		String name = completeName[0];
		String lastName = completeName[1];
		Person p = new Person(cod, name, lastName, gender, date, height, nationality, photo);
		names.insert(name, p);
		lastNames.insert(lastName, p);
		completeNames.insert(name + " " + lastName, p);
		this.cod.insert(cod, p);
	}
	
	public String[] generateName() {
		String[] name = new String[2];
		int na = (int) Math.random() * 6780;
		int la = (int) Math.random() * 163253;
		name[0] = aNames[na];
		name[1] = aLastNames[la];
		return name;
	}

	private double generateHeight() {
		return Math.random() * (2 - 1.5) + 1.5;
	}

	public Date generateDate() {
		double percentage = Math.random();
		int year;
		int month =(int) Math.random() * (12 - 1) + 1;
		int day  = (int) Math.random() * (30 - 1) + 1;
		if (percentage < 0.1862) {
			year = (int) Math.random() * (2020 - 2006) + 2006;
		} else if (percentage < 0.1312 + 0.1862) {
			year = (int) Math.random() * (2006 - 1996) + 1996;
		} else if (percentage < 0.3929 + 0.1312 + 0.1862) {
			year = (int) Math.random() * (1996 - 1966) + 1966;
		} else if (percentage < 0.1294 + 0.3929 + 0.1312 + 0.1862) {
			year = (int) Math.random() * (1966 - 1956) + 1956;
		} else {
			year = (int) Math.random() * (1956 - 1941) + 1941;
		}
		Date date = new Date(day, month, year);
		return date;
	}

	public int generateGender() {
		int gen;
		double percentage = Math.random();
		if (percentage < 0.5) {
			gen = Person.FEMALE;
		} else {
			gen = Person.MALE;
		}
		return gen;
	}
	
	private String generateNationality() {
		String country = countries[0];
		double aleatory = Math.random();
		boolean found = false;
		for (int i = 0; i < countries.length && !found; i++) {
			if (aleatory <= percentage[i]) {
				country = countries[i];
				found = true;
			} 
		}
		return country;
	}
	
	public void loadFromFilesCountries() throws IOException {
		FileReader br = new FileReader(new File(COUNTRIES));
		BufferedReader bw = new BufferedReader(br);
		String line = bw.readLine();
		int i = 0;
		while (line != null) {
			String[] data = line.split(",");
			countries[i]  = data[0];
			percentage[i] = Double.parseDouble(data[2]);
			i++;
		}
		br.close();
		bw.close();
	}
	
	public void loadFromFilesNames() throws IOException {
		FileReader br = new FileReader(new File(NAMES));
		BufferedReader bw = new BufferedReader(br);
		String line = bw.readLine();
		int i = 0;
		while (line != null) {
			String[] data = line.split(",");
			aNames[i]  = data[0];
			i++;
		}
		br.close();
		bw.close();
	}
	
	public void loadFromFilesLastNames() throws IOException {
		FileReader br = new FileReader(new File(LASTNAMES));
		BufferedReader bw = new BufferedReader(br);
		String line = bw.readLine();
		int i = 0;
		while (line != null) {
			String[] data = line.split(",");
			aLastNames[i]  = data[0];
			i++;
		}
		br.close();
		bw.close();
	}

	/**
	 * @return the actualCod
	 */
	public int getActualCod() {
		return actualCod;
	}

	/**
	 * @param actualCod the actualCod to set
	 */
	public void setActualCod(int actualCod) {
		this.actualCod = actualCod;
	}

	/**
	 * @return the names
	 */
	public AVL<String, Person> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(AVL<String, Person> names) {
		this.names = names;
	}

	/**
	 * @return the lastNames
	 */
	public AVL<String, Person> getLastNames() {
		return lastNames;
	}

	/**
	 * @param lastNames the lastNames to set
	 */
	public void setLastNames(AVL<String, Person> lastNames) {
		this.lastNames = lastNames;
	}

	/**
	 * @return the completeNames
	 */
	public AVL<String, Person> getCompleteNames() {
		return completeNames;
	}

	/**
	 * @param completeNames the completeNames to set
	 */
	public void setCompleteNames(AVL<String, Person> completeNames) {
		this.completeNames = completeNames;
	}

	/**
	 * @return the cod
	 */
	public AVL<String, Person> getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(AVL<String, Person> cod) {
		this.cod = cod;
	}

	/**
	 * @return the countries
	 */
	public String[] getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(String[] countries) {
		this.countries = countries;
	}

	/**
	 * @return the percentage
	 */
	public double[] getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double[] percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the aNames
	 */
	public String[] getaNames() {
		return aNames;
	}

	/**
	 * @param aNames the aNames to set
	 */
	public void setaNames(String[] aNames) {
		this.aNames = aNames;
	}

	/**
	 * @return the aLastNames
	 */
	public String[] getaLastNames() {
		return aLastNames;
	}

	/**
	 * @param aLastNames the aLastNames to set
	 */
	public void setaLastNames(String[] aLastNames) {
		this.aLastNames = aLastNames;
	}
	
	
	
}
