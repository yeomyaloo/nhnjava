package 보낼것;

import java.lang.annotation.Annotation;

public class Typing {
    public static void isflying(Animal animal) {
        Annotation[] annotations = Animal.class.getDeclaredAnnotations();
        if (annotations instanceof Flying == false) {
            throw new RuntimeException();
        }
        else{
            System.out.println(animal + "는(은) 날 수 있어." );
        }
    }

    public static void main(String[] args) {
        isflying(new Bat());
    }
}



