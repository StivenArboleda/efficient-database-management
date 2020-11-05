package dataStructure;

public class RedBlackTree<K extends Comparable<K>, E> extends ABB<K, E> {

	
	private static final long serialVersionUID = 1L;


	public Node<K, E> root;

	private int nodeCount = 0;

	
	public Node<K, E> node;

	public RedBlackTree() {
		node = new Node<>(Node.BLACK, null);
		node.setLeft(node);
		node.setRight(node);
		node.setParent(node);

		root = node;
	}
	
	public int size() {
		return nodeCount;
	}
	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(K value) {

		Node<K, E> nodeT = root;

		if (nodeT == null || value == null) {
			return false;
		}
		while (nodeT != node) {

			// Compare current value to the value in the node.
			int cmp = value.compareTo(nodeT.getValue());

			// Dig into left subtree.
			if (cmp < 0) {
				nodeT = nodeT.getLeft();
			}
			// Dig into right subtree.
			else if (cmp > 0) {
				nodeT = nodeT.getRight();
			}
			// Found value in tree.
			else {
				return true;
			}
		}

		return false;
	}

	public void insert(K key, E elem) {
		Node<K, E> y = node;
		Node<K,E> z = new Node<>(key, Node.RED, y, node, node);
		super.insert(key, elem);
		insert(z);
		nodeCount++;
	}

