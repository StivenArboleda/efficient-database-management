package dataStructure;

public interface IABB<K extends Comparable<K>, E> {
  
	public Node<K, E> succesor(Node<K, E> x);
	public Node<K, E> maximun();
	public Node<K, E> maximun(Node<K, E> x);
	public Node<K, E> minimun();
	public Node<K, E> minimun(Node<K, E> x);
	public Node<K, E> delete(Node<K, E> z);
	void insert(Node<K, E> z);
	public Node<K, E> search(K key);
	public Node<K, E> search(Node<K, E> x, K key);
}