import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shiyutao
 * @create 2021-09-03 18:09
 */
public class TCPtest {

    @Test
    public void client1()  {
        Socket socket= null;
        OutputStream stream= null;
        FileInputStream stream1= null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            stream = socket.getOutputStream();
            stream1 = new FileInputStream("标准证件照.jpg");
            byte[]bytes=new byte[1024];
            int len;
            while ((len=stream1.read(bytes))!=-1){
                stream.write(bytes,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket= null;
        InputStream inputStream= null;
        FileOutputStream fos= null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            fos = new FileOutputStream("gai.jpg");
                byte[]bytes=new byte[1024];
                int len;
                while ((len=inputStream.read(bytes))!=-1){
                fos.write(bytes,0,len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
