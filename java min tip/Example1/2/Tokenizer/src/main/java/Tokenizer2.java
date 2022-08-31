import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer2 {
    public static List<Token> evaluation(String expression) {
        List<Token> tokens = new ArrayList<>();

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

                    tokens.add(new Token(TokenType.OPERAND, number.toString()));
                }
                break;

                case '-': {
                    if ((tokens.size() == 0)
                            || ((tokens.get(tokens.size() - 1).getType() == TokenType.OPERATOR)
                                && !tokens.get(tokens.size() - 1).getValue().equals(")"))) {
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

                        tokens.add(new Token(TokenType.OPERAND, number.toString()));
                    } else {
                        tokens.add(new Token(TokenType.OPERATOR, String.valueOf(expression.charAt(i))));
                        i++;
                    }
                }
                break;

                case '+':
                case '*':
                case '/':
                case '(':
                case ')': {
                    tokens.add(new Token(TokenType.OPERATOR, String.valueOf(expression.charAt(i))));
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
