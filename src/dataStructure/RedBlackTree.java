package dataStructure;

public class RedBlackTree<K extends Comparable<K>, E> extends ABB<K, E> {

	
	private static final long serialVersionUID = 1L;


	public NodeRBTree<K, E> root;

	private int nodeCount = 0;

	
	public NodeRBTree<K, E> node;

	public RedBlackTree() {
		node = new NodeRBTree<>(NodeRBTree.BLACK, null);
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

		NodeRBTree<K, E> nodeT = root;

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
		NodeRBTree<K, E> y = node;
		NodeRBTree<K,E> z = new NodeRBTree<>(key, NodeRBTree.RED, y, node, node);
		super.insert(key, elem);
		insert(z);
		nodeCount++;
	}

	private void insert(NodeRBTree<K, E> z) {
		NodeRBTree<K,E> y = null;
		while (z.getParent().getColor() == NodeRBTree.RED) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				if (y.getColor() == NodeRBTree.RED) {
					z.getParent().setColor(NodeRBTree.BLACK);
					y.setColor(NodeRBTree.BLACK);
					z.getParent().getParent().setColor(NodeRBTree.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						leftRotate(z);
					}
					z.getParent().setColor(NodeRBTree.BLACK);
					z.getParent().getParent().setColor(NodeRBTree.RED);
					rightRotate(z.getParent().getParent());
				}
			} else {
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == NodeRBTree.RED) {
					z.getParent().setColor(NodeRBTree.BLACK);
					y.setColor(NodeRBTree.BLACK);
					z.getParent().getParent().setColor(NodeRBTree.RED);
					z = z.getParent().getParent();
				} else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						rightRotate(z);
					}
					z.getParent().setColor(NodeRBTree.BLACK);
					z.getParent().getParent().setColor(NodeRBTree.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor(NodeRBTree.BLACK);
		node.setParent(null);
	}

	private void leftRotate(NodeRBTree<K, E> x) {
		NodeRBTree<K,E> y = x.getRight();
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

	private void rightRotate(NodeRBTree<K,E> y) {
		NodeRBTree<K,E> x = y.getLeft();
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
	
	public  Node<K, E> delete(K key) {
		return super.delete(key);
		
//		NodeRBTree z;
//		if (key == null || (z = (search(key, root))) == node)
//			return false;
//		NodeRBTree x;
//		NodeRBTree y = z; // temporary reference y
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
//		if (y_original_color == NodeRBTree.BLACK)
//			deleteFix(x);
//		nodeCount--;
//		return true;
		
	}

	private void delete(NodeRBTree<K, E> x) {
		
		while (x != root && x.getColor() == NodeRBTree.BLACK) {
			
			if (x == x.getParent().getLeft()) {
				NodeRBTree<K, E> w = x.getParent().getRight();
				if (w.getColor() == NodeRBTree.RED) {
					w.setColor(NodeRBTree.BLACK);
					x.getParent().setColor(NodeRBTree.RED);
					leftRotate(x.getParent());
					w = x.getParent().getRight();
				}
				if (w.getLeft().getColor() == NodeRBTree.BLACK && w.getRight().getColor() == NodeRBTree.BLACK) {
					w.setColor(NodeRBTree.RED);
					x = x.getParent();
					continue;
				} else if (w.getRight().getColor() == NodeRBTree.BLACK) {
					w.getLeft().setColor(NodeRBTree.BLACK);
					w.setColor(NodeRBTree.RED);
					rightRotate(w);
					w = x.getParent().getRight();
				}
				if (w.getRight().getColor() == NodeRBTree.RED) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(NodeRBTree.BLACK);
					w.getRight().setColor(NodeRBTree.BLACK);
					leftRotate(x.getParent());
					x = root;
				}
			} else {
				NodeRBTree<K, E> w = (x.getParent().getLeft());
				if (w.getColor() == NodeRBTree.RED) {
					w.setColor(NodeRBTree.BLACK);
					x.getParent().setColor(NodeRBTree.RED);
					rightRotate(x.getParent());
					w = (x.getParent()).getLeft();
				}
				if (w.getRight().getColor() == NodeRBTree.BLACK && w.getLeft().getColor() == NodeRBTree.BLACK) {
					w.setColor(NodeRBTree.RED);
					x = x.getParent();
					continue;  //PA QUE ES?
				} else if (w.getLeft().getColor() == NodeRBTree.BLACK) {
					w.getRight().setColor(NodeRBTree.BLACK);
					w.setColor(NodeRBTree.RED);
					leftRotate(w);
					w = (x.getParent().getLeft());
				}
				if (w.getLeft().getColor() == NodeRBTree.RED) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(NodeRBTree.BLACK);
					w.getLeft().setColor(NodeRBTree.BLACK);
					rightRotate(x.getParent());
					x = root;
				}
			}
		}
		x.setColor(NodeRBTree.BLACK);
	}

	private NodeRBTree<K, E> successor(NodeRBTree<K, E> root) {
		if (root == node || root.getLeft() == node)
			return root;
		else
			return successor(root.getLeft());
	}


	public int height() {
		return height(root);
	}

	private int height(NodeRBTree<K, E> curr) {
		
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
//	private void transplant(NodeRBTree<K, E> u, NodeRBTree<K, E> v) {
//		if (u.getParent() == node) {
//			root = v;
//		} else if (u == u.getParent().getLeft()) {
//			u.getParent().setLeft(v);
//		} else
//			u.getParent().setRight(v);
//		v.setParent(u.getParent());
//	}
//	
//	private void swapColors(NodeRBTree<K,E> a, NodeRBTree<K,E> b) {
//		boolean tmpColor = a.getColor();
//		a.setColor(b.getColor());
//		b.setColor(tmpColor);
//	}
//
//	private void updateParentChildLink(NodeRBTree<K,E> parent, NodeRBTree<K,E> oldChild, NodeRBTree<K,E> newChild) {
//		if (parent != node) {
//			if (parent.getLeft() == oldChild) {
//				parent.setLeft(newChild);
//			} else {
//				parent.setRight(newChild);
//			}
//		}
//	}
//
//	private NodeRBTree<K,E> findMin(NodeRBTree<K,E> node) {
//		while (node.getLeft() != node)
//			node = node.getLeft();
//		return node;
//	}
//
//	private NodeRBTree<K,E> findMax(NodeRBTree<K,E> node) {
//		while (node.getRight() != node)
//			node = node.getRight();
//		return node;
//	}

}
