package dataStructure;

public class Node<K extends Comparable<K>, E> {
    
    private E type;
    private K key;
    private  Node<K, E> left;
    private  Node<K, E> right;
    private  Node<K, E> parent;
    private int fb;

    public Node(K key, E type) {
        this.type = type;
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
    
    
    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
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
}
