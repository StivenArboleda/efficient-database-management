package DataStructure;

import java.io.Serializable;

public class AVL<K extends Comparable<K>, E> extends ABB<K, E> implements IAVL<K, E>, Serializable {

//------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -537623718932409550L;

	private void balance(K key) {

		Node<K, E> n = super.search(key);
		boolean isBalanced = false;

		Node<K, E> n1 = n.getParent();

		while (!isBalanced && n1 != null) {

			if (n != n1.getLeft()) {

				if (n1.getBalance() == 1) {

					n1.setBalance(0);
					isBalanced = true;
				}
				n1.setBalance(-1);

				if (n1.getBalance() == -1) {

					if (n.getBalance() == 1) {
						rotateRight(n);
					}
					rotateLeft(n1);
					isBalanced = true;
				}

			} else {

				if (n1.getBalance() == -1) {

					n1.setBalance(0);
					isBalanced = true;
				}
				n1.setBalance(0);

				if (n1.getBalance() == 1) {

					if (n.getBalance() == 1) {

						rotateLeft(n);
					}
					rotateRight(n1);
					isBalanced = true;
				}
			}
		}
	}

	@Override
	public void insert(K key, E element) {
		Node<K, E> n = new Node<>(key, element);
		super.insert(n);
		balance(key);	
	}

	@Override
	public void update(K key, E element, K newKey) {

		super.update(key, element, newKey);
	}

	public int getBalance(Node<K, E> n) {
		if (n == null)
			return 0;
		return height(n.getLeft()) - height(n.getRight());
	}

	@Override
	public Node<K, E> deleteAVL(Node<K, E> root, K key) {

		if (root == null) {
			return root;

		}
		if (key.compareTo(root.getKey()) < 0) {
			root.setLeft(deleteAVL(root.getLeft(), key));

		} else if (key.compareTo(root.getKey()) > 0) {
			root.setRight(deleteAVL(root.getRight(), key));

		} else {

			if ((root.getLeft() == null) || (root.getRight() == null)) {

				Node<K, E> temp = null;

				if (temp == root.getLeft()) {
					temp = root.getRight();

				} else {
					temp = root.getLeft();
				}

				if (temp == null) {

					temp = root;
					root = null;
				} else {
					root = temp;
				}
			} else {

				Node<K, E> temp = minValueAVL(root.getRight());

				root.setKey(temp.getKey());

				root.setRight(deleteAVL(root.getRight(), temp.getKey()));
			}
		}

		if (root == null) {
			return root;
		}

		root.setBalance(max(height(root.getLeft()), height(root.getRight())) + 1);

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.getLeft()) >= 0) {
			return rightRotate(root);

		}
		if (balance > 1 && getBalance(root.getLeft()) < 0) { // izquierda derecha
			root.setLeft(leftRotate(root.getLeft()));
			return rightRotate(root);

		}
		if (balance < -1 && getBalance(root.getRight()) <= 0) { // derecha derecha
			return leftRotate(root);

		}
		if (balance < -1 && getBalance(root.getRight()) > 0) { // derecha izquierda

			root.setRight(rightRotate(root.getRight()));
			return leftRotate(root);
		}

		return root;

	}



	public Node<K, E> minValueAVL(Node<K, E> node) {

		Node<K, E> current = node;

		while (current.getLeft() != null)
			current = current.getLeft();

		return current;
	}




	@Override
	public Node<K, E> search(K key) {

		return super.search(key);
	}

	public E maximum() {

		Node<K, E> tmp = super.getRoot();
		if (tmp == null) {

			return null;
		}
		while (tmp.getRight() != null) {

			tmp = tmp.getRight();
		}

		return (E) tmp.getType();
	}

	public E minimum() {

		Node<K, E> tmp = super.getRoot();
		if (tmp == null) {

			return null;
		}
		while (tmp.getLeft() != null) {

			tmp = tmp.getLeft();
		}

		return (E) tmp.getType();
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public int height(Node<K, E> n) {
		if (n == null)
			return 0;
		return n.getBalance();
	}
	
	//////////////////ROTACIONES
	
	

	
	public void rotateRight(K key) {

		Node<K, E> n = super.search(key);
		rotateRight(n);
	}
	
	private void rotateRight(Node<K, E> n1) {

		Node<K, E> n2 = n1.getLeft();
		n1.setLeft(n1.getRight());
		if (n2.getRight() != null) {

			n2.getRight().setParent(n1);
		}

		n2.setParent(n1.getParent());
		if (n1.getParent() == null) {

			super.setRoot(n2);
		} else if (n1 == n1.getParent().getRight()) {

			n1.getParent().setRight(n2);
		} else {

			n1.getParent().setLeft(n2);
		}
		n2.setParent(n1);
		n1.setParent(n2);
	}
	
	private Node<K, E> rightRotate(Node<K, E> y) {
		Node<K, E> x = y.getLeft();
		Node<K, E> t2 = x.getRight();

		x.setRight(y);
		y.setLeft(t2);

		y.setBalance(max(height(y.getLeft()), height(y.getRight())) + 1);
		x.setBalance(max(height(x.getLeft()), height(x.getRight())) + 1);

		return x;
	}
	
	@Override
	public void rotateLeft(K key) {

		Node<K, E> n = search(key);
		rotateLeft(n);
	}

	private void rotateLeft(Node<K, E> n1) {

		Node<K, E> n2 = n1.getRight();
		n1.setRight(n1.getLeft());
		if (n2.getLeft() != null) {

			n2.getLeft().setParent(n1);
		}

		n2.setParent(n1.getParent());
		if (n1.getParent() == null) {

			super.setRoot(n2);
		} else if (n1 == n1.getParent().getLeft()) {

			n1.getParent().setLeft(n2);
		} else {

			n1.getParent().setRight(n2);
		}
		n2.setParent(n1);
		n1.setParent(n2);
	}
	
	private Node<K, E> leftRotate(Node<K, E> x) {
		Node<K, E> y = x.getRight();
		Node<K, E> t2 = y.getLeft();

		y.setLeft(x);
		x.setRight(t2);

		x.setBalance(max(height(x.getLeft()), height(x.getRight())) + 1);
		y.setBalance(max(height(y.getLeft()), height(y.getRight())) + 1);

		return y;
	}
	
}