package Client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5050);
        System.out.println("서버와 접속이 되었습니다.");

        InputStream inputStream = socket.getInputStream();

        DataInputStream dataInputStream = new DataInputStream(inputStream);

        String str = dataInputStream.readUTF();
        int number = dataInputStream.readInt();

        System.out.println("서버에서 전송된 값: " +number);
        System.out.println("서버에서 전송된 문자: " + str);

        dataInputStream.close();
        inputStream.close();
        socket.close();
    }
}
