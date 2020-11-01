package model;

import dataStructure.AVL;

public class Controller {
	
	private int actualCod;
	private AVL<String, Person> names;
	private AVL<String, Person> lastNames;
	private AVL<String, Person> completeNames;
	private AVL<String, Person> cod;

	public Controller() {
		actualCod = 1;
	}
	
	public String generateCod() {
		return "A00" + actualCod++;
	}
	
	public void addPerson(String name, String lastName, String gender, double height, String nationality, String photo) {
		String cod = generateCod();
		String cal = generateDate();
		Person p = new Person(cod, name, lastName, gender, cal, height, nationality, photo);
		names.insert(name, p);
		lastNames.insert(lastName, p);
		completeNames.insert(name + " " + lastName, p);
		this.cod.insert(cod, p);
	}
	
	public String generateDate() {
		String cal = "";
		double aleatory = Math.random();
		int year;
		if (aleatory < 0.1862) {
			year = (int) Math.random()*(2020 - 2006) + 2006;
		} else if (aleatory < 0.1312 + 0.1862) {
			year = (int) Math.random()*(2006 - 1996) + 1996;
		} else if (aleatory < 0.3929 + 0.1312 + 0.1862) {
			year = (int) Math.random()*(1996 - 1966) + 1966;
		} else if (aleatory < 0.1294 + 0.3929 + 0.1312 + 0.1862) {
			year = (int) Math.random()*(1966 - 1956) + 1956;
		} else {
			year = (int) Math.random()*(1956 - 1941) + 1941;
		}
		return cal;
	}

	
	
}
