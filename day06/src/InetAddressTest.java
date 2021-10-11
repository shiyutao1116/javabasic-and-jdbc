import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author shiyutao
 * @create 2021-09-03 15:25
 */
public class InetAddressTest {
   @Test
           public void test(){
       try {
           InetAddress inet1= InetAddress.getByName("www.atguigu.com");
           InetAddress inet2= InetAddress.getByName("127.0.0.1");
           InetAddress inet3= InetAddress.getLocalHost();
       } catch (UnknownHostException e) {
           e.printStackTrace();
       }

   }
   @Test//客户端
    public void client()  {
       Socket socket = null;
       OutputStream outputStream= null;
       try {
           InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
           socket = new Socket(inetAddress,8899);
           outputStream = socket.getOutputStream();
           outputStream.write("你好服务器我是客户端".getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {if(outputStream!=null)
               outputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {if(socket!=null)
               socket.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }


   }
   @Test//服务器端
   public void server()  {
       ServerSocket s = null;
       Socket socket= null;
       InputStream inputStream= null;
       ByteArrayOutputStream byteArray= null;
       try {
           s = new ServerSocket(8899);
           socket = s.accept();
           inputStream = socket.getInputStream();
           byteArray = new ByteArrayOutputStream();
           byte[]bytes=new byte[5];
           int len;
           while ((len=inputStream.read(bytes))!=-1){
            byteArray.write(bytes,0,len);

           }
           System.out.println(byteArray.toString());
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               byteArray.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               inputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               socket.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               s.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }


   }




}




