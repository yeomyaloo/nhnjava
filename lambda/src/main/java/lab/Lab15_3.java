package lab;

import java.util.function.Supplier;

public class Lab15_3 {

    /**
     * 람다를 이용한 Supplier<T> 구현
     * 고정된 길이의 리스트로 수열의 일부를 구성
     * 이를 계속하기 위해서 Supplier<T> 함수형 인터페이스를 이용
     * */
    public static void main(String[] args) {

        int [] fibs = {0,1}; // [0, 1]
        Supplier<Integer> fibonacci2 = () -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;

            return result;
        };

        for(int i = 0; i < 10; i++){
            System.out.println(fibonacci2.get()+"");
        }

        System.out.println("");

    }

}
