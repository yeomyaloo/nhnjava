package lab;

import java.util.ArrayList;
import java.util.List;

public class Lab15_6 {

    public static void main(String[] args) {
        List<String> places = new ArrayList<>();

        places.add("Gyeonggi-do");
        places.add("Gangwon-do\n");
        places.add("Chungcheongnam-do");
        places.add("Chungcheongbuk-do");
        places.add("Jeollanam-do");
        places.add("Jeollabuk-do");
        places.add("Gyeongsangnam-do");
        places.add("Gyeongsangbuk-do");
        places.add("Jeju-do");
        places.add("abdd");

        /**endsWith
         * String 타입을 인자로 받으며 해당 String 객체가 인자로 전달된 String으로 끝나면
         * true를 반환하고 그렇지 않다면 false를 반환한다.
         * */
        places.stream().filter((p)->p.endsWith("do"))
                .map((p)->p.toUpperCase()).forEach((p)-> System.out.println(p));


        System.out.println("기존의 for문과 if문을 사용한 방식");
        for (String place: places){
            if(place.endsWith("do")){
                System.out.println(place.toUpperCase());
            }
        }




    }
}
