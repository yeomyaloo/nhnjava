package Queue;


import java.util.NoSuchElementException;

public class LinkedQueue<Integer> implements Queue<Integer> {

    class LinkedNode<E> {
        Integer element;
        LinkedNode next;

        public LinkedNode(Integer element, LinkedNode next) {
            this.element = element;
            this.next = next;
        }

        public Integer getElement() {
            return this.element;
        }

        public LinkedNode getNext() {
            return this.next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }


    LinkedNode head;
    LinkedNode tail;
    int cnt; //node 개수

    public LinkedQueue(LinkedNode head, LinkedNode tail, int cnt) {
        this.head = null;
        this.tail = null;
        this.cnt = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    @Override
    public void add(Integer element){
        if (isEmpty()){ //this.cnt == 0?
            /**현재 요소가 하나도 없을 땐 요소를 추가해서 객체를 생성해준다
             * next의 경우엔 첫 요소를 넣어주었기 때문에 next가 없다고 봐야 한다.
             * **/
            this.head = new LinkedNode<>(element, null);
            this.tail = this.head;
        }else{
            /**
             * 요소가 이미 존재한다면 tail을 head뒤에 붙이고 새로운 요소를 tail로 설정해준다.
             * **/
            this.tail.setNext(new LinkedNode(element, null));
            this.tail = this.tail.getNext();
        }
        this.cnt++;
    }


    @Override
    public Integer element() {
        /**돌려줄 요소가 없다면 예외를 돌려준다.**/
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        /**큐에서 head를 돌려주는 메소드이다.**/
        return (Integer) this.head.getElement();
    }

    public Integer remove(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        Integer element = (Integer) this.head.getElement();

        if(this.cnt == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
        }
        this.cnt--;

        return element;
    }

    @Override
    public int size() {
        return this.cnt;
    }

    public static <E> Queue<E> reversed(Queue<E> queue){

    }


}
