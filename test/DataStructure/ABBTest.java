package DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
