package class_interface.number;

public abstract class MyNumber{

    abstract MyNumber add(MyNumber myNumber);
    abstract MyNumber subtract(MyNumber myNumber);
    abstract MyNumber multiply(MyNumber myNumber);
    abstract MyNumber divide(MyNumber myNumber);

    abstract int toInt();
    abstract double toDouble();

}
