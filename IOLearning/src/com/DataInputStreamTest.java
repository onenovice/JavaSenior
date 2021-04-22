package com;

import org.junit.Test;

import java.io.*;

/**
 * @ Description:数据流
 * @ Author: Jay
 * @ Date: Create in 15:21 2021/4/20
 * @ Version:
 */
public class DataInputStreamTest {
    /*
    写入文件（输出到文件）
     */
    @Test
    public void dataInputStreamTest1() {
        DataOutputStream dos = null;
        try { // 创建连接到指定文件的数据输出流对象
            dos = new DataOutputStream(new FileOutputStream("destData.dat"));
            dos.writeUTF("我爱北京天安门"); // 写UTF字符串
//            dos.flush();//立即写入
            dos.writeBoolean(false); // 写入布尔值
            dos.writeLong(1234567890L); // 写入长整数
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 关闭流对象
            try {
                if (dos != null) {
// 关闭过滤流时,会自动关闭它包装的底层节点流
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    读出（输入内存）
    读取顺序要与写入顺序一致
     */
    @Test
    public void dataInputStreamTest2() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("destData.dat"));
            String info = dis.readUTF();
            boolean flag = dis.readBoolean();
            long time = dis.readLong();
            System.out.println(info);
            System.out.println(flag);
            System.out.println(time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
