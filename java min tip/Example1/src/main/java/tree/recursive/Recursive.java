package tree.recursive;

public class Recursive {
    public static int sum(int num) {
        if (num <= 0) {
            return 0;
        } else {
            return num + Recursive.sum(num - 1);
        }
    }
    public static int IterationSum(int n){
        int sumNum = 0;
        for(int i = n; n > 0 ; n --){
            sumNum += n;
        }
        return sumNum;
    }

    public static void main(String[] args) {
        System.out.println("1부터 n까지의 합은 : " + sum(5));
        System.out.println(IterationSum(5));
    }


}
