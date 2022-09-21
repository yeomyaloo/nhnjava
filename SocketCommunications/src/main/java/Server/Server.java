package Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 5050;

        int number = Integer.parseInt(args[0]);
        String str = new String(args[1]);


        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("접속 대기중 ~");



        while(true){

            //새로운 소켓을 생성해 클라이언트가 들어올때
            Socket socket = serverSocket.accept();
            System.out.println("사용자가 접속 했습니다.");
            System.out.println("Client IP : "+socket.getInetAddress());

            //클라이언트와 연결을 위한 스트림 생성
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


            dataOutputStream.writeUTF(str);
            dataOutputStream.writeInt(number);
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        }

    }
}
