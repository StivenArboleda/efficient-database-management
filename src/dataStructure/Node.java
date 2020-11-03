package dataStructure;

public class Node<K extends Comparable<K>, E> {
    
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

	
}
