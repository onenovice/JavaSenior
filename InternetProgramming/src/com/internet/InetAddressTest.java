package com.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 一、网络编程两个主要问题

 1. 如何准确定位网络上一台或多台主机；定位主机上特定的应用

 2. 找到主机后如何可靠的进行数据传输

 二、网络编程中两个要素

 1. `IP`和端口号
 2. 提供网络通信协议：TCP / IP 参考模型（应用层、传输层、网络层、链路层、物理层）

 三、通信要素一：IP和端口号

 1. IP：唯一标识Internet上的计算机（通信实体）
 2. 在java中使用`InetAddress`类代表IP
 3. IP分类：IPv4和IPv6; 万维网和局域网
 4. 域名
 5. 本地地址：`127.0.0.1`或者`localhost`
 6.实例化InetAddress：getByName(String host),getLocalHost()
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.0.1");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
            //获取域名
            System.out.println(inet2.getHostName());
            //获取ip
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
