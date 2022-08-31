package sytaxtree;

public class TokenConstant extends TokenOperand {
    String value;

    public TokenConstant(String value) {
        this.value = value;
    }

    public TokenConstant clone() {
        return  new TokenConstant(this.value);
    }

    public String toString() {
        return  this.value;
    }
}
