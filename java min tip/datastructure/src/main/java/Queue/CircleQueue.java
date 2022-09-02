package Queue;

import java.util.NoSuchElementException;

public class CircleQueue {

    static class Node{
        int data;
        Node next;
    }

    static class Queue{
        Node front, rear;
    }

    static void enQueue(Queue q, int value){
        /**enque
         * 1. 요소를 맨 뒤에 넣어준다 이때 rear은 현재 요소가 들어간 부분이다. (맨마지막으로 요소가 들어간 부분을 가르킨다.)
         * 2. 해당 front에 데이터가 없다는 것은 빈 큐임을 의미하기에 그대로 값을 넣어준다.
         * 3. 해당 front가 null이 아니라면 현재 큐에는 데이터가 있기 때문에 rear이 가르키는 다음 노드에 해당 데이터를 넣어준다.
         * 4. 데이터를 넣어준 뒤 circle queue 구조를 유지하기 위해서 rear를 front를 가르키게 한다.
         * **/

        Node tmp = new Node();
        tmp.data = value;
        if(q.front == null){
            q.front=tmp;
        } else {
            q.rear.next = tmp;
        }

        q.rear = tmp;
        q.rear.next=q.front;

    }

    static int deQueue(Queue q){

        //해당 queue에 요소가 없으면 예외를 던짐
        if(q.front == null){
            throw new NoSuchElementException("Queue is empty!!");
        }
        int value;

        //큐 안에 요소가 1개만 있을 땐 둘 다 참조를 해제해주어야 한다.
        if (q.front == q.front) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        }
        else { //1개 이상의 요소가 있다면?
            /**
             * 1. enqueue는 해당 요소의 맨 앞에 있는 것을 빼준다(front.data를 제거)
             * 2. circle queue라는 특징 때문에 front는 다음 요소를 가르키게 된다.(즉, front.next = 그다음 노드)
             * **/
            Node tmp = q.front;
            value = tmp.data;
            q.front = q.front.next;
            q.rear.next = q.front;
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
