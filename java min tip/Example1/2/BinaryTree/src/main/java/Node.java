import java.util.List;

public abstract class Node<T, K> implements Comparable<K>{
    T value;
    Node leftChild;
    Node rightChild;

    public Node(T value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getValue() {
        return  this.value;
    }

    public Node getLeftChildNode() {
        return this.leftChild;
    }

    public Node getRightChildNode() {
        return this.rightChild;
    }
    public abstract T search(K key) throws Exception;
    public abstract void getList(List<T> list);
    public abstract void add(Node node);
    public abstract void remove(K key);
}
