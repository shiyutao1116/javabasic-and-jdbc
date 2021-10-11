import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author shiyutao
 * @create 2021-09-03 21:24
 */
public class Udptest {
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String string="我是udp";
        byte[]data=string.getBytes();
        InetAddress inet=InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length,inet,9090);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();

        }
    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket1 = new DatagramSocket(9090);
        byte[]bytes=new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
        datagramSocket1.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),datagramPacket.getLength()));
        datagramSocket1.close();
    }


}
