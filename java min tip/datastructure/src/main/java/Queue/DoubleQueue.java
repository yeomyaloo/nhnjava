package Queue;


import java.util.NoSuchElementException;

public class DoubleQueue<Integer> implements Queue<Integer> {

    class LinkedNode<E> {
        Integer element;
        LinkedNode next;
        LinkedNode pre;

        public LinkedNode() {
            this.element = element;
            this.pre = this;
            this.next = this;
        }

        public LinkedNode(Integer element, LinkedNode pre, LinkedNode next) {
            this.element = element;
            this.pre = pre;
            this.next = next;
        }

        public Integer getElement() {
            return this.element;
        }

        public LinkedNode getNext() {
            return this.next;
        }

        public LinkedNode getPre() {
            return this.pre;
        }

        public void setPre(LinkedNode pre) {
            this.pre = pre;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }


    LinkedNode head;
    int cnt; //node 개수

    public DoubleQueue(LinkedNode head, LinkedNode tail, int cnt) {
        this.head = new LinkedNode(0,this.head);
        this.cnt = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    @Override
    public void add(Integer element){
        if (isEmpty()){ //this.cnt == 0?
            /**해당 값이 처음으로 들어가지는 요소라면 1개 밖에 없기 때문에 pre와 next는 서로 를 가르킨다.**/
            LinkedNode newNode = new LinkedNode<>(element, head.next, head.getNext());
            this.head.getNext().setPre(newNode);
            this.head.setNext(newNode);
            this.cnt ++;
    }


    @Override
    public Integer element() {
        /**돌려줄 요소가 없다면 예외를 돌려준다.**/
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        /**큐에서 head를 돌려주는 메소드이다.**/
        return this.head.getNext().getElement();
    }

    public Integer remove(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        LinkedNode target = this.head.getPre();
        target.getPre().setNext(target.getNext());
        target.getNext().setPre(target.getPre());

        return element;

    }

    @Override
    public int size() {
        return this.cnt;
    }


}
