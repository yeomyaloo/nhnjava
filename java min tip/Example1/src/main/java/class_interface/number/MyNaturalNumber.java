package class_interface.number;

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

//왜 자연수도 MyNumber의 자손인데 재정의가 안 되는지?` 바로 아래 자식만 가능한것인가요?
