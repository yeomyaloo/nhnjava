public class TokenOperator extends Token {
    String      value;

    public TokenOperator(String value) {
        this.value = value;
    }

    public TokenOperator clone() {
        return  new TokenOperator(this.value);
    }
    public String getValue() {
        return  this.value;
    }

    public String toString() {
        return  this.value;
    }
}
