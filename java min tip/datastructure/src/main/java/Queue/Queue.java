package Queue;

public interface Queue<E> {


    public boolean isEmpty();

    //insert elements
    public void add(E elements);

    //return the head of the queue
    public E element();

    //remove the head of the queue
    public E remove();

    public int size();

}
