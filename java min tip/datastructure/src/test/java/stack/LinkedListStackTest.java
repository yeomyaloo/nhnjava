package stack;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();

        System.out.println(stack);

        stack.push(7);
        stack.push(8);
        System.out.println(stack.pop());
    }

}