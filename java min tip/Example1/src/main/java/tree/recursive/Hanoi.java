package tree.recursive;

import java.util.Scanner;

public class Hanoi {
    Hanoi(){
    }

    public void move(Tower base, Tower target, Tower temp, long count) {
        /**
         * n개의 원판이 첫번째에 있다고 한다면 이를 (n-1)개 중간으로 옮겨주게 되면
         * 나머지 가장 큰 원판을 세번째 지역으로 1번만에 옮길 수 있게 된다.**/
        if (count != 1){
            move(base, temp, target, count - 1);
        }

    }

//    public void run(){
//        move();
//    }

    public static void main(String[] args) {

    }
}
