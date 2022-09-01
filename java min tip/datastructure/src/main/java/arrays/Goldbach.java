package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static sun.nio.cs.Surrogate.MAX;

public class Goldbach {

    public static boolean[] isnt_prime_num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isnt_prime_num = new boolean[MAX + 1];
        getPrimeNum();
        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++){
            int N = Integer.parseInt(br.readLine());

            for (int j = N/2; j > 0; j--){
                int idx1 = i;
                int idx2 = N-i;
                if(!isnt_prime_num[idx1] && isnt_prime_num[idx2]){
                    sb.append(idx1 + " "+idx2 + "\n");
                    break;
                }
            }
        }
    }

    public static void getPrimeNum() {


    }


}
