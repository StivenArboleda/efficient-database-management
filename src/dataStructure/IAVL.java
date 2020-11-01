package dataStructure;

public interface IAVL<K extends Comparable<K>, E> {
	
    public void insert(K key, E element);
   
    public void update(K key, E element, K newKey);
    public Node<K, E> search(K key);
   
    public void recalculate(Node<K, E> x);
	public void rebalance(Node<K, E> x);
	public void recalculate(Node<K, E> x, boolean left);
	public void rightRotate(Node<K, E> toRotate);
	public void leftRotate(Node<K, E> toRotate);
}
