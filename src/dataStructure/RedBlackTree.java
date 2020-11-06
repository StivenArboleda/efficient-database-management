package dataStructure;

public class RedBlackTree<K extends Comparable<K>, E> extends ABB<K, E> implements IRedBlackTree<K, E> {

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

			int cmp = value.compareTo(nodeT.getValue());

			if (cmp < 0) {
				nodeT = nodeT.getLeft();
			}
			else if (cmp > 0) {
				nodeT = nodeT.getRight();
			}
			else {
				return true;
			}
		}

		return false;
	}
	
	public boolean insertRD(K key, E element) {
		
	    if (key == null) {
	      throw new IllegalArgumentException("Red-Black tree does not allow null values.");
	    }
	    super.insert(key, element);
	    
	    Node<K,E> x = root, y = node;

	    while (x != node) {
	      y = x;

	      if (x.getValue().compareTo(key) > 0) {
	        x = x.getLeft();
	      } else if (x.getValue().compareTo(key) < 0) {
	        x = x.getRight();
	      } else {
	        return false;
	      }
	    }

	    Node<K,E> z = new Node<>(key, element, Node.RED, y, node, node);

	    if (y == node) {
	      root = z;
	    } else if (z.getValue().compareTo(y.getValue()) < 0) {
	      y.setLeft(z);
	    } else {
	      y.setRight(z);
	    }
	    insertRB(z);

	    nodeCount++;
	    return true;
	  }

	  private void insertRB(Node<K,E> z) {
	    Node<K,E> y;
	    while (z.getParent().getColor() == Node.RED) {
	      if (z.getParent() == z.getParent().getParent().getLeft()){
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
		Node<K, E> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != node) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == node) {
			root = y;

		}
		if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}

	private void rightRotate(Node<K, E> y) {
		Node<K, E> x = y.getLeft();
		y.setLeft(x.getRight());
		if (x.getRight() != node)
			x.getRight().setParent(y);
		x.setParent(y.getParent());
		if (y.getParent() == node)
			root = x;
		if (y == y.getParent().getLeft()) {
			y.getParent().setLeft(x);
		} else {
			y.getParent().setRight(x);
		}
		x.setRight(y);
		y.setParent(x);
	}
	
	public boolean deleteRB(K key) {
		
		Node<K, E> z = super.search(key);

		if (key == null || z == node) {
			return false;
		}

		Node<K, E> toDelete;
		Node<K, E> y = z;
		boolean colorSave = y.getColor();

		if (z.getLeft() == node) {
			toDelete = z.getRight();
			transplant(z, z.getRight());

		} else if (z.getRight() == node) {
			toDelete = z.getLeft();
			transplant(z, z.getLeft());

		} else {
			y = successor(z.getRight());
			colorSave = y.getColor();
			toDelete = y.getRight();

			if (y.getParent() == z) {
				toDelete.setParent(y);

			} else {
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(z.getColor());

		}
		if (colorSave == Node.BLACK) {
			deleteBalance(toDelete);
		}
		nodeCount--;
		return true;
	}
	
	private void deleteBalance(Node<K, E> toDelete) {

		while (toDelete != root && toDelete.getColor() == Node.BLACK) {

			if (toDelete == toDelete.getParent().getLeft()) {
				Node<K, E> w = toDelete.getParent().getRight();
				if (w.getColor() == Node.RED) {
					w.setColor(Node.BLACK);
					toDelete.getParent().setColor(Node.RED);
					leftRotate(toDelete.getParent());
					w = toDelete.getParent().getRight();
				}
				if (w.getLeft().getColor() == Node.BLACK && w.getRight().getColor() == Node.BLACK) {
					w.setColor(Node.RED);
					toDelete = toDelete.getParent();
					continue;
				} else if (w.getRight().getColor() == Node.BLACK) {
					w.getLeft().setColor(Node.BLACK);
					w.setColor(Node.RED);
					rightRotate(w);
					w = toDelete.getParent().getRight();
				}
				if (w.getRight().getColor() == Node.RED) {
					w.setColor(toDelete.getParent().getColor());
					toDelete.getParent().setColor(Node.BLACK);
					w.getRight().setColor(Node.BLACK);
					leftRotate(toDelete.getParent());
					toDelete = root;
				}
			} else {
				Node<K, E> w = (toDelete.getParent().getLeft());
				if (w.getColor() == Node.RED) {
					w.setColor(Node.BLACK);
					toDelete.getParent().setColor(Node.RED);
					rightRotate(toDelete.getParent());
					w = (toDelete.getParent()).getLeft();
				}
				if (w.getRight().getColor() == Node.BLACK && w.getLeft().getColor() == Node.BLACK) {
					w.setColor(Node.RED);
					toDelete = toDelete.getParent();
					continue;
				} else if (w.getLeft().getColor() == Node.BLACK) {
					w.getRight().setColor(Node.BLACK);
					w.setColor(Node.RED);
					leftRotate(w);
					w = (toDelete.getParent().getLeft());
				}
				if (w.getLeft().getColor() == Node.RED) {
					w.setColor(toDelete.getParent().getColor());
					toDelete.getParent().setColor(Node.BLACK);
					w.getLeft().setColor(Node.BLACK);
					rightRotate(toDelete.getParent());
					toDelete = root;
				}
			}
		}
		toDelete.setColor(Node.BLACK);
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

	private void transplant(Node<K, E> u, Node<K, E> v) {
		if (u.getParent() == node) {
			root = v;
		} else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		} else
			u.getParent().setRight(v);
		v.setParent(u.getParent());
	}
	
	//NO SON USADOS
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
