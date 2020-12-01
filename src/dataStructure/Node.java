package dataStructure;

import java.io.Serializable;

public class Node<K extends Comparable<K>, E> implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private E element;
    private K key;
    private  Node<K, E> left;
    private  Node<K, E> right;
    private  Node<K, E> parent;
    private int fb;
    private int height;
    

    public Node(K key, E element) {
        this.element = element;
        this.key = key;
        fb = 0;

    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }
    
    public Node<K, E> getParent() {
        return parent;
    }

    public void setParent(Node<K, E> parent) {
        this.parent = parent;
    }
    
    
    public E getElement() {
        return element;
    }

    public void setElement(E type) {
        this.element = type;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, E> getLeft() {
        return left;
    }

    public void setLeft(Node<K, E> left) {
        this.left = left;
    }

    public Node<K, E> getRight() {
        return right;
    }

    public void setRight(Node<K, E> right) {
        this.right = right;
    }

	public void decreaseFb() {
		// TODO Auto-generated method stub
		
	}

	public void incrementFb() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	//-----------------------------------------------
	//----------------  REDBLACK --------------------
	
	public static final boolean RED = true;
	public static final boolean BLACK = false;


	private boolean color = RED;
	public K value;

	public Node(K value, Node<K, E> parent) {
		this.value = value;
		this.parent = parent;
	}

	public Node(boolean color, K value) {
		this.color = color;
		this.value = value;
	}

	public Node(K key, E element, boolean color, Node<K,E> parent, Node<K,E> left, Node<K,E> right) {
		this.value = key;
		this.color = color;
		this.element = element;

		if (parent == null && left == null && right == null) {
			parent = this;
			left = this;
			right = this;
		}

		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public K getValue() {
		return value;
	}

	public void setValue(K value) {
		this.value = value;
	}
	
}
