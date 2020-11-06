package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RBTreeTest {
		
		private RedBlackTree<Integer, Integer> rb;

		
		
		private void setupStage() {
			rb = new RedBlackTree<>();
			int[] values = {41, 44, 95, 83, 72, 66, 94, 90, 59};
		    for (int v : values) {
		    	rb.insert(v, v);
		    }
		}
		
		@Test
		void interestingCaseIsBalanced() {
			setupStage();
			assertEquals(44 ,rb.getRoot().getValue());
			
			assertEquals(83 ,rb.getRoot().getRight().getValue());
			assertEquals(41 ,rb.getRoot().getLeft().getValue());
			
			assertEquals(66 ,rb.getRoot().getRight().getLeft().getValue());
			assertEquals(94 ,rb.getRoot().getRight().getRight().getValue());
			
			assertEquals(59 ,rb.getRoot().getRight().getLeft().getLeft().getValue());
			assertEquals(72 ,rb.getRoot().getRight().getLeft().getRight().getValue());
			assertEquals(90 ,rb.getRoot().getRight().getRight().getLeft().getValue());
			assertEquals(95 ,rb.getRoot().getRight().getRight().getRight().getValue());
		}
		
		@Test
		void interestingCaseByColors() {
			assertEquals(Node.BLACK, rb.getRoot().getColor());
		    assertEquals(Node.BLACK, rb.getRoot().getLeft().getColor());
		    assertEquals(Node.RED, rb.getRoot().getRight().getColor());
		    assertEquals(Node.BLACK, rb.getRoot().getRight().getLeft().getColor());
		    assertEquals(Node.BLACK, rb.getRoot().getRight().getRight().getColor());
		    assertEquals(Node.RED, rb.getRoot().getRight().getLeft().getLeft().getColor());
		    assertEquals(Node.RED, rb.getRoot().getRight().getLeft().getRight().getColor());
		    assertEquals(Node.RED, rb.getRoot().getRight().getRight().getLeft().getColor());
		    assertEquals(Node.RED, rb.getRoot().getRight().getRight().getRight().getColor());
		}
		
		
		
		

}
