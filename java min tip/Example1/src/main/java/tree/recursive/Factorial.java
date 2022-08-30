package tree.recursive;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }


    private static int factorial(int n) {
        if (n==0){
            return 1;
        } else if (n == 1){
            return 1;
        }
        return factorial(n-1)+factorial(n-2);
    }

}
