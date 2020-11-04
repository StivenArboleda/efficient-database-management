package dataStructure;

public interface IAVL<K extends Comparable<K>, E> {
	
	public void update(Node<K, E> node);
	public Node<K, E> balance(Node<K, E> node);
	public Node<K, E> rightRotation(Node<K, E> node);
	public Node<K, E> leftRotation(Node<K, E> node);
	public void insert(K key, E element);
	public Node<K, E> delete(K key);
}
