package com.buffer;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用：提高流的读取写入速度
 * 原因：内部提供了缓冲区
 * 3. 处理流：就是`套接`在已有流的基础上
 */
public class BufferedTest {
    /*
    实现非文本文件复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("1.jpg");
            File destFile = new File("1-副本.jpg");
            //2.造流
            //2.1造文件流(节点流)
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制操作：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关外层，再关内层(说明：关闭外层时，内层流会自动关闭，所以可以省略不写)

            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /*
    实现文件复制的方法
     */
    public void copyFile(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造文件流(节点流)
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制操作：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关外层，再关内层(说明：关闭外层时，内层流会自动关闭，所以可以省略不写)

            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void copyFileTest() {
        long start = System.currentTimeMillis();
        String srcPath = "H:\\ProjectAll\\Pro-Java\\JavaSenior\\IOLearning\\1.jpg";
        String destPath = "H:\\ProjectAll\\Pro-Java\\JavaSenior\\IOLearning\\1-副本2.jpg";
        copyFile(srcPath, destPath);//文件流14ms,缓冲流3ms
        long end = System.currentTimeMillis();
        System.out.println("复制操作耗时" + (end - start) + " ms");
    }

    @Test
    public void BufferedReaderWriterTest() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //方式一
//            char[] cbuf=new char[10];
//            int len;
//            while((len=br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }
            String data;
            while ((data = br.readLine()) != null) {
                //方法1
                //bw.write(data+"\n");//data中不包含换行符
                //方法2
                bw.write(data);
                bw.newLine();//换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
