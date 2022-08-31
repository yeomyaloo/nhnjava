import java.util.Arrays;

public class TokenizerTest {
    public static void main(String[] args) {
        String expression1 = "12+34*5";
        String expression2 = "(1+2)/4";
        String expression3 = "-3--2/3-(-4*3)";
        String expression4 = "12+-34*5";
        String expression5 = "(-1/-3)*4";
        String expression6 = "-3--2/3-(-4*3)";

        System.out.println(expression1 + " = " + Tokenizer.evaluation(expression1).toString());
        System.out.println(expression2 + " = " + Tokenizer.evaluation(expression2).toString());
        System.out.println(expression3 + " = " + Tokenizer.evaluation(expression3).toString());
        System.out.println(expression4 + " = " + Tokenizer.evaluation(expression4).toString());
        System.out.println(expression5 + " = " + Tokenizer.evaluation(expression5).toString());
        System.out.println(expression6 + " = " + Tokenizer.evaluation(expression6).toString());

        System.out.println(expression1 + " = " + Tokenizer2.evaluation(expression1).toString());
        System.out.println(expression2 + " = " + Tokenizer2.evaluation(expression2).toString());
        System.out.println(expression3 + " = " + Tokenizer2.evaluation(expression3).toString());
        System.out.println(expression4 + " = " + Tokenizer2.evaluation(expression4).toString());
        System.out.println(expression5 + " = " + Tokenizer2.evaluation(expression5).toString());
        System.out.println(expression6 + " = " + Tokenizer2.evaluation(expression6).toString());
    }
}
