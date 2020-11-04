package dataStructure;


public class NodeRBTree<K extends Comparable<K>, E> {
	

	public static final boolean RED = true;
	public static final boolean BLACK = false;


	private boolean color = RED;

	public K value;

	private NodeRBTree<K,E> left;
	private NodeRBTree<K,E> right;
	private NodeRBTree<K,E> parent;


	public NodeRBTree(K value, NodeRBTree<K, E> parent) {
		this.value = value;
		this.parent = parent;
	}

	public NodeRBTree(boolean color, K value) {
		this.color = color;
		this.value = value;
	}

	public NodeRBTree(K key, boolean color, NodeRBTree<K,E> parent, NodeRBTree<K,E> left, NodeRBTree<K,E> right) {
		this.value = key;
		this.color = color;

		if (parent == null && left == null && right == null) {
			parent = this;
			left = this;
			right = this;
		}

		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public K getValue() {
		return value;
	}

	public void setValue(K value) {
		this.value = value;
	}

	public NodeRBTree<K,E> getLeft() {
		return left;
	}

	public void setLeft(NodeRBTree<K,E> left) {
		this.left = left;
	}

	public NodeRBTree<K,E> getRight() {
		return right;
	}

	public void setRight(NodeRBTree<K,E> right) {
		this.right = right;
	}

	public NodeRBTree<K,E> getParent() {
		return parent;
	}

	public void setParent(NodeRBTree<K,E> parent) {
		this.parent = parent;
	}
}