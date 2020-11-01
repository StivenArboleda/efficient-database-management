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
	
	public void addPerson(String name, String lastName, String photo) {
		String cod = generateCod();
		Date date = generateDate();
		int gender = generateGender();
		double height = generateHeight();
		Nationality nationality = generateNationality();
		Person p = new Person(cod, name, lastName, gender, date, height, nationality, photo);
		names.insert(name, p);
		lastNames.insert(lastName, p);
		completeNames.insert(name + " " + lastName, p);
		this.cod.insert(cod, p);
	}

	private double generateHeight() {
		return Math.random() * (2 - 1.5) + 1.5;
	}

	public Date generateDate() {
		double percentage = Math.random();
		int year;
		int month = (int) Math.random() * (12 - 1) + 1;
		int day = (int) Math.random() * (30 - 1) + 1;
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
	
	private Nationality generateNationality() {
		Nationality c = Nationality.MON;
		double a = Math.random();
		if (a < 0.3264469) {
			c = Nationality.USA;
		} else if (a < 0.5361253) {
			c = Nationality.BR;
		} else if (a < 0.6633834) {
			c = Nationality.MX;
		} else if (a < 0.7136067) {
			c = Nationality.COL;
		} else if (a < 0.7582055) {
			c = Nationality.ARG;
		} else if (a < 0.7954466) {
			c = Nationality.CAN;
		} else if (a < 0.8280087) {
			c = Nationality.PER;
		} else if (a < 0.8560104) {
			c = Nationality.VEN;
		} else if (a < 0.8748722) {
			c = Nationality.CHL;
		} else if (a < 0.8922996) {
			c = Nationality.ECU;
		} else if (a < 0.9038270) {
			c = Nationality.BOL;
		} else if (a < 0.9150845) {
			c = Nationality.HAI;
		} else if (a < 0.9262426) {
			c = Nationality.CUB;
		} else if (a < 0.9369488) {
			c = Nationality.DRP;
		} else if (a < 0.9467334) {
			c = Nationality.HON;
		} else if (a < 0.9555764) {
			c = Nationality.PNG;
		} else if (a < 0.9626184) {
			c = Nationality.PAR;
		} else if (a < 0.9691584) {
			c = Nationality.NIC;
		} else if (a < 0.9755544) {
			c = Nationality.SAL;
		} else if (a < 0.9805812) {
			c = Nationality.CRC;
		} else if (a < 0.9848436) {
			c = Nationality.PAN;
		} else if (a < 0.9882681) {
			c = Nationality.URU;
		} else if (a < 0.9911878) {
			c = Nationality.JAM;
		} else if (a < 0.9939926) {
			c = Nationality.PRC;
		} else if (a < 0.9953722) {
			c = Nationality.TAT;
		} else if (a < 0.9961478) {
			c = Nationality.GUY;
		} else if (a < 0.9967266) {
			c = Nationality.SUR;
		} else if (a < 0.9971209) {
			c = Nationality.GUA;
		} else if (a < 0.9975138) {
			c = Nationality.BEL;
		} else if (a < 0.9979019) {
			c = Nationality.BAH;
		} else if (a < 0.9982716) {
			c = Nationality.MAR;
		} else if (a < 0.9985548) {
			c = Nationality.BAR;
		} else if (a < 0.9987358) {
			c = Nationality.SAL;
		} else if (a < 0.9989023) {
			c = Nationality.GUM;
		} else if (a < 0.9990641) {
			c = Nationality.CUR;
		} else if (a < 0.9991751) {
			c = Nationality.GRE;
		} else if (a < 0.9992844) {
			c = Nationality.VIN;
		} else if (a < 0.9993873) {
			c = Nationality.UVI;
		} else if (a < 0.9994839) {
			c = Nationality.ANB;
		} else if (a < 0.9995549) {
			c = Nationality.DOM;
		} else if (a < 0.9996198) {
			c = Nationality.CAY;
		} else if (a < 0.9996811) {
			c = Nationality.BER;
		} else if (a < 0.9997378) {
			c = Nationality.NOR;
		} else if (a < 0.9997938) {
			c = Nationality.GRL;
		} else if (a < 0.9998481) {
			c = Nationality.SAM;
		} else if (a < 0.9998864) {
			c = Nationality.CAI;
		} else if (a < 0.9999246) {
			c = Nationality.SAM;
		} else if (a < 0.9999544) {
			c = Nationality.BVI;
		} else if (a < 0.9999803) {
			c = Nationality.CNE;
		} else if (a < 0.9999951) {
			c = Nationality.ANG;
		}
		return c;
	}
	
}
