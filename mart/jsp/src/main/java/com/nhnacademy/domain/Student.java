package com.nhnacademy.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

/*@Getter
@AllArgsConstructor //권장하지 않음
@Data*/
@Value
public class Student {
    private final String  id;
    private final String name;
    private final int age;

    /**객체의 완결성이 필요한데 java bean을 사용한 방법은 어떤 학생은 이름만, 학번만,, 이런식으로 존재할 수 있어서
     * 이러한 문제를 해결하기 위해서 생성자로 한 번에 인자들을 입력받아 초기화하는 것이 좋다.
     * 그러나 lombok 사용은 이마저도 해결해준다,

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }* **/

}
