package com.fatjar.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * OutputStream을 사용해서 받은 메시지를 보내주는 클래스
 * */

public class Server {

    Sender sender;
    Receive receive;


    ServerSocket serverSocket;
    Socket socket;
    public Server(String port) throws IOException {

        this.serverSocket = new ServerSocket(Integer.parseInt(port));
        System.out.println("클라이언트의 연결을 기다리고 있습니다.");

        this.socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었습니다.");


        this.sender = new Sender(socket);
        this.receive = new Receive(socket);

        this.sender.start();
        this.receive.start();
    }

}




