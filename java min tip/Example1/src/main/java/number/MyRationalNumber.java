package number;

import org.jetbrains.annotations.NotNull;

public class MyRationalNumber extends MyNumber{

    private int numerator;
    private int denominator;

    /** 생성자
     * 분자(numerator)
     * -----------------
     * 분모 (denominator)
     * **/
    public MyRationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public MyRationalNumber(int num) {
        this.numerator = num;
        this.denominator = 1;
    }

    public MyRationalNumber(int num, int deno){
        if (deno == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        } else if (deno < 0) {
            numerator = -num;
            denominator = -deno;
        }

        //최대공약수를 구해 약분해준다.
        int gcd = getGCD(Math.abs(num), Math.abs(deno));
        this.numerator = num/gcd;
        this.denominator = deno/gcd;
    }

    private int getGCD(int num, int deno) {
        if (deno == 0){
            return num;
        }
        return getGCD(deno, num%deno);
    }


    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /** 사칙연산
     * 더하기 (유리수끼리 전부 가능)
     * 빼기
     * 곱하기
     * 나누기
     * **/
    @Override
    public MyRationalNumber add(MyNumber myNumber) {
        if (!(myNumber instanceof MyRationalNumber)){
            // 해당 객체가 유리수가 아닌 경우라면 예외를 던져 처리
            throw new IllegalArgumentException("Number is not rational number");
        }
        return new MyRationalNumber(this.numerator *((MyRationalNumber)myNumber).getDenominator()
                    +this.denominator*((MyRationalNumber)myNumber).getNumerator(),
                this.denominator*((MyRationalNumber)myNumber).getDenominator()
        );

    }

    @Override
    public MyRationalNumber subtract(MyNumber myNumber) {
        if (!(myNumber instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return new MyRationalNumber(this.numerator *((MyRationalNumber)myNumber).getDenominator()
                -this.denominator*((MyRationalNumber)myNumber).getNumerator(),
                this.denominator*((MyRationalNumber)myNumber).getDenominator()
        );
    }

    @Override
    public MyRationalNumber multiply(MyNumber myNumber) {
        if (!(myNumber instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return new MyRationalNumber(this.numerator *((MyRationalNumber)myNumber).getDenominator()
                , this.denominator * ((MyRationalNumber)myNumber).getDenominator()
        );
    }

    @Override
    public MyRationalNumber divide(MyNumber myNumber) {
        if (!(myNumber instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        if (((MyRationalNumber)myNumber).getDenominator() == 0){
            throw new ArithmeticException("0으로는 나눌 수 없습니다.");
        }

        return new MyRationalNumber(
                this.numerator *((MyRationalNumber)myNumber).getDenominator()
                , this.denominator * ((MyRationalNumber)myNumber).getDenominator()
        );
    }

    @Override
    int toInt() {
        return this.numerator/this.denominator;   }

    @Override
    double toDouble() {
        return this.numerator / (double)this.denominator;
    }

    /**
     *
     * 해당 사칙연산은 자식의 메소드에 리턴타입이 부모 메서드와 다르게 구성되어있다.
     * 이런 경우는 java에서만 허용되는 코드이며,
     * 1. 원시타입이 아닐 경우
     * 2. 부모(상위) 클래스의 메서드의 반환형으로 오버라이드된 메서드의 반환형이 자동 형변환 가능한 경우
     * 위의 두가지에 한해서 상위 클래스와 반환 타입이 다를때도 override가 가능하다.
     * 원칙적으로는(오버라이드의 경우) 리턴타입, 메소드 이름, 매개변수가 모두 같아야 한다.
     * 오버로딩의 경우엔 반환타입은 상관 없고 매개변수만 신경쓰면 된다.
     * **/


}
