package lab;

import java.util.function.Function;

public class Lab15_1 {
    public static void main(String[] args) {
        Function<Integer, Integer> square1= new Square();
        Function<Integer, Integer> square2 = (x) -> x*x;


        System.out.println("Class : 2 * 2 = " + square1.apply(2));
        System.out.println("Lambda : 2 * 2 = " + square2.apply(2));
    }

    private static class Square implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer integer) {
            return integer*integer;
        }
    }
}
