package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dataStructure.AVL;
import dataStructure.Node;
import javafx.scene.control.Button;

public class Controller {
	
	public final static String COUNTRIES = "data/countries.csv";
	public final static String LASTNAMES = "data/lastNames.csv";
	public final static String NAMES = "data/names.csv";
	
	private int actualCod;
	private AVL<String, Person> names;
	private AVL<String, Person> lastNames;
	private AVL<String, Person> completeNames;
	private AVL<String, Person> cods;
	private String[] countries;
	private double[] percentage;
	private String[] aNames;
	private String[] aLastNames;

	public Controller() {
		actualCod = 1;
		countries = new String[51];
		percentage = new double[51];
		aNames = new String[6781];
		aLastNames = new String[162252];
		cods = new AVL<>();
		names = new AVL<>();
		lastNames = new AVL<>();
		completeNames = new AVL<>();
	}
	
	public void updatePerson(Person p, String key, int criterion) {
		switch (criterion) {
			case 0:
				p.setName(key);
			break;
			case 1:
				p.setLastName(key);
			break;
			case 2:
				p.setNationality(key);
			break;
			case 3:
				p.setPhoto(key);
			break;
		}
	}
	
	public void updatePerson(Person p, int gender) {
		p.setGender(gender);
	}
	
<<<<<<< HEAD
	public ArrayList<Person> search2(String name) {
		return search2(names.getRoot(), name);
	}
	
	private ArrayList<Person> search2(Node<String, Person> x,String name) {
		ArrayList<Person> ps = new ArrayList<>();
		if (ps.size() < 100) {
			if (x == null || x.getKey().substring(0, name.length()).compareToIgnoreCase(name) == 0) {
				ps.add(x.getElement());
				if (x.getLeft() != null) {
					search2(x.getLeft(), name);
				}
				if (x.getRight() != null) {
					search2(x.getRight(), name);
				}
			} else {
				if (name.compareToIgnoreCase(x.getKey().substring(0, name.length())) > 0) {
					search2(x.getRight(), name);
				} else {
					search2(x.getLeft(), name);
				}
			}
		}
		
		return ps;
	}
	
=======
>>>>>>> cbaaf5dfc09e126cdf39c0b6a33a9ecedaeb8582
	public void updatePerson(Person p, int year, int month, int day) {
		Date date = new Date(day, month, year);
		p.setBornDate(date);
	}
	
	public void updatePerson(Person p, double height) {
		p.setHeight(height);
	}
	
	public void deletePerson(Person p) {
		 names.delete(p.getName());
		 lastNames.delete(p.getLastName());
		 completeNames.delete(p.getCompleteName());
		 cods.delete(p.getCod());
	}
	
	public Person searchPerson(String key, int which) {// which es cual de las busquedas se realizara
		Person p = null;							  // 0 por nombre
		switch (which) {							  // 1 por apellido
			case 0:									  // 2 por nombre completo
				p = searchPersonName(key);			  // 3 por codigo
			break;									  // key es el correspondiente a la busqueda
			case 1:
				p = searchPersonLastName(key);
			break;
			case 2:
				p = searchPersonCompleteName(key);
			break;
			case 3:
				p = searchPersonCod(key);
			break;
		}
		return p;
	}
	
	private Person searchPersonName(String name) {
		Person p = null;
		if (names.search(name) != null) {
			p = names.search(name).getElement();
		}
		return p;
	}

	private Person searchPersonLastName(String last) {
		Person p = null;
		if (lastNames.search(last) != null) {
			p = lastNames.search(last).getElement();
		}
		return p;
	}

	private Person searchPersonCompleteName(String complete) {
		Person p = null;
		if (completeNames.search(complete) != null) {
			p = completeNames.search(complete).getElement();
		}
		return p;
	}

	private Person searchPersonCod(String cod) {
		Person p = null;
		if (cods.search(cod) != null) {
			p = cods.search(cod).getElement();
		}
		return p;
	}
	
	/**
	 * 
	 * ATENCIÓN MALAS PRACTICAS ACONTINUACIÓN
	 * 
	 * CONTINUE CON PRECAUCIÓN
	 * 
	 * D: D: D: D: D: D: D: D: D: D: D:
	 * 
	 * 
	 */
	