	public void insert(Node<K, E> z) {
		Node<K,E> y = null;
		while (z.getParent().getColor() == Node.RED) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				if (y.getColor() == Node.RED) {
					z.getParent().setColor(Node.BLACK);
					y.setColor(Node.BLACK);
					z.getParent().getParent().setColor(Node.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						leftRotate(z);
					}
					z.getParent().setColor(Node.BLACK);
					z.getParent().getParent().setColor(Node.RED);
					rightRotate(z.getParent().getParent());
				}
			} else {
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == Node.RED) {
					z.getParent().setColor(Node.BLACK);
					y.setColor(Node.BLACK);
					z.getParent().getParent().setColor(Node.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						rightRotate(z);
					}
					z.getParent().setColor(Node.BLACK);
					z.getParent().getParent().setColor(Node.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor(Node.BLACK);
		node.setParent(null);
	}

	private void leftRotate(Node<K, E> x) {
		Node<K,E> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != node) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == node) {
			root = y;
		
		}if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}

	private void rightRotate(Node<K,E> y) {
		Node<K,E> x = y.getLeft();
		y.setLeft(x.getRight());
		if (x.getRight() != node)
			x.getRight().setParent(y);
		x.setParent(y.getParent());
		if (y.getParent() == node)
			root = x;
		if (y == y.getParent().getLeft()) {
			y.getParent().setLeft(x);	
		}
		else {
			y.getParent().setRight(x);
		}
		x.setRight(y);
		y.setParent(x);
	}
	
	//return boolean
	
	public Node<K,E> delete(K key) {
		boolean r = false;
		Node<K,E> dele = super.search(key);
		Node<K,E> x = null;
		if(dele != null) {
			//aqui se asigna la x
		}
		
		Node<K,E> deleted = super.delete(key);
		if(dele.getColor() == false) {
			delete(dele);
		}
		nodeCount--;
		return deleted;

//		Node z;
//		if (key == null || (z = (search(key, root))) == node)
//			return false;
//		Node x;
//		Node y = z; // temporary reference y
//		boolean y_original_color = y.getColor();
//
//		if (z.getLeft() == node) {
//			x = z.getRight();
//			transplant(z, z.getRight());
//		} else if (z.getRight() == node) {
//			x = z.getLeft();
//			transplant(z, z.getLeft());
//		} else {
//			y = successor(z.getRight());
//			y_original_color = y.getColor();
//			x = y.getRight();
//			if (y.getParent() == z)
//				x.setParent(y);
//			else {
//				transplant(y, y.getRight());
//				y.setRight(z.getRight());
//				y.getRight().setParent(y);
//			}
//			transplant(z, y);
//			y.setLeft(z.getLeft());
//			y.getLeft().setParent(y);
//			y.setColor(z.getColor());
//		}
//		if (y_original_color == Node.BLACK)
//			deleteFix(x);
//		nodeCount--;
//		return true;
		
	}

	private void delete(Node<K, E> x) {
		
		while (x != root && x.getColor() == Node.BLACK) {
			
			if (x == x.getParent().getLeft()) {
				Node<K, E> w = x.getParent().getRight();
				if (w.getColor() == Node.RED) {
					w.setColor(Node.BLACK);
					x.getParent().setColor(Node.RED);
					leftRotate(x.getParent());
					w = x.getParent().getRight();
				}
				if (w.getLeft().getColor() == Node.BLACK && w.getRight().getColor() == Node.BLACK) {
					w.setColor(Node.RED);
					x = x.getParent();
					continue;
				} else if (w.getRight().getColor() == Node.BLACK) {
					w.getLeft().setColor(Node.BLACK);
					w.setColor(Node.RED);
					rightRotate(w);
					w = x.getParent().getRight();
				}
				if (w.getRight().getColor() == Node.RED) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Node.BLACK);
					w.getRight().setColor(Node.BLACK);
					leftRotate(x.getParent());
					x = root;
				}
			} else {
				Node<K, E> w = (x.getParent().getLeft());
				if (w.getColor() == Node.RED) {
					w.setColor(Node.BLACK);
					x.getParent().setColor(Node.RED);
					rightRotate(x.getParent());
					w = (x.getParent()).getLeft();
				}
				if (w.getRight().getColor() == Node.BLACK && w.getLeft().getColor() == Node.BLACK) {
					w.setColor(Node.RED);
					x = x.getParent();
					continue;  
				} else if (w.getLeft().getColor() == Node.BLACK) {
					w.getRight().setColor(Node.BLACK);
					w.setColor(Node.RED);
					leftRotate(w);
					w = (x.getParent().getLeft());
				}
				if (w.getLeft().getColor() == Node.RED) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Node.BLACK);
					w.getLeft().setColor(Node.BLACK);
					rightRotate(x.getParent());
					x = root;
				}
			}
		}
		x.setColor(Node.BLACK);
	}

	private Node<K, E> successor(Node<K, E> root) {
		if (root == node || root.getLeft() == node)
			return root;
		else
			return successor(root.getLeft());
	}


	public int height() {
		return height(root);
	}

	private int height(Node<K, E> curr) {
		
		if (curr == node) {
			return 0;
		}
		if (curr.getLeft() == node && curr.getRight() == node) {
			return 1;
		}
		return 1 + Math.max(height(curr.getLeft()), height(curr.getRight()));
	}

	//NO SON USADOS
	
	
//
//	private void transplant(Node<K, E> u, Node<K, E> v) {
//		if (u.getParent() == node) {
//			root = v;
//		} else if (u == u.getParent().getLeft()) {
//			u.getParent().setLeft(v);
//		} else
//			u.getParent().setRight(v);
//		v.setParent(u.getParent());
//	}
//	
//	private void swapColors(Node<K,E> a, Node<K,E> b) {
//		boolean tmpColor = a.getColor();
//		a.setColor(b.getColor());
//		b.setColor(tmpColor);
//	}
//
//	private void updateParentChildLink(Node<K,E> parent, Node<K,E> oldChild, Node<K,E> newChild) {
//		if (parent != node) {
//			if (parent.getLeft() == oldChild) {
//				parent.setLeft(newChild);
//			} else {
//				parent.setRight(newChild);
//			}
//		}
//	}
//
//	private Node<K,E> findMin(Node<K,E> node) {
//		while (node.getLeft() != node)
//			node = node.getLeft();
//		return node;
//	}
//
//	private Node<K,E> findMax(Node<K,E> node) {
//		while (node.getRight() != node)
//			node = node.getRight();
//		return node;
//	}

}
