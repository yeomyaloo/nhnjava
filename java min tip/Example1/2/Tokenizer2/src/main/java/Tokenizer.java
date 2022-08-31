import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    static class Evaluator {
        int index;
        String expression;
        public Evaluator(String expression) {
            this.index = 0;
            this.expression = expression;
        }

        public boolean isValid() {
            return  this.index < this.expression.length();
        }

        public boolean hasNext() {
            return  this.index + 1< this.expression.length();
        }

        public void next() {
            this.index++;
        }

        public char getCurrent() {
            if (!this.isValid()) {
                throw new IndexOutOfBoundsException();
            }

            return  this.expression.charAt(this.index);
        }
    }

    public static List<Token> evaluation(String expression) {
        Evaluator evaluator = new Evaluator(expression);
        return Tokenizer.evaluation(evaluator);
    }

    public static List<Token> evaluation(Evaluator evaluator) {
        List<Token> tokens = new ArrayList<>();

        while(evaluator.isValid()) {
            switch(evaluator.getCurrent()) {
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
                    while (evaluator.isValid() && Character.isDigit(evaluator.getCurrent())) {
                        number.append(evaluator.getCurrent());
                        evaluator.next();
                    }
                    if ((tokens.size() != 0) && !(tokens.get(tokens.size()-1) instanceof TokenOperator)) {
                        throw new InvalidParameterException("Invalid expression");
                    }

                    tokens.add(new TokenConstant(number.toString()));
                }
                break;

                case '-': {
                    if (tokens.size() == 0) {
                        StringBuilder number = new StringBuilder();
                        number.append('-');
                        evaluator.next();

                        while (evaluator.isValid() && Character.isDigit(evaluator.getCurrent())) {
                            number.append(evaluator.getCurrent());
                            evaluator.next();
                        }

                        if ((tokens.size() != 0) && !(tokens.get(tokens.size()-1) instanceof TokenOperator)) {
                            throw new InvalidParameterException("Invalid expression");
                        }

                        tokens.add(new TokenConstant(number.toString()));
                    } else if (tokens.get(tokens.size() - 1) instanceof TokenOperator) {
                        if (!((TokenOperator)tokens.get(tokens.size()-1)).getValue().equals(")")) {
                            StringBuilder number = new StringBuilder();
                            number.append('-');
                            evaluator.next();
                            if (!Character.isDigit(evaluator.getCurrent())) {
                                throw new InvalidParameterException("Invalid expression");
                            }

                            while (evaluator.hasNext() && Character.isDigit(evaluator.getCurrent())) {
                                number.append(evaluator.getCurrent());
                                evaluator.next();
                            }

                            if ((tokens.size() != 0) && !(tokens.get(tokens.size()-1) instanceof TokenOperator)) {
                                throw new InvalidParameterException("Invalid expression");
                            }

                            tokens.add(new TokenConstant(number.toString()));
                        } else {
                            if ((tokens.size() != 0) && !(tokens.get(tokens.size()-1) instanceof TokenOperand)) {
                                throw new InvalidParameterException("Invalid expression");
                            }

                            tokens.add(new TokenOperator(String.valueOf(evaluator.getCurrent())));
                            evaluator.next();
                        }
                    } else  {
                        if (tokens.size() == 0 || !(tokens.get(tokens.size()-1) instanceof TokenOperand)) {
                            throw new InvalidParameterException("Invalid expression");
                        }
                        tokens.add(new TokenOperator(String.valueOf(evaluator.getCurrent())));
                        evaluator.next();
                    }
                }
                break;

                case '+':
                case '*':
                case '/': {
                    if (tokens.size() == 0 || !(tokens.get(tokens.size()-1) instanceof TokenOperand)) {
                        throw new InvalidParameterException("Invalid expression");
                    }
                    tokens.add(new TokenOperator(String.valueOf(evaluator.getCurrent())));
                    evaluator.next();
                }
                break;
                
                case '(': {
                    evaluator.next();

                    List<Token> subtokens = new ArrayList<>();
                    subtokens.add(new TokenOperator("("));
                    subtokens.addAll(evaluation(evaluator));
                    if ((tokens.size() != 0) && !(tokens.get(tokens.size()-1) instanceof TokenOperator)) {
                        throw new InvalidParameterException("Invalid expression");
                    }
                    tokens.add(new TokenExpression(subtokens));
                }
                break;
                case ')': {
                    if (tokens.size() == 0 || !(tokens.get(tokens.size()-1) instanceof TokenOperand)) {
                        throw new InvalidParameterException("Invalid expression");
                    }
                    tokens.add(new TokenOperator(String.valueOf(evaluator.getCurrent())));
                    evaluator.next();
                    return  tokens;
                }
                
                case ' ':
                case '\t': {
                    evaluator.next();
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
