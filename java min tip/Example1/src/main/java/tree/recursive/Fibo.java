package tree.recursive;

public class Fibo {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    public static int fibo(int n){
        if (n==0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else{
            return fibo(n+1) + fibo(n);
        }
    }

    public static int fibonacci(int n){
        if(n < 2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
