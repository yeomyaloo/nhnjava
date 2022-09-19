package arrays;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack implements Stack{
    final int defaultSize = 100;
    Integer[] elements;
    int top;

    public ArrayStack() {
        this.elements = new Integer[this.defaultSize]
        this.top = -1;
    }


    /**top이 -1로 초기화 설정 되어 있기에 아무것도 없으면 보다 작다.
        그러므로 top이 0보다 작을 때 스택이 비어있다.
     **/
     @Override
    public boolean isEmpty() {
        return this.top < 0;
    }

    @Override
    public void push(Integer element) {
         /**기본으로 설정한 Array 크기보다 더 커진 경우라면 사이즈를 늘려서 새로운 객체를 만들어 준다.
          * 이때 객체를 다 복사해서 넣어주어야 한다. **/
         if( this.elements.length <= this.top+1 ){
            Integer [] newElements = new Integer[this.elements.length + this.defaultSize];
            System.arraycopy(this.elements, 0, newElements, 0,this.elements.length);
            this.elements = newElements;
         }

         this.top ++;
         this.elements[this.top] = element;
    }

    @Override
    public Integer pop() {

         if(isEmpty()){
             throw new EmptyStackException();
         }
         Integer value;
         value = elements[this.top];
         elements[this.top] = null;
         this.top--;

         return value;
    }

    @Override
    public Integer peek() {

         if(isEmpty()) {
             throw new EmptyStackException();
         }
         return elements[this.top];
    }

    @Override
    public int size() {
        return this.top+1;
    }

    @Override
    public String toString() {
         //stack의 배열 중 원소가 저장된 부분만 출력
        StringBuilder line = new StringBuilder();

        for (int i = 0; i <= this.top; i++){
            line.append((line.length()!=0 ? " ": "")+this.elements[i]);
        }
        return line.toString();
    }
}



