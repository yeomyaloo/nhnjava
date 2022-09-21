package lab;

public class Lab15_5 {

    @FunctionalInterface
    interface AreaCalculator{
        Double getArea(Double length);
    }

    public static void main(String[] args) {
        //원의 면적 구하기
        AreaCalculator circularAreaCalculator = (r) -> 2*Math.PI*r;
        System.out.println("Circular Area (Radius 2) = " + circularAreaCalculator.getArea(2.0));

        AreaCalculator squareAreaCalculator = (r) -> r*r;
        System.out.println("Square Area (Length 2) = "+squareAreaCalculator.getArea(2.0));



    }


}
