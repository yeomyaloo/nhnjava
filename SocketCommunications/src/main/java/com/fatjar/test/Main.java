package com.fatjar.test;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-l")){
            new Server(args[1]);
        }else {
            new Client(args[0], args[1]);
        }
    }
}
