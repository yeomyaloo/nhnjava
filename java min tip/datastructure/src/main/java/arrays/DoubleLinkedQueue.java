package arrays;


import java.util.NoSuchElementException;

public class DoubleLinkedQueue implements Queue{


    static class LinkedNode{
        Integer data;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {
            this.data = 0;
            this.pre = this;
            this.next = this;
        }

        public LinkedNode(Integer data, LinkedNode pre, LinkedNode next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public LinkedNode getPre() {
            return pre;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public void setPre(LinkedNode pre) {
            this.pre = pre;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }

    LinkedNode head;
    int cnt;

    public DoubleLinkedQueue() {
        this.head = new LinkedNode();
        this.cnt = 0;
    }

    @Override
    public boolean isEmpty() {
        //초기화를 head 자신으로 두었기에 head 자신이 next로 오면 doubleLinkedQueue가 비었다고 할 수 있다.
        return this.head.getNext() == this.head;
    }

    @Override
    public void add(Integer element) {
        LinkedNode newNode = new LinkedNode(element,this.head.getPre(),this.head);
        this.head.getPre().setNext(newNode);
        this.head.setPre(newNode);
        this.cnt++;
    }

    @Override
    public Integer element() {

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.head.getNext().getData();
    }

    @Override
    public Integer remove() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        LinkedNode target = this.head.getNext();
        Integer data = target.getData();

        target.getPre().setNext(target.getNext());
        target.getNext().setPre(target.getPre());
        this.cnt--;
        return element();
    }

    @Override
    public int size() {
        return this.cnt;
    }
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        LinkedNode node = this.head.getNext();
        while(node != this.head) {
            line.append((line.length() != 0?" ":"") + node.getData());
            node = node.getNext();
        }

        return	line.toString();
    }
}
