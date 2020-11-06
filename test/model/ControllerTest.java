package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Button;

class ControllerTest {

	private Controller c;
	
	private void setupStage() {
		c = new Controller();
		c.addPerson("Sebastián", "Barrera", 1, 1998, 11, 19, 1.74, "Colombia", "photo", new Button());
		c.addPerson("Alejandro", "Garcia", 1, 2000, 2, 5, 1.75, "Colombia", "photo", new Button());
		c.addPerson("Jon", "Z", 1, 2001, 7, 5, 1.70, "Colombia", "photo", new Button());
		c.addPerson("Valentina", "Caicedo",2, 1999, 5, 30, 1.68, "Colombia", "photo", new Button());
		c.addPerson("Esteban", "Yusunguaira", 1, 2001, 9, 27, 1.75, "Colombia", "photo", new Button());
	}
	
	@Test
	void testAddedCorrectly() {
		setupStage();
		assertEquals("Jon", c.getNames().getRoot().getKey());
	}
	
}