	public ArrayList<Person> search2(AVL<String, Person> avl, String name) {
		return search2(avl.getRoot(), name);
	}
	
	private ArrayList<Person> search2(Node<String, Person> x,String name) {
		ArrayList<Person> ps = new ArrayList<>();
		if (ps.size() < 100) {
			if (x == null || x.getKey().substring(0, name.length()).compareToIgnoreCase(name) == 0) {
				ps.add(x.getElement());
				if (x.getLeft() != null) {
					search2(x.getLeft(), name);
				}
				if (x.getRight() != null) {
					search2(x.getRight(), name);
				}
			} else {
				if (name.compareToIgnoreCase(x.getKey().substring(0, name.length())) > 0) {
					search2(x.getRight(), name);
				} else {
					search2(x.getLeft(), name);
				}
			}
		}
		return ps;
	}
	
	/**
	 * 
	 * FIN DE LAS MALAS PRACTICAS
	 * 
	 * PUEDE CONTINUAR SIN MIEDO
	 * 
	 * :D :D :D :D :D :D :D :D :D
	 * 
	 * 
	 */
	
	public Date createDate(int year, int month, int day) {
		return new Date(day, month, year);
	}

	public void addPerson(String name, String lastName, int gender, int year, int month, int day, double height,
			String nationality, String photo, Button update) {
		
		Date bornDate = createDate(year, month, day);
		String cod = generateCod();
		Person p = new Person(cod, name, lastName, gender, bornDate, height, nationality, photo, update);
		addPerson(p);
	}
	
	public void addPerson(String photo, Button update) {
		String cod = generateCod();
		Date date = generateDate();
		int gender = generateGender();
		double height = generateHeight();
		String nationality = generateNationality();
		String[] completeName = generateName();
		String name = completeName[0];
		String lastName = completeName[1];
		Person p = new Person(cod, name, lastName, gender, date, height, nationality, photo, update);
		addPerson(p);
	}
	
	private void addPerson(Person p) {
		names.insert(p.getName(), p);
		lastNames.insert(p.getLastName(), p);
		completeNames.insert(p.getCompleteName(), p);
		cods.insert(p.getCod(), p);
	}
	
	public String generateCod() {
		return "A00" + actualCod++;
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
		File fl = new File(COUNTRIES);
		FileReader fr = new FileReader(fl);
		BufferedReader bw = new BufferedReader(fr);
		String line = bw.readLine();
		int i = 0;
		while (line != null) {
			String[] data = line.split(";");
			countries[i]  = data[0];
			percentage[i] = Double.parseDouble(data[1]);
			i++;
			line = bw.readLine();
		}
		fr.close();
		bw.close();
	}
	
	public void loadFromFilesNames() throws IOException {
		File fl = new File(NAMES);
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String msg = br.readLine();
		int i = 0;
		
		while(msg != null) {
			String[] data = msg.split(";");
			aNames[i]  = data[0];
			msg = br.readLine();
			
			i++;
		}
		
		br.close();
		fr.close();
	}
	
	public void loadFromFilesLastNames() throws IOException {
		File fl = new File(LASTNAMES);
		FileReader fr = new FileReader(fl);
		BufferedReader bw = new BufferedReader(fr);
		String line = bw.readLine();
		int i = 0;
		
		while (line != null) {
			String[] data = line.split(";");
			aLastNames[i]  = data[0];
			i++;
			line = bw.readLine();
		}
		fr.close();
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
		return cods;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(AVL<String, Person> cod) {
		this.cods = cod;
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

	public void serializeNames() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/PersistenceNames.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(names);
		oos.close();
	}

	public void serializeLastnames()throws IOException {
		FileOutputStream fos = new FileOutputStream("data/PersistenceLastnames.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(lastNames);
		oos.close();
	}

	public void serializeCompleteNames() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/PersistenceCompletenames.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(completeNames);
		oos.close();
	}

	public void serializeIds() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/PersistenceIds.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(cods);
		oos.close();
	}

	
}