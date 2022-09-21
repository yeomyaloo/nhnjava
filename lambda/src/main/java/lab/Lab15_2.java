package lab;

import java.util.function.Predicate;

public class Lab15_2 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = new IsPositive();
        Predicate<Integer> isPositive2 = (x) -> x<0;


        System.out.println("Class :1 = " + isPositive.test(1)+", -1 = "+ isPositive.test(-1));
        System.out.println("Lambda: 1 = " + isPositive2.test(1) + ", -1 = "+isPositive2.test(-1));

    }

    private static class IsPositive implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer < 0;
        }
    }
}
