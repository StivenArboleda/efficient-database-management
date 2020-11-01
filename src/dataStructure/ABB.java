package dataStructure;

import java.io.Serializable;




public class ABB<K extends Comparable<K>, E> implements IABB<K, E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3253538206332644643L;
	private Node<K, E> root;
	protected int height;

	public ABB() {
		this.root = null;
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
		Node<K, E> m = null;
		while (x.getRight() != null) {
			m = x.getRight();
		}
		return m;
	}

	@Override
	public Node<K, E> minimun() {
		return minimun(root);
	}

	@Override
	public Node<K, E> minimun(Node<K, E> x) {
		Node<K, E> m = null;
		while (x.getLeft() != null) {
			m = x.getLeft();
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
	

	@Override
	public void update(K key, E element, K newKey) {

		Node<K, E> n = search(key);
		n.setType(element);
		n.setKey(newKey);
	}

	
}
