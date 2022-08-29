package number;

import org.jetbrains.annotations.NotNull;

public class MyNaturalNumber extends MyIntegerNumber{

    public MyNaturalNumber() {
        super();
    }
    public MyNaturalNumber(int num) {
        super(num);
        if (num <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public MyNaturalNumber add(@NotNull MyNaturalNumber myNumber) {
        if (!(myNumber instanceof MyIntegerNumber)){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }

        return new MyNaturalNumber(this.getValue() + myNumber.getValue());
    }

    public MyNaturalNumber subtract(@NotNull MyNaturalNumber myNumber) {
        return new MyNaturalNumber(this.getValue() - myNumber.getValue());
    }


    public MyNaturalNumber multiply(@NotNull MyNaturalNumber myNumber) {
        return new MyNaturalNumber(this.getValue() * myNumber.getValue());
    }


    public MyNaturalNumber divide(@NotNull MyNaturalNumber myNumber) {
        return new MyNaturalNumber(this.getValue() / myNumber.getValue());
    }
}
