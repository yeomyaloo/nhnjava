package number;

import animal.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalTest {


    public static void main(String[] args) {

        /**
         * 각각의 동물 객채를 생성해서 이 해당 인스턴스가 인터페이스에 속하면 그것을 출력
         * 스트림을 사용해서 filter를 이용해 원하는 조건에 맞는 것들만 출력해준다.
         * **/
        List<Animal> animals = Arrays.asList(new 매(), new 펭귄(), new 타조(), new 호랑이(), new 고래(), new 박쥐());
        /**
         * 클래스 이름 가져오기 -
         * 1. 객체 생성
         * 2. 객체 클래스명 가져오기**/
        System.out.println("Flyable animals: "+ animals.toString(animals.stream().filter(x -> x instanceof Flying).toArray()));
        System.out.println("Swimming animals: "+ animals.toString(animals.stream().filter(x -> x instanceof Swimming).toArray()));

    }




}
