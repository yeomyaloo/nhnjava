package lab;

import java.util.Random;
import java.util.function.Consumer;


/** Consumer<T>
 * 음수는 출력하지 않도록 한다.
 *
 * */
public class Lab15_4 {

    public static void main(String[] args) {
        Random random = new Random();

        Consumer<Integer> positivePrint = (x) -> {if (x >= 0) System.out.println(x + " ");};


        for(int i = 0; i < 10; i++){
            positivePrint.accept(random.nextInt());
        }

    }
}
