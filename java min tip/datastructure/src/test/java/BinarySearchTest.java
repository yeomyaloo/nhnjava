import arrays.BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {
    public static void main(String[] args) {

        Random random = new Random();//랜덤 객체 생성
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++){
            arr[i] = random.nextInt(10000);
        }
        System.out.println(BinarySearch.binarySearch(arr, 3002));
    }


}
