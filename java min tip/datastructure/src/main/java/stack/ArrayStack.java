package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{
    E[] elements;
    final int DEFAULT_SIZE = 100;
    int top;
    boolean trace;

    public ArrayStack(){
        /** 제네릭스는 생성자에 들어갈 수 없다. 그래서 오브젝트를 캐스팅해서 넣어주면 된다.
            이런 것이 가능한 이유는 전부 Object이고 사이즈가 다 같기 때문이다.
         **/
        this.elements = (E[])new Object[this.DEFAULT_SIZE];
        this.top = -1;
        this.trace = false;
    }

    //사이즈가 큰 경우라면 아래와 같이 생성자 오버라이딩을 해서 진행해준다.
    public ArrayStack(int size){
        if(size <= 0) {
            throw new IllegalArgumentException("Stack size is too small");
        }
        this.elements = (E[])new Object[size];
        this.top = -1;
        this.trace = false;

    }



    @Override
    public boolean isEmpty() {
        return this.top < 0;
    }

    @Override
    public void push(E element) {
        if (this.top < this.elements.length){
            ++this.top;
            this.elements[this.top] = element;
        }
    }

    /**해당 isEmpty() 함수 구현을 제대로 해야 이곳에서 에러가 나지 않음**/
    @Override
    public E pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        //top에 있는 값을 돌려주면 pop()이 된다.
        /**
         * 자바의 리소스 해제 시점?
         * 나를 레퍼런스하는 것이 없으면 해제를 하는데 아래처럼 top만 바꾸면 그대로 레퍼런스가 있어서
         * 리소스 해제를 하지 않을 것 -> 해결? 이럴 땐 null로 리소스를 변경하면 레퍼런스가 해제가 된다.
         * **/
        E value = this.elements[this.top];
        elements[this.top] = null;
        this.top--;
        return value;
    }

    @Override
    public E peek() {

        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.elements[this.top];
    }

    @Override
    public int size() {
        return this.top+1;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i <= this.top; i++){
            line.append((line.length() != 0? " ": "") + this.elements[i]);
        }
        return line.toString();
    }


    //4번
    public static <E> Stack<E> reversed(ArrayStack<E> stack){
        ArrayStack<E> arrayStack = new ArrayStack<>();
        while (!(stack.isEmpty())) {
            arrayStack.push(stack.pop());
        }
        return arrayStack;
    }

    public void reverse(Stack<E> stack){
        while (!(stack.isEmpty())){
            stack.push(stack.pop());
        }
    }
    public E penultimate(Stack<E> stack){
        int i = 1;
        while (!(i ==2)){
            stack.pop();
            i++;
        }
        return stack.pop();
    }

    public E bottom(Stack<E> stack){
        while (!(stack.isEmpty())){
            stack.pop();
        }
        return stack.pop();
    }
}
