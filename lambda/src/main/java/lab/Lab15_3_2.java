package lab;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Lab15_3_2 {

    /**
     * stream과 연동해 사용
     * stream 메소드 중 generate는 Supplier<T>를 인수로 받아 stream<T>를 생성하는 생성자 메소드이다.
     *
     * 컴파일 후 결과는 호출할 때마다 생성해주는 무한 스트림이 생성된다.
     * */
    public static void main(String[] args) {

        int [] fibs = {0,1};

        Stream<Integer> fibonacci2 = Stream.generate(()->{
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;

            return result;
        });


        Iterator<?> it = fibonacci2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }

        System.out.println("");

    }

}
