package arrays;

import java.util.EmptyStackException;

public class LinkedListStack implements Stack{
    static class LinkedNode{
        Integer data;
        LinkedNode next;

        public LinkedNode(Integer data, LinkedNode next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public LinkedNode getNext() {
            return next;
        }
    }


    LinkedNode head; //data와 다음 Node를 가르키는 link가 있다.
    int cnt;

    public LinkedListStack() {
        this.head = null;
        this.cnt = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    @Override
    public void push(Integer element) {
        this.head = new LinkedNode(element, this.head);
        this.cnt++;
    }

    @Override
    public Integer pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        Integer value;
        value = this.head.getData();
        this.head = this.head.getNext();
        this.cnt--;


        return value;
    }

    @Override
    public Integer peek() {

        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.head.getData();
    }

    @Override
    public int size() {
        return this.cnt;
    }

    @Override
    public String toString() {

        StringBuilder line = new StringBuilder();

        LinkedNode node = this.head;
        while (node != null){
            line.reverse().append(((line.length()!=0)?" ":"")+node.getData());
            node = node.getNext();
        }

        return line.toString();
    }
}
