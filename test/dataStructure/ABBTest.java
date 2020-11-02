package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.ABB;

class ABBTest {

	private ABB<Integer, Integer> abb;
	
	private void setupStage0() {
		abb = new ABB<>();
	}
	
	private void setupStage1() {
		setupStage0();
		abb.insert(1, 5);
	}

	private void setupStage2() {
		setupStage1();
		abb.insert(2, 6);
		abb.insert(3, 7);
		abb.insert(4, 8);
	}
	
	@Test
	void testInsert0() {
		setupStage0();
		int key = 75343;
		int element = 63436;
		abb.insert(key, element);
		assertEquals(abb.getRoot().getElement(), element, "The tree is not inserting in the correct way");
		assertEquals(abb.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testInsert1() {
		setupStage1();
		int key = 75343;
		int element = 63436;
		abb.insert(key, element);
		assertEquals(abb.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testInsert2() {
		setupStage2();
		int key = 75343;
		int element = 63436;
		abb.insert(key, element);
		assertEquals(abb.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testDelete0() {
		setupStage0();
		int testValue = 2957;
		abb.delete(testValue);
		assertEquals(abb.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testDelete1() {
		setupStage1();
		int testValue = 1;
		abb.delete(testValue);
		assertEquals(abb.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testDelete2() {
		setupStage2();
		int testValue = 3;
		abb.delete(testValue);
		assertEquals(abb.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testSearch0() {
		setupStage0();
		assertEquals(abb.search(42), null, "The tree is not searching as well");
	}
	
	@Test
	void testSearch1() {
		setupStage2();
		assertEquals(abb.search(1).getElement(), 5, "The tree is not searching as well");
	}
	
	@Test
	void testSearch2() {
		setupStage2();
		assertEquals(abb.search(3).getElement(), 7, "The tree is not searching as well");
	}

}
