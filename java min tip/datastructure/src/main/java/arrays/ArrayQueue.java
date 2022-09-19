package arrays;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue{
    final int defaultSize = 100;
    Integer[] elements;
    int head;
    int tail;

    public ArrayQueue() {
        this.elements = new Integer[this.defaultSize];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public void add(Integer element) {
        //if(elements[this.tail-this.head+1] > element[])
        this.elements[this.tail] = element;
        this.tail++;
    }

    @Override
    public Integer element() {
    //맨 앞에 있는 요소를 삭제하지 않고 돌려준다.
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements[this.head];

    }

    @Override
    public Integer remove() {
    // 맨 앞에 있는 요소를 삭제한 후 돌려준다.
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Integer value = elements[this.head];
        elements[this.head] = null;
        this.head++;

        return value;
    }

    @Override
    public int size() {
        return (this.defaultSize+this.tail-this.head) % this.defaultSize;
    }

    @Override
    public String toString() {

        StringBuilder line = new StringBuilder();
        int node = this.head;

        while (node != this.tail){
            line.append((line.length()!=0 ? " ":"")+this.elements[node]);
            node++;
        }
        return line.toString();
    }
}
