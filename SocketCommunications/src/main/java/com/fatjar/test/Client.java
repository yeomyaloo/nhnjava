package com.fatjar.test;

import java.io.IOException;
import java.net.Socket;


public class Client {


    Sender sender;
    Receive receive;

    Socket socket;

    public Client(String host, String port) throws IOException {

        this.socket = new Socket(host, Integer.parseInt(port));

        System.out.println("서버에 연결되었습니다.");

        this.sender = new Sender(socket);
        this.receive = new Receive(socket);


        this.sender.start();
        this.receive.start();
    }

}
