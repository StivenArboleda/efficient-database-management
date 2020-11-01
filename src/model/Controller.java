package model;

import dataStructure.AVL;

public class Controller {
	
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
		countries = c;
		percentage = p;
		aNames = an;
		aLastNames = al;
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
		String country = "United States";
		double aleatory = Math.random();
		for (int i = 0; i < countries.length; i++) {
			if (aleatory <= percentage[i]) {
				country = countries[i];
			}
		}
		return country;
	}
	
	
	
}
