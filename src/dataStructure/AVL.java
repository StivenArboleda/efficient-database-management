package dataStructure;

import java.io.Serializable;

public class AVL<K extends Comparable<K>, E> extends ABB<K, E> implements IAVL<K, E> , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4872681473858411867L;
	
	public AVL() {
		super();
	}
	
	public int height() {//of root
		int h = 0;
		if (super.getRoot() != null) {
			h = super.getRoot().getHeight();
		}
		return h;
	}
	
	@Override
	public void update(Node<K, E> node) {
		int leftH;
		int rightH;
		if (node != null) {
			if (node.getLeft() == null) {
				leftH = -1;
			} else {
				leftH = node.getLeft().getHeight();
			}
			if (node.getRight() == null) {
				rightH = -1;
			} else {
				rightH = node.getRight().getHeight();
			}
			
			node.setHeight(1 + Math.max(leftH, rightH));
			node.setFb(rightH - leftH); 
		}
	}
	 
	@Override
	public Node<K, E> balance(Node<K, E> node) {
		if (node != null) {
			if (node.getFb() == -2) {
				if (node.getLeft().getFb() <= 0) {
					node = leftLeftCase(node);
				} else {
					node = leftRightCase(node);
				}
		    } else if (node.getFb() == 2) {
		    	if (node.getRight().getFb() >= 0) {
		    		node = rightRightCase(node);
		    	} else {
		    		node = rightLeftCase(node);
		    	}
		    }
		}
		return node;
	}
	
	public Node<K, E> search(K key) {
		return super.search(key);
	}

	private Node<K, E> leftLeftCase(Node<K, E> node) {
		return rightRotation(node);
	}

	private Node<K, E> leftRightCase(Node<K, E> node) {
		node.setLeft(leftRotation(node.getLeft()));
		return leftLeftCase(node);
		
	}

	private Node<K, E> rightRightCase(Node<K, E> node) {
		return leftRotation(node);
	}

	private Node<K, E> rightLeftCase(Node<K, E> node) {
		node.setRight(leftRotation(node.getRight()));
		return rightRightCase(node);
	}
	
	@Override
	public Node<K, E> rightRotation(Node<K, E> node) {
		Node<K, E> newFather = node.getLeft();
		node.setLeft(newFather.getRight());
		if (null != newFather.getRight()) {
			newFather.getRight().setParent(node);
		}
		newFather.setRight(node);
		if (node != super.getRoot()) {
			newFather.setParent(node.getParent());
			if (node == node.getParent().getRight()) {
				node.getParent().setRight(newFather);
			} else {
				node.getParent().setLeft(newFather);
			}
		} else {
			super.setRoot(newFather);
			newFather.setParent(null);
		}
		node.setParent(newFather);
		update(node);
		update(newFather);
		return newFather;
	}

	@Override
	public Node<K, E> leftRotation(Node<K, E> node) {
		Node<K, E> newFather = node.getRight();
		node.setRight(newFather.getLeft());
		if (null != newFather.getLeft()) {
			newFather.getLeft().setParent(node);
		}
		newFather.setLeft(node);
		if (node != super.getRoot()) {
			newFather.setParent(node.getParent());
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(newFather); 
			} else {
				node.getParent().setRight(newFather);
			}
		} else {
			super.setRoot(newFather);
			newFather.setParent(null);
		}
		node.setParent(newFather);
		update(node);
		update(newFather);
		return newFather;
	}
	
	@Override
	public void insert(K key, E element) {// estoy casi seguro que este sirve
		Node<K, E> x = new Node<>(key, element);
		super.insert(x);
		while (x != null) {
			update(x);
			balance(x);
			x = x.getParent();
		}
	}
	
	@Override
	public Node<K, E> delete(K key) {
		Node<K, E> node = super.search(key);
		Node<K, E> father = null;
		if (node != null) {
			father = node.getParent();
		}
		Node<K, E> deleted = super.delete(node);
		if (father != null) {
			while (father != null) {
				update(father);
				balance(father);
				father = father.getParent();
			}
			
		} else {
			update(super.getRoot());
			balance(super.getRoot());
		}
		return deleted;
	}
	
	public boolean verifyAVLInvarient(Node<K, E> node) {
		boolean isIt = true;
		if (node != null) {
			if (node.getFb() < -1 || node.getFb() > 1) {
				isIt = false;
			}
			isIt = isIt && verifyAVLInvarient(node.getRight()) && verifyAVLInvarient(node.getLeft());
		}	
		return isIt;
	}

}