package com.file1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Description:文件字节流
 * @ Author: Jay
 * @ Date: Create in 16:04 2021/4/19
 * @ Version:
 */
public class FileInputOutputStreamTest {
    /*
    使用字节流读取文件，不适用于中文
    结论：
    1.文本文件（.txt,.java,.c,.cpp）使用字符流处理
    2.非文本文件（.jpg,.map3,.avi,.doc,.ppt,...）使用字节流处理
     */
    @Test
    public void fileInputOutputStreamTest1() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[6];

            int len;
            while ((len = fis.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //复制图片
    @Test
    public void fileInputOutputStreamTest2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            File srcFile = new File("1.jpg");
            File destFile = new File("1-副本.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            int len;
            byte[] buffer = new byte[5];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    一个完成文件复制的方法
     */
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void copyFileTest() {
        long start = System.currentTimeMillis();
        String srcPath = "H:\\ProjectAll\\Pro-Java\\JavaSenior\\IOLearning\\1.jpg";
        String destPath = "H:\\ProjectAll\\Pro-Java\\JavaSenior\\IOLearning\\1-副本2.jpg";
        copyFile(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作耗时" + (end - start) + " ms");
    }
}
