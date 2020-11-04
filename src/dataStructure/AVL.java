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
//______________________________________________________________________________________________________	
//______________________________________________________________________________________________________
//______________________________________________________________________________________________________	
//______________________________________________________________________________________________________		
	
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
	public Node<K, E> delete(K key) {// estoy casi seguro que este no sirve
//		Borrar k del arbol como en un ABB
//		Sea y el primer nodo posiblemente desbalanceado CUAL SERIA
//		AVL-Rebalance(y)
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
	
//______________________________________________________________________________________________________	
//______________________________________________________________________________________________________
//______________________________________________________________________________________________________	
//______________________________________________________________________________________________________	
	

/*	//---------------------------------- NUEVO INTENTO ------------------------------------------
	public int returnHeight(Node<K, E> node) {
        int height = 0;
        height = returnHeight(node, 1, height);
        node.setHeight(height);
       
        return height;
        
    }

    private int returnHeight(Node<K, E> node, int nivel, int height) {
        if (node != null) {
            height = returnHeight(node.getLeft(), nivel + 1, height);
            if (nivel > height) {
                height = nivel;
            }
            height = returnHeight(node.getRight(), nivel + 1, height);
        }
        return height;
    }

	
	public void leftRotate(Node<K, E> toRotate) {
		Node<K, E> right = toRotate.getRight();
		if (toRotate != null) {
			if (right != null) {
				right.setParent(toRotate.getParent());
				if (toRotate.getParent() != null) {
					if (toRotate == toRotate.getParent().getRight()) {
						toRotate.getParent().setRight(right);
					} else {
						toRotate.getParent().setLeft(right);
					}
				} else {
					super.setRoot(right);
				}
				if (right.getLeft() != null) {
					toRotate.setParent(right.getLeft());
					right.getLeft().setParent(toRotate);
				}
				right.setLeft(toRotate);
				toRotate.setParent(right);
			}
		}
	}

	
	public void rightRotate(Node<K, E> toRotate) {
		Node<K, E> left = toRotate.getLeft();
		if (toRotate != null) {
			if (left != null) {
				left.setParent(toRotate.getParent());
				if (toRotate.getParent() != null) {
					if (toRotate == toRotate.getParent().getRight()) {
						toRotate.getParent().setRight(left);
					} else {
						toRotate.getParent().setLeft(left);
					}
				} else {
					super.setRoot(left);
				}
				if (left.getRight() != null) {
					toRotate.setLeft(left.getRight());
					left.getRight().setParent(toRotate);
				}
				left.setRight(toRotate);
				toRotate.setParent(left);
			}
		}
	}
	
	public boolean verifyBalance(int r, int l) {
		boolean balance = true;
		if (r - l > 1 || r - l < -1) {
			balance = false;
		}
		return balance;
	}
	
	public void balanceIt(Node<K, E> x) {
		int r = returnHeight(x.getRight());
		int l = returnHeight(x.getLeft());
		 
		boolean balan = verifyBalance(r, l);
		if (!balan) {
			if (r - l > 1) {
				if (balan) {
					
				}
			} 
		}
	}
	
	//---------------------------------- NUEVO INTENTO ------------------------------------------

	
	
	
	
	public void recalculate(Node<K, E> x) {
		Node<K, E> current = x.getParent();
		while (current != null) {
			if (current.getLeft() == x) {
				current.decreaseFb();
			}else {
				current.incrementFb();
			}
			if (Math.abs(current.getFb()) > 1) {
				rebalance(current);
			}
			current = current.getParent();
			
		}
	}
	
	
	public void rebalance(Node<K, E> x) {
		
		while (x != null) {
			
			if ( x.getFb() > 1 ) {
				if ( x.getRight().getFb() == 1 ) {// A
					leftRotate(x);
					x.setFb(0);
					x.getParent().setFb(0);
				} else if ( x.getRight().getFb() == 0 ) {// B
					leftRotate(x);
					x.setFb(1);
					x.getParent().setFb(-1);
				} else {// C
					rightRotate(x.getRight());
					leftRotate(x);
					x.setFb(0/1);
					x.getParent().setFb(0);
					x.getParent().getLeft().setFb(-1 / 0);
				}
			} else if (x.getFb() < -1) {
				if ( x.getLeft().getFb() == -1 ) {// D
					rightRotate(x);
					x.setFb(0);
					x.getParent().setFb(0);
				} else if (x.getLeft().getFb() == 0 ) {// E
					rightRotate(x);
					x.setFb(-1);
					x.getParent().setFb(1);
				} else {// F
					leftRotate(x.getLeft());
					rightRotate(x);
					
					//x.setFb(-1 / 0);
					x.getParent().setFb(0);
					//x.getParent().getRight().setFb(0 / 1);
				}
			}
			x = x.getParent();
		}
	}
	
	
	public void recalculate(Node<K, E> x, boolean left) {
		Node<K, E> current = x.getParent();
		while (current != null) {
			if (left) {
				if (current.getRight() != null) {
					if (current.getLeft() != null) {
//						current.setHeight(Math.max(current.getRight().getHeight(), current.getLeft().getHeight()) + 1);
					} else {
//						current.setHeight(current.getRight().getHeight() + 1);
					}
				} else {
					if (current.getLeft() != null) {
//						current.setHeight(current.getLeft().getHeight() + 1);
					} else {
//						current.setHeight(0);
					}
				}
				//actualizar alturas
				//restar derecho menos izquierdo
				//si esa resta es 0 salgo de while
				//y el fb en del papa sera 0
				// si da 2 o -2 llamo rebalancear
				current.incrementFb();
			} else {
				current.decreaseFb();
			}
			
			current = current.getParent();
		}
	}

	public void deleted(K key) {
		Node<K, E> x = super.search(key);
		Node<K, E> f = x.getParent();
		boolean left = false;
		if (x == f.getLeft()) {
			left = true;
		}
		super.delete(x);
		x.setFb(0);
		recalculate(f, left);
		rebalance(x);
	}
	
//--------------------------------------------------------
//--------------------------------------------------------
//--------------------------------------------------------

	public void rightCases(Node<K,E> nodeR) {
		if (nodeR != null) {
			int balanceF = balanceFactor(nodeR);
			if(balanceF == 1 || balanceF == 0) {
				leftRotate(nodeR.getParent());
			}else {
				Node<K, E> parent = nodeR.getParent();
				rightRotate(nodeR.getParent());
				leftRotate(parent);
			}
		}
	}
	
	public void leftCases(Node<K, E> nodeL) {
		int balanceF = balanceFactor(nodeL);
		
		if(balanceF == -1 || balanceF == 0) {
			leftRotate(nodeL.getParent());
		}else {
			Node<K, E> parent = nodeL.getParent();
			leftRotate(nodeL);
			rightRotate(parent);
		}
	}
	
	public int balanceFactor (Node<K,E> node) {
		if(node!=null) {
			int right = node.getRight().getHeight();
			int left = node.getLeft().getHeight();
			return right - left;
		}
		return 0;
	}
	
	public void balance(Node<K,E> node) {
		if(node!=null) {
			int balanceFactor = balanceFactor(node);
			Node<K,E> parent = node.getParent();
			if(balanceFactor>1) {
				rightCases(node.getRight());
				
			}else if(balanceFactor<-1) {
				leftCases(node.getLeft());
				
			}
			balance(parent);
		}
	}*/



}