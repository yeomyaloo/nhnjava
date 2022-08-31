package sytaxtree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TokenExpression extends TokenOperand {
    List<Token> tokens;

    public TokenExpression(List<Token> tokens) {
        this.tokens = new ArrayList<>();

        for(Token token : tokens ) {
            this.tokens.add(token.clone());
        }
    }

    public TokenExpression clone() {
        return  new TokenExpression(this.tokens) ;
    }

    public String toString() {
        return  this.tokens.toString();
    }
}
