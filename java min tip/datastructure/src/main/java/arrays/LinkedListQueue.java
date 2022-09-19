package arrays;

import java.util.NoSuchElementException;

public class LinkedListQueue implements Queue{
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

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }

    LinkedNode head;
    LinkedNode tail;
    int cnt;

    @Override
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    @Override
    public void add(Integer element) {

        if(this.isEmpty()){
            /** LinkedList로 구현하는 큐에 처음으로 요소를 삽입할 경우
             * 1. head 설정 : 입력받은 element를 data로 넣고 다음 값엔 Null처리를 해준다.
             * 2. tail 설정: 이때까진 요소가 하나라 head와 tail이 동일하다.**/
            this.head = new LinkedNode(element, null);
            this.tail = this.head;
        } else{
            //node가 기존에 있을 경우엔 tail 뒤에 붙이고 새로운 노드를 tail로 한다.
            this.tail.setNext(new LinkedNode(element, null));
            this.tail = this.tail.getNext();
        }
        this.cnt ++; //큐에 데이터가 들어와 그만큼 사이즈가 늘어남.
    }


    @Override
    public Integer element() {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.head.getData();
    }

    @Override
    public Integer remove() {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        Integer value = this.head.getData();
        if(this.cnt == 1){
            this.head = null;
            this.tail = null;
        } else {
            //삭제하고 돌려줄 때 큐에 요소가 1개보다 많다면 다음 노드를 head로 설정
            this.head = this.head.getNext();
        }
        this.cnt--;
        return value;
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
            line.append((line.length()!= 0 ? " ": "")+ node.getData());
            node = node.getNext();
        }
        return line.toString();
    }
}
