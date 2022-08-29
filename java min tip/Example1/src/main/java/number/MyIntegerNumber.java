package number;

import org.jetbrains.annotations.NotNull;

public class MyIntegerNumber extends MyRationalNumber{
    public MyIntegerNumber() {
        super();
    }
    public MyIntegerNumber(int num) {
        super(num);
    }

    int getValue(){
        return this.getNumerator();
    }


    @Override
    public MyIntegerNumber add(@NotNull MyNumber myNumber) {
        if (!(myNumber instanceof MyIntegerNumber)){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }

        return new MyIntegerNumber(this.getValue() + ((MyIntegerNumber)myNumber).getValue());
    }

    @Override
    public MyIntegerNumber subtract(@NotNull MyNumber myNumber) {
        if (!(myNumber instanceof MyIntegerNumber)){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }

        return new MyIntegerNumber(this.getValue() - ((MyIntegerNumber)myNumber).getValue());
    }

    @Override
    public MyIntegerNumber multiply(@NotNull MyNumber myNumber) {
        if (!(myNumber instanceof MyIntegerNumber)){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }

        return new MyIntegerNumber(this.getValue() * ((MyIntegerNumber)myNumber).getValue());
    }


    @Override
    public MyIntegerNumber divide(@NotNull MyNumber myNumber) {
        if (!(myNumber instanceof MyIntegerNumber)){
        throw new IllegalArgumentException("정수가 아닙니다.");
        }

        if (((MyIntegerNumber)myNumber).getValue() == 0){
            throw new ArithmeticException("0으로는 나누지 못합니다.");
        }
        return new MyIntegerNumber(this.getValue() / ((MyIntegerNumber)myNumber).getValue());
    }
}
