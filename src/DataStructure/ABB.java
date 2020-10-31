package DataStructure;

import java.io.Serializable;

public class ABB<K extends Comparable<K>, E> implements IABB<K, E>, Serializable {

	private Node<K, E> root;

	public ABB() {
		this.root = null;
	}

	public Node<K, E> getRoot() {
		return root;

	}

	public void setRoot(Node<K, E> root) {
		this.root = root;
	}

	@Override
	public boolean insert(K key, E element) {

		Node n = new Node(key, element);
		return add(n);

	}

	public boolean add(Node<K, E> n) {

		if (search(n.getKey()) != null) {
			return false;

		}
		if (root == null) {

			root = n;
			return true;
		}

		Node<K, E> tmp = root;
		boolean added = false;

		while (!added) {

			if (n.getKey().compareTo(tmp.getKey()) > 0) {

				if (tmp.getRight() != null) {

					tmp = tmp.getRight();
				} else {

					tmp.setRight(n);
					n.setParent(tmp);
					added = true;
				}

			} else {

				if (tmp.getLeft() != null) {

					tmp = tmp.getLeft();
				} else {

					tmp.setLeft(n);
					n.setParent(tmp);
					added = true;
				}
			}
		}
		return added;
	}

	public void deleteFromKey(K key) {

		delete(key, root);
	}

	@Override
	public Node<K, E> delete(K key, Node<K, E> n) {

		if (root == null) {

			return root;
		}

		if (key.compareTo(root.getKey()) < 0) {

			root.left = delete(key, root.left);
		} else if (key.compareTo(root.getKey()) > 0) {

			root.right = delete(key, root.right);
		} else {

			if (root.left == null && n.right == null) {

			} else if (root.left == null) {

				return n.right;
			} else if (n.right == null) {

				return n.left;
			} else {

				n.setKey(minValue(n));
				n.right = delete(n.getKey(), n.right);
			}
		}

		return root;
	}

	public K minValue(Node<K, E> n) {
		K minv = n.getKey();
		while (n.left != null) {
			minv = n.left.getKey();
			n = n.left;
		}
		return minv;
	}

	@Override
	public E search(K key) {

		Node<K, E> n = searchA(key);
		if (n != null) {
			return n.getType();
		} else {
			return null;
		}
	}

	public Node<K, E> searchA(K key) {

		Node<K, E> tmp = root;

		while (tmp != null && !tmp.getKey().equals(key)) {

			if (key.compareTo(tmp.getKey()) < 0) {

				tmp = tmp.getLeft();
			} else {
				tmp = tmp.getRight();
			}
		}
		return tmp;
	}

	@Override
	public void update(K key, E element, K newKey) {

		Node<K, E> n = searchA(key);
		n.setType(element);
		n.setKey(newKey);
	}
}
