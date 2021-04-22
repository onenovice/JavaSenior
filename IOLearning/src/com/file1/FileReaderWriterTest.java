package com.file1;

/*
 *流的体系结构
 * 抽象基类         节点流（文件流）            缓冲流
 * InputStream      FileInputStream           BufferedInputStream
 * OutputStream     FileOutputStream          BufferedOutputStream
 * Reader           FileReader                BufferedReader
 * Writer           FileWriter                BufferedWriter
 *
 */

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
    /*
    将IOLearning下的hello.txt内容输出到控制台
    说明：
    1. read()的理解：返回读入的字符。如果达到文件尾，返回-1
    2. 异常处理：为了保证资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则会报FileNotFoundException
     */
    @Test
    public void fileReaderTest1() {
        FileReader fr = null;
        try {
            //1. 实例化File对象，指明要操作的文件
            File file = new File("hello.txt");//相对当前Module，若是main方法则是相对项目
            System.out.println(file.getAbsoluteFile());
            //2. 提供具体的流
            fr = new FileReader(file);//找不不到文件时报异常
            //3.数据的读入
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭
            try {
                if (fr != null) {//有可能在第二步出现异常
                    fr.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对read()的操作升级，使用read()的重载方法
    @Test
    public void fileReaderTest2() {
        FileReader fr = null;
        try {
            //1. 实例化File对象
            File file = new File("hello.txt");

            //2. FileReader流的实例化
            fr = new FileReader(file);
            //3.数据的读入
            //返回每次读入cbuf数组的字符个数，如果达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //错误写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //方式一：遍历cbuf
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf, 0, len);//注意长度，避免方式一类似错误
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /*
        从内存写出到硬盘
        说明：
        1.输出操作，对应的File可以不存在。
        2.File对象对应的硬盘中的文件如果不存在，则创建之后写入；
                                    如果存在：
                                        使用的构造器是FileWriter(file,false) / FileWriter(file)会对原有文件进行覆盖写入
                                        使用的构造器是FileWriter(file,true)会在原来文件基础上追加写入
     */
    @Test
    public void fileWriterTest1() {
        FileWriter fw = null;//try-catch-finally自动生成
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象
            fw = new FileWriter(file);
            //3.写出操作
            fw.write("I have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从一个文件读出，写入另一个文件
    说明：
    不能使用字符流做图片的复制
     */
    @Test
    public void fileReaderFileWriterTest() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");

            //创建FileReader,FileWriter对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //具体读出和写入操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close()
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //下面放到finally和并列写都可以，都可以保证得到执行
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}