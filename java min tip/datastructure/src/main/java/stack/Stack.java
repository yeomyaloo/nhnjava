package stack;


/**
 * 자료구조 중 제일 많이 사용하는 자료구조가 stack이다.\
 * 컬렉션 기반으로 하는 경우엔 E가 맞고 나머지의 경우엔 T를 사용
 * **/
public interface Stack<E> {


    public boolean isEmpty();
    public void push(E element);
    public E pop();
    public E peek();
    public int size();
}
