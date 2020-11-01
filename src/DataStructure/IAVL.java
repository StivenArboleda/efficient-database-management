package DataStructure;

public interface IAVL<K extends Comparable<K>, E> {
	
    public void insert(K key, E element);
    public Node<K,E> deleteAVL(Node<K,E> n, K key);
    public void update(K key, E element, K newKey);
    public Node<K, E> search(K key);
    public void rotateLeft(K key);
    public void rotateRight(K key);
}
