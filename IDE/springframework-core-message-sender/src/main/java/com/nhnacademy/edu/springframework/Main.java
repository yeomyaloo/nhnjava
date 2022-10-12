package com.nhnacademy.edu.springframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] chr = new char[5][15];


        //5번 입력받기
        for(int i = 0; i < chr.length; i++){
            String str = br.readLine();

            for (int j=0; j < str.length(); j++){
                //입력받은 문자열을 하나씩 확인
                chr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                if(chr[j][i] ==' ' || chr[j][i] =='\0')
                    continue;
                System.out.print(chr[j][i]);
            }
        }



    }
}