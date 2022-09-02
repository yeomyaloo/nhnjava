package stack;

import java.util.EmptyStackException;

public class LinkedListStack<Integer> implements Stack<Integer>{
    Integer elements;
    LinkedListStack next;

    public LinkedListStack(Integer elements, LinkedListStack next) {
        this.elements = elements;
        this.next = next;
    }

    LinkedListStack data;
    int top = 0;

    public LinkedListStack() {
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(Integer element) {
        LinkedListStack<Integer> stack = new LinkedListStack<>(elements, this.data);
        top ++;
    }

    @Override
    public Integer pop() {
        return null;
    }

    /**@Override
    public Integer pop() {


        return ;
    }**/

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
