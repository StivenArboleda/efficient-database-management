package dataStructure;

import java.io.Serializable;


public class ABB<K extends Comparable<K>, E> implements IABB<K, E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3253538206332644643L;
	
	private Node<K, E> root;
	private int counter;

	public ABB() {
		this.root = null;
	}
	
	public int size() {
		return counter;
	}
	 
	public boolean isEmpty() {
		boolean is = false;
		if (counter == 0) {
			is = true;
		}
		return is; 
	}

	public Node<K, E> getRoot() {
		return root;

	}

	public void setRoot(Node<K, E> root) {
		this.root = root;
	}

	public void insert(K key, E element) {
		Node<K, E> in = new Node<>(key, element);
		insert(in);
		counter++;
	}

	@Override
	public void insert(Node<K, E> z) {
		Node<K, E> father = null;
		Node<K, E> x = root;
		while (x != null) {
			father = x;
			if (z.getKey().compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		z.setParent(father);
		if (father == null) {
			root = z;
		} else {
			 if (z.getKey().compareTo(father.getKey()) < 0) {
				 father.setLeft(z);
			 } else {
				 father.setRight(z);
			 }
			 z.setParent(father);
		}
		
	}

	public Node<K, E> delete(K key) {
		Node<K, E> toDelete = search(key);
		return delete(toDelete);
	}

	@Override
	public Node<K, E> delete(Node<K, E> z) {
		Node<K, E> deleted = null;
		Node<K, E> x = null;
		if (z != null) {
			if (z.getLeft() == null || z.getRight() == null) {
				deleted = z;
			} else {
				deleted = succesor(z);
			}
			if (deleted.getLeft() != null) {
				x = deleted.getLeft();
			} else {
				x = deleted.getRight();
			}
			if (x != null) {
				x.setParent(deleted.getParent());
			}
			if (deleted.getParent() == null) {
				root = x;
			} else {
				if (deleted == deleted.getParent().getLeft()) {
					deleted.getParent().setLeft(x);
				} else {
					deleted.getParent().setRight(x);
				}
			}
			if (deleted != z) {
				z.setKey(deleted.getKey());
			}
			counter--;
		}
		
		return deleted;
	}
	
	@Override
	public Node<K, E> succesor(Node<K, E> x) {
		Node<K, E> y;
		if (x.getRight() != null) {
			y = minimun(x.getRight());
		} else {
			y = x.getParent();
			while (y != null && x == y.getRight()) {
				x = y;
				y = y.getParent();
			}
		}
		return y;
	}
	
	@Override
	public Node<K, E> maximun() {
		return maximun(root);
	}

	@Override
	public Node<K, E> maximun(Node<K, E> x) {
		Node<K, E> m = x;
		while (m.getRight() != null) {
			m = m.getRight();
		}
		return m;
	}

	@Override
	public Node<K, E> minimun() {
		return minimun(root);
	}

	@Override
	public Node<K, E> minimun(Node<K, E> x) {
		Node<K, E> m = x;
		while (m.getLeft() != null) {
			m = m.getLeft();
		}
		return m;
	}

	
	@Override
	public Node<K, E> search(K key) {
		return search(root, key);
	}

	@Override
	public Node<K, E> search(Node<K, E> x, K key) {
		Node<K, E> s;
		if (x == null || x.getKey().compareTo(key) == 0) {
			s = x;
		} else {
			if (key.compareTo(x.getKey()) > 0) {
				s = search(x.getRight(), key);
			} else {
				s = search(x.getLeft(), key);
			}
		}
		return s;
	}
	

	 
	 public boolean validateABBInvarient(Node<K, E> node) {
		 boolean valid = false;
		 if (node == null) {
			return true;
		}
		K key = node.getKey();
		boolean isOk = true;
		if (node.getLeft() != null) {
			isOk = (isOk && node.getLeft().getKey().compareTo(key) < 0);
 		}
		if (node.getRight() != null) {
			isOk = (isOk && node.getRight().getKey().compareTo(key) > 0);
		}
		valid = (isOk && validateABBInvarient(node.getLeft()) && validateABBInvarient(node.getRight()));
		return valid;
	 }
	
}
