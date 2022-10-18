package com.fatjar.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive extends Thread{
    Socket socket;
    DataInputStream inputStream;

    public Receive(Socket socket) {
        this.socket = socket;

        try {
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {
        while (inputStream != null){
            try{
                System.out.println(inputStream.readUTF());
            } catch (IOException e) {

            }
        }
    }
}
