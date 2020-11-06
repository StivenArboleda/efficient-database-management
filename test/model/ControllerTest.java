package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ControllerTest {

	private Controller c;
	
	private void setupStage() {
		c = new Controller();
		c.addPerson("Sebastián", "Barrera", 1, 1998, 11, 19, 1.74, "Colombia", "img1.jpg", null);
		c.addPerson("Alejandro", "Garcia", 1, 2000, 2, 5, 1.75, "Colombia", "img2.jpg",null);
		c.addPerson("Jon", "Z", 1, 2001, 7, 5, 1.70, "Colombia", "img3.jpg", null);
		c.addPerson("Valentina", "Caicedo",0, 1999, 5, 30, 1.68, "Colombia", "img4.jpg", null);
		c.addPerson("Esteban", "Yusunguaira", 1, 2001, 9, 27, 1.75, "Colombia", "img5.jpg", null);
	}
	
	@Test
	void testAddedCorrectlyNames() {
		setupStage();
		
		assertEquals("Jon", c.getNames().getRoot().getKey());
		
		assertEquals("Alejandro", c.getNames().getRoot().getLeft().getKey());
		assertEquals("Esteban", c.getNames().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getNames().getRoot().getLeft().getLeft());
		assertEquals(null, c.getNames().getRoot().getLeft().getRight().getLeft());
		assertEquals(null, c.getNames().getRoot().getLeft().getRight().getRight());
		
		assertEquals("Sebastián", c.getNames().getRoot().getRight().getKey());
		assertEquals("Valentina", c.getNames().getRoot().getRight().getRight().getKey());
		assertEquals(null, c.getNames().getRoot().getRight().getLeft());
		assertEquals(null, c.getNames().getRoot().getRight().getRight().getLeft());
		assertEquals(null, c.getNames().getRoot().getRight().getRight().getRight());
	}
	
	@Test
	void testAddedCorrectlyLastNames() {
		setupStage();
		
		assertEquals("Garcia", c.getLastNames().getRoot().getKey());
		
		assertEquals("Barrera", c.getLastNames().getRoot().getLeft().getKey());
		assertEquals("Caicedo", c.getLastNames().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getLastNames().getRoot().getLeft().getLeft());
		assertEquals(null, c.getLastNames().getRoot().getLeft().getRight().getLeft());
		assertEquals(null, c.getLastNames().getRoot().getLeft().getRight().getRight());
		
		assertEquals("Z", c.getLastNames().getRoot().getRight().getKey());
		assertEquals("Yusunguaira", c.getLastNames().getRoot().getRight().getLeft().getKey());
		assertEquals(null, c.getLastNames().getRoot().getRight().getRight());
		assertEquals(null, c.getLastNames().getRoot().getRight().getLeft().getLeft());
		assertEquals(null, c.getLastNames().getRoot().getRight().getLeft().getRight());
	}
	
	@Test
	void testAddedCorrectlyCompleteNames() {
		setupStage();
		
		assertEquals("Jon Z", c.getCompleteNames().getRoot().getKey());
		
		assertEquals("Alejandro Garcia", c.getCompleteNames().getRoot().getLeft().getKey());
		assertEquals("Esteban Yusunguaira", c.getCompleteNames().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getRight().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getRight().getRight());
		
		assertEquals("Sebastián Barrera", c.getCompleteNames().getRoot().getRight().getKey());
		assertEquals("Valentina Caicedo", c.getCompleteNames().getRoot().getRight().getRight().getKey());
		assertEquals(null, c.getCompleteNames().getRoot().getRight().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getRight().getRight().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getRight().getRight().getRight());
	}
	
	@Test
	void testAddedCorrectlyCods() {
		setupStage();
		
		assertEquals("A002", c.getCod().getRoot().getKey());
		
		assertEquals("A001", c.getCod().getRoot().getLeft().getKey());
		assertEquals(null, c.getCod().getRoot().getLeft().getLeft());
		assertEquals(null, c.getCod().getRoot().getLeft().getRight());
		
		assertEquals("A004", c.getCod().getRoot().getRight().getKey());
		assertEquals("A005", c.getCod().getRoot().getRight().getRight().getKey());
		assertEquals("A003", c.getCod().getRoot().getRight().getLeft().getKey());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft().getRight());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft().getLeft());
		assertEquals(null, c.getCod().getRoot().getRight().getRight().getLeft());
		assertEquals(null, c.getCod().getRoot().getRight().getRight().getRight());
	}
	
	@Test
	void testSearch() {
		setupStage();
		
		assertEquals("Sebastián", c.getNames().search("Sebastián").getKey());
		assertEquals("Garcia", c.getLastNames().search("Garcia").getKey());
		assertEquals("Jon Z", c.getCompleteNames().search("Jon Z").getKey());
		assertEquals("A004", c.getCod().search("A004").getKey());
		assertEquals("Esteban Yusunguaira", c.getCod().search("A005").getElement().getCompleteName());
	}
	
	@Test
	void testUpdate() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		Person p2 = c.getLastNames().search("Garcia").getElement();
		Person p3 = c.getCompleteNames().search("Jon Z").getElement();
		Person p4 = c.getCod().search("A004").getElement();
		Person p5 = c.getCod().search("A005").getElement();
		
		assertEquals(1.74, p1.getHeight());
		assertEquals(Person.MALE, p2.getGender());
		assertEquals(2001, p3.getBornDate().getYear());
		assertEquals("Valentina", p4.getName());
		assertEquals("Yusunguaira", p5.getLastName());
		assertEquals("Colombia", p1.getNationality());
		assertEquals("img2.jpg", p2.getPhoto());
		
		c.updatePerson(p1, 1.99);
		c.updatePerson(p2, Person.FEMALE);
		c.updatePerson(p3, 1989, 12, 3);
		c.updatePerson(p4, "Valen", 0);
		c.updatePerson(p5, "Segundo Apellido", 1);
		c.updatePerson(p1, "Alemania", 2);
		c.updatePerson(p2, "RandomGirl.jpg", 3);
		
		assertEquals(1.99, p1.getHeight());
		assertEquals(Person.FEMALE, p2.getGender());
		assertEquals(1989, p3.getBornDate().getYear());
		assertEquals("Valen", p4.getName());
		assertEquals("Segundo Apellido", p5.getLastName());
		assertEquals("Alemania", p1.getNationality());
		assertEquals("RandomGirl.jpg", p2.getPhoto());
	}
	
	@Test
	void testDelete() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		c.deletePerson(p1);
		
		assertEquals(null, c.getNames().search(p1.getName()));
		assertEquals(null, c.getLastNames().search(p1.getLastName()));
		assertEquals(null, c.getCompleteNames().search(p1.getCompleteName()));
		assertEquals(null, c.getCod().search(p1.getCod()));
	}
	
	@Test
	void testDeleteCorrectlyName() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		c.deletePerson(p1);
		
		assertEquals("Jon", c.getNames().getRoot().getKey());
		
		assertEquals("Alejandro", c.getNames().getRoot().getLeft().getKey());
		assertEquals("Esteban", c.getNames().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getNames().getRoot().getLeft().getLeft());
		assertEquals(null, c.getNames().getRoot().getLeft().getRight().getLeft());
		assertEquals(null, c.getNames().getRoot().getLeft().getRight().getRight());
		
		assertEquals("Valentina", c.getNames().getRoot().getRight().getKey());
		assertEquals(null, c.getNames().getRoot().getRight().getRight());
		assertEquals(null, c.getNames().getRoot().getRight().getLeft());
	}
	
	@Test
	void testDeleteCorrectlyLastName() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		c.deletePerson(p1);
		
		assertEquals("Garcia", c.getLastNames().getRoot().getKey());
		
		assertEquals("Caicedo", c.getLastNames().getRoot().getLeft().getKey());
		assertEquals(null, c.getLastNames().getRoot().getLeft().getRight());
		assertEquals(null, c.getLastNames().getRoot().getLeft().getLeft());
		
		assertEquals("Z", c.getLastNames().getRoot().getRight().getKey());
		assertEquals("Yusunguaira", c.getLastNames().getRoot().getRight().getLeft().getKey());
		assertEquals(null, c.getLastNames().getRoot().getRight().getRight());
		assertEquals(null, c.getLastNames().getRoot().getRight().getLeft().getLeft());
		assertEquals(null, c.getLastNames().getRoot().getRight().getLeft().getRight());
	}
	
	@Test
	void testDeleteCorrectlyCompleteName() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		c.deletePerson(p1);
		
		assertEquals("Jon Z", c.getCompleteNames().getRoot().getKey());
		
		assertEquals("Alejandro Garcia", c.getCompleteNames().getRoot().getLeft().getKey());
		assertEquals("Esteban Yusunguaira", c.getCompleteNames().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getRight().getLeft());
		assertEquals(null, c.getCompleteNames().getRoot().getLeft().getRight().getRight());
		
		assertEquals("Valentina Caicedo", c.getCompleteNames().getRoot().getRight().getKey());
		assertEquals(null, c.getCompleteNames().getRoot().getRight().getRight());
		assertEquals(null, c.getCompleteNames().getRoot().getRight().getLeft());
	}
	
	@Test
	void testDeleteCorrectlyCods() {
		setupStage();
		
		Person p1 = c.getNames().search("Sebastián").getElement();
		c.deletePerson(p1);
		
		assertEquals("A004", c.getCod().getRoot().getKey());
		
		assertEquals("A002", c.getCod().getRoot().getLeft().getKey());
		assertEquals("A003", c.getCod().getRoot().getLeft().getRight().getKey());
		assertEquals(null, c.getCod().getRoot().getLeft().getLeft());
		assertEquals(null, c.getCod().getRoot().getLeft().getRight().getRight());
		assertEquals(null, c.getCod().getRoot().getLeft().getRight().getLeft());
		
		assertEquals("A005", c.getCod().getRoot().getRight().getKey());
		assertEquals(null, c.getCod().getRoot().getRight().getRight());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft());
	}
	
	@Test
	void testDeleteRoot() {
		setupStage();
		
		Person p2 = c.getCompleteNames().search("Alejandro Garcia").getElement();
		c.deletePerson(p2);
		
		assertEquals("A003", c.getCod().getRoot().getKey());
		
		assertEquals("A001", c.getCod().getRoot().getLeft().getKey());
		assertEquals(null, c.getCod().getRoot().getLeft().getRight());
		assertEquals(null, c.getCod().getRoot().getLeft().getLeft());
		
		assertEquals("A004", c.getCod().getRoot().getRight().getKey());
		assertEquals("A005", c.getCod().getRoot().getRight().getRight().getKey());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft());
		assertEquals(null, c.getCod().getRoot().getRight().getRight().getRight());
		assertEquals(null, c.getCod().getRoot().getRight().getRight().getLeft());
	}
	
	@Test
	void testDeleteInterestingAndConections() {
		setupStage();
		
		Person p4 = c.getCod().search("A004").getElement();
		c.deletePerson(p4);
		
		
		assertEquals("A002", c.getCod().getRoot().getKey());
		
		assertEquals("A001", c.getCod().getRoot().getLeft().getKey());
		assertEquals(null, c.getCod().getRoot().getLeft().getRight());
		assertEquals(null, c.getCod().getRoot().getLeft().getLeft());
		
		assertEquals("A005", c.getCod().getRoot().getRight().getKey());
		assertEquals("A003", c.getCod().getRoot().getRight().getLeft().getKey());
		assertEquals(null, c.getCod().getRoot().getRight().getRight());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft().getRight());
		assertEquals(null, c.getCod().getRoot().getRight().getLeft().getLeft());
		
		assertEquals(c.getCod().getRoot().getLeft().getParent(), c.getCod().getRoot());
		assertEquals(c.getCod().getRoot().getRight().getParent(), c.getCod().getRoot());
		assertEquals(c.getCod().getRoot().getRight().getLeft().getParent(), c.getCod().getRoot().getRight());
	}
		
}