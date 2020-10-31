
package DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AVLTest {
	
	private AVL<Integer, Integer> avl;

	private void setupStage0() {
		avl = new AVL<>();
	}
	
	private void setupStage1() {
		setupStage0();
		avl.insert(82, -4134);
	}

	private void setupStage2() {
		setupStage1();
		avl.insert(-91354, 137);
		avl.insert(0, 724520);
		avl.insert(-1820, 7);
	}

}
