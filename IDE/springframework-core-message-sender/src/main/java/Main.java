import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Stack {
    private int top;
    private int stackArr[];

    public Stack() {
        this.top = -1;
        this.stackArr = new int[10001];
    }

    public void push(int x){
        this.stackArr[++top] = x;
    }

    public int pop(){
        if (top == -1)
            return -1;
        return this.stackArr[top--];
    }

    public int size(){
        return this.top+1;
    }

    public int empty(){
        if(this.top == -1)
            return -1;
        return 0;
    }

    public int top() {
        if(top == -1) {
            return -1;
        } else {
            return this.stackArr[top];
        }
    }
}

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        for (int i = 0; i < n; i++){
            String op = br.readLine();

            if(op.contains("push")){
                String st[] = op.split(" ");//공백 기준으로 분할
                stack.push(Integer.parseInt(st[1]));
            } else if(op.contains("pop")){
                bw.write(String.valueOf(stack.pop())+"\n");
            } else if (op.contains("size")) {
                bw.write(String.valueOf(stack.size())+"\n");
            } else if (op.contains("empty")) {
                bw.write(String.valueOf(stack.empty())+"\n");
            } else if (op.contains("top")) {
                bw.write(String.valueOf(stack.top())+"\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
