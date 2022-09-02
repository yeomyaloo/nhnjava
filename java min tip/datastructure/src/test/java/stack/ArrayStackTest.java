package stack;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();

        arrayStack.push('A');
        arrayStack.push('B');
        arrayStack.push('c');
        System.out.println(arrayStack.isEmpty());


        System.out.println(arrayStack.pop());


    }

}