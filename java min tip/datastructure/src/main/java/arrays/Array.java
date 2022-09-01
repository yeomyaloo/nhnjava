package arrays;

import java.util.*;
import java.util.stream.Stream;

public class Array {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = random.nextInt(10);
        }

        for (int n : arr){
            System.out.println(n);
        }
        System.out.println(isSorted(arr));
        System.out.println("최대값 = "+maxValue(arr) + ", 최소값 = "+minValue(arr));
        System.out.println("배열의 평균값 = " +arrayAve(arr));

        //4번
        Set<Integer> set = new HashSet<>();
        for (int loop: arr){
            set.add(loop);
        }
        int[] newArr = new int [set.size()];
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < newArr.length; i++){
            newArr[i] = it.next();
        }
        //5번
        int []arr3 = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            int tmp = arr[i];
            arr3[i] = arr[arr.length-i-1];
            arr[i] = tmp;
        }
        System.out.println("정렬 후"+Arrays.toString(arr3));

        // 6번
        int[] a = {1,2,3,4,5,6};
        int[] b = {7,8,9,10,11};
        int arrayLength = a.length + b.length;

        int[] result = new int[arrayLength];

        System.arraycopy(a,0,result,0,a.length);
        System.arraycopy(b,0,result,a.length,b.length);
        System.out.println(Arrays.toString(result));

        //3-7
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int chrNum = 0;
        for (int tmp =0; tmp < str.length(); tmp++) {
            char tmpchar = str.charAt(tmp);
            if ('A' <= tmpchar && tmpchar <= 'Z' ||
                'a' <= tmpchar && tmpchar <= 'z'){
                chrNum ++;
            }
        }
        System.out.println("해당 문자열에 포함된 알파벳 개수는 " + chrNum);


        //1차원 배열
        Double[] d = new Double[];
        Double[] d2 = new Double[];
        Double[] res = new Double[];
        int result2 = 0;
        for (int i = 0; i < d.length; i++){
            res[i] = d[i] * d2[i];
        }
        for (double x: res){
            result2 += x;
        }


        //2차원 배열
        Double[][] d3 = new Double[][];
        Double[][] d4 = new Double[][];
        Double[][] res2 = new Double[][];

        for (int i = 0; i < d3.length; i++){
            for (int j = 0; j < d4[0].length; j ++)
                for(int k = 0; k < d4.length; k++){
                    res2[i][j] = d3[i][k] * d4[k][j];
            }
        }

        //4번 파스칼의 삼각형 만들기
        int n = 0;
        int k = 0;

        n = input.nextInt();
        k = input.nextInt();



        int [][] combinationMatrix = new int[n+1][k+1];

        for (int i = 0; i < n; i++){
            for (int j = 0 ; j <= i; j++){
                if (i == j || j == 0){
                    combinationMatrix[i][j] = 1;
                }else {
                    combinationMatrix[i][j] = combinationMatrix[i-1][j] + combinationMatrix[i-1][j-1];
                }
            }
        }
        for (int i = 0; i > n; i++){
            for (int j = 0; j > k ; k ++){
                System.out.println(combinationMatrix[i][j]);
            }
        }

    }

    public static int arrayAve(int[] arr) {
        int sum = 0 ;
        for (int i =0; i < 10; i++){
            sum += arr[i];
        }
        return sum/arr.length;
    }

    public static int maxValue(int[] arr) {
        int max = -2147000000;
        for (int i = 0; i < 10; i ++){

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int minValue(int[] arr) {
        /**
         * 해당 min max는 정해진 상수가 있으니 그것을 쓰자
         * **/
        int min = 2147000000;
        for (int i = 0; i < 10; i ++){

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static boolean isSorted(int[] arr){
        for (int i = 0; i < 10; i ++){
            for (int j = 1; j < 10; j ++){
                if (arr[i] > arr[j]){
                        return false;
                }
            }
        }
        return true;
    }



}
