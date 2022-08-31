import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<String> evaluation(String expression) {
        List<String> tokens = new ArrayList<>();

        int i = 0;
        while(i < expression.length()) {
            switch(expression.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    StringBuilder number = new StringBuilder();
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        number.append(expression.charAt(i));
                        i++;
                    }

                    tokens.add(number.toString());
                }
                break;

                case '-': {
                    if ((tokens.size() == 0)
                            || tokens.get(tokens.size() - 1).equals("(")
                            || tokens.get(tokens.size() - 1).equals("+")
                            || tokens.get(tokens.size() - 1).equals("-")
                            || tokens.get(tokens.size() - 1).equals("/")
                            || tokens.get(tokens.size() - 1).equals("*")) {
                        StringBuilder number = new StringBuilder();
                        number.append('-');
                        i++;
                        if (!Character.isDigit(expression.charAt(i))) {
                            throw new InvalidParameterException("Invalid expression");
                        }

                        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                            number.append(expression.charAt(i));
                            i++;
                        }

                        tokens.add(number.toString());
                    } else {
                        tokens.add(String.valueOf(expression.charAt(i)));
                        i++;
                    }
                }
                break;

                case '+':
                case '*':
                case '/':
                case '(':
                case ')': {
                    tokens.add(String.valueOf(expression.charAt(i)));
                    i++;
                }
                break;

                case ' ':
                case '\t': {
                    i++;
                }
                break;

                default:
                {
                    throw new InvalidParameterException("Invalid expression");
                }
            }
        }

        return  tokens;
    }
}
