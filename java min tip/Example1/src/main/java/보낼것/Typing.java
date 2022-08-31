package 보낼것;

import java.lang.annotation.Annotation;

public class Typing {
    public static void flying(Animal x) {
        Annotation[] annotations = Animal.class.getDeclaredAnnotations();
        if (annotations instanceof Flying == false) {
            throw new RuntimeException();
        }
        System.out.println( x.type() + (x.날수있니()? "는(은) 날 수 있어.": "는(은) 못날아.") );
    }

    public static void main(String[] args) {
        박쥐 x = new 박쥐();
        System.out.println(날수있니(x));
    }
}



