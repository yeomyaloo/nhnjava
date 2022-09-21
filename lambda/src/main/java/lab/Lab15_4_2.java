package lab;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;


/** Consumer<T>
 * 음수는 출력하지 않도록 한다.
 * 이때는 필터링을 하는 방식을 사용해 좀 더 함수형 언어처럼 만든다.
 * Stream의 filter를 사용해 양수만을 추출한다.
 * limit을 이용해 출력할 개수를 정한다.
 * 생성된 객체에 forEach를 이용해 추출된 정수를 출력한다.
 * */
public class Lab15_4_2 {

    public static void main(String[] args) {
        Random random = new Random();

        Stream<Integer> positiveRandomStream = Stream.generate(random::nextInt)
                .filter((x) -> x >= 0).limit(10);
        positiveRandomStream.forEach((x) -> System.out.println(x + ""));
    }
}
