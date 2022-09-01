import java.util.ArrayList;


public class PrimeNumber {
    public static void main(String[] args) {

        int[] arr = new int[1001];

        for (int i = 2; i <= 1001; i++){
            arr[i] = i;
        }

        for (int i = 2; i <= 10001; i++){
            if (arr[i] == 0){
                continue;
            }
            for (int j = i * i ; j <= 10001; j += 1){
                arr[0] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0){
                System.out.println(arr[i] + " ");
            }
        }




    }

}
