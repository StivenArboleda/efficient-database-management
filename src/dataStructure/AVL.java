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

	@Override
	public void leftRotate(Node<K, E> toRotate) {//pregunta caso A y B y casos D y E se ejecutan igual solo rotate correspondiente?
		Node<K, E> right = toRotate.getRight();
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
		toRotate.setRight(right.getLeft());
		right.getLeft().setParent(toRotate);
		right.setLeft(toRotate);
		toRotate.setParent(right);
	}

	@Override
	public void rightRotate(Node<K, E> toRotate) {// pregunta, para hacer la herencia como manejamos, protected, y la clase nodo solo sera una? siempre tendra factor de bala
		Node<K, E> left = toRotate.getLeft();
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
		toRotate.setLeft(left.getRight());
		left.getRight().setParent(toRotate);
		left.setRight(toRotate);
		toRotate.setParent(left);
	}

	@Override
	public void insert(K key, E element) {
		Node<K, E> x = new Node<>(key, element);
		super.insert(x);
		x.setFb(0);
		rebalance(x);
		recalculate(x);
	}
	
	@Override
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
	
	@Override
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
	
	@Override
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

	

}