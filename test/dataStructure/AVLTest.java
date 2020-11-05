
package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class AVLTest {
	
	private AVL<Integer, Integer> avl;

	private void setupStage0() {
		avl = new AVL<>();
	}
	
	private void setupStage1() {
		setupStage0();
		avl.insert(1, 5);
	}

	private void setupStage2() {
		setupStage1();
		avl.insert(2, 6);
		avl.insert(3, 7);
		avl.insert(4, 8);
	}
	
	@Test
	void testInsert0() {
		setupStage0();
		int key = 75343;
		int element = 63436;
		avl.insert(key, element);
		assertEquals(avl.getRoot().getElement(), element, "The tree is not inserting in the correct way");
		assertEquals(avl.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testInsert1() {
		setupStage1();
		int key = 75343;
		int element = 63436;
		avl.insert(key, element);
		assertEquals(avl.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testInsert2() {
		setupStage2();
		int key = 75343;
		int element = 63436;
		avl.insert(key, element);
		assertEquals(avl.search(key).getElement(), element, "The tree is not inserting in the correct way");
	}
	
	@Test
	void testDelete0() {
		setupStage0();
		int testValue = 2957;
		avl.delete(testValue);
		assertEquals(avl.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testDelete1() {
		setupStage1();
		int testValue = 1;
		avl.delete(testValue);
		assertEquals(avl.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testDelete2() {
		setupStage2();
		int testValue = 3;
		avl.delete(testValue);
		assertEquals(avl.search(testValue), null, "The tree is not deleting, it should'nt have nodes");
	}
	
	@Test
	void testSearch0() {
		setupStage0();
		assertEquals(avl.search(42), null, "The tree is not searching as well");
	}
	
	@Test
	void testSearch1() {
		setupStage2();
		assertEquals(avl.search(1).getElement(), 5, "The tree is not searching as well");
	}
	
	@Test
	void testSearch2() {
		setupStage2();
		assertEquals(avl.search(3).getElement(), 7, "The tree is not searching as well");
	}
	
	
	/*@Test
	void testLeftRightCase() {
		setupStage2();
		assertEquals(1, avl.getRoot().getKey());
		
	}*/
	
	
	
//	public void rightCases(Node<K,E> nodeR) {
//		int balanceF = balanceFactor(nodeR);
//		if(balanceF == 1 || balanceF == 0) {
//			leftRotate(nodeR.getParent());
//		}else {
//			Node<K, E> parent = nodeR.getParent();
//			rightRotate(nodeR.getParent());
//			leftRotate(parent);
//		}
//	}

}
