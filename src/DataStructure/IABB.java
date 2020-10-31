package DataStructure;

public interface IABB<K extends Comparable<K>, E> {
  
    public boolean  insert( K key, E element);
    public Node<K, E>  delete(K key, Node<K, E> n);
    public E search(K key);
    public void update(K key, E element, K newKey);
}