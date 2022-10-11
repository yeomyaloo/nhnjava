package com.nhnacademy;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.security.auth.login.LoginContext;

public class a {
    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        String id = "test";
        String pw = "1234";

        boolean loginFlag = true;
        boolean flag = false;


        while(loginFlag) {
            System.out.println("로그인 하실 아이디를 작성해주세요");
            String loginId = ac.nextLine();

            System.out.println("비밀번호를 입력해주세요");
            String loginPw = ac.nextLine();

            if(loginId.equals(id) && loginPw.equals(pw)){
                System.out.println("로그인에 성공했습니다.");
                System.out.println();
                loginFlag = false;
                flag = true;
                break;

            } else {
                System.out.println("로그인에 실패했습니다.");
                System.out.println();
            }
        }


        int menu;



        while (flag) {
            System.out.println("메뉴를 선택해주세요");
            System.out.println("1. 로그아웃 2.비밀번호 변경");
            menu = Integer.parseInt(ac.nextLine());
            switch (menu) {
                case 1:
                    System.out.printf("%s님이 로그아웃 하셨습니다.", id);
                    flag = false;
                    break;
                case 2:
                    System.out.println("비밀번호 변경을 선택하셨습니다.");
                    flag = false; //이게 있어야 해당 while문이 종료됨
                    break; //이게 있어야 다음 case 확인을 안 하고 switch문이 종료됨
                default:
                    System.out.println("올바르지 않은 번호를 입력하셨습니다.");
            }
        }
    }
}






