package com.internet;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 20:45 2021/4/20
 * @ Version:
 */
public class UDPTest {
    //发送端
    @Test
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str="UDP导弹。。。。。。。。。。。。。。。。";
            byte[] data=str.getBytes();
            InetAddress inet= InetAddress.getByName("127.0.0.1");
            DatagramPacket packet=new DatagramPacket(data,0,data.length,inet,9000);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null) {
                socket.close();
            }
        }


    }
    //接收端
    @Test
    public void receiver(){
        DatagramSocket socket= null;
        try {
            socket = new DatagramSocket(9000);
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null) {
                socket.close();
            }
        }
    }
}
