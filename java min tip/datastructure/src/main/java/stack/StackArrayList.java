package stack;

import java.awt.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList {
    ArrayList<Integer> stack;

    public StackArrayList() {
        stack = new ArrayList<>();
    }

    public void push(int value){
        stack.add(value);
    }

    public int pop(){
        if(!(stack.isEmpty())){
            int value = stack.get(stack.size()-1); // 해당 요소를 일단 저장하고 돌려준다.
            stack.remove(stack.size()-1); //해당 요소 삭제
            return value;
        }else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        //스택이 비어있다면 true 반환
        if (stack.isEmpty()) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        StackArrayList stackArrayList = new StackArrayList();

        stackArrayList.push(4);
        stackArrayList.push(5);
        stackArrayList.push(6);
        for(Integer n : stackArrayList.stack){
            System.out.println(n);
        }
    }
}
