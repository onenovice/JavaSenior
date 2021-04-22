package com;

import org.junit.Test;

import java.io.*;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 21:18 2021/4/19
 * @ Version:
 */
public class InputStreamReaderTest {
    //解码：字节 -->字符
    @Test
    public void inputStreamReader(){
        InputStreamReader isr = null;//字符集默认参数是系统默认
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            //字符集默认参数是系统默认
            //字符集的选择取决于文件本身保存时使用的字符集
            isr = new InputStreamReader(fis,"UTF-8");
            char[] cbuf=new char[10];
            int len;
            while((len=isr.read(cbuf))!=-1){
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //utf-8文本转gbk文本
    @Test
    public void transform(){
        InputStreamReader isr= null;
        OutputStreamWriter osw= null;
        try {
            File file1=new File("hello.txt");
            File file2=new File("hello-gbk.txt");
            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos,"gbk");
            int len;
            char[] cbuf=new char[20];
            while ((len=isr.read(cbuf))!=-1) {
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr!=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
