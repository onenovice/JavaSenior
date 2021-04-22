import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 `RandomAccessFile`类

 1. 直接继承于`java.lang.Object`类，实现了`DataInput`和`DataOutput`接口
 2. `RandomAccessFile`既可以作为输入流，也可以作为输入流
 3.作为输出流输出时，如果写出到的文件存在，则会对原有文件内容进行（默认从头覆盖）覆盖
 */
public class RandomAccessFileTest {
    /*
    基本读入，写出操作
     */
    @Test
    public void randomAccessFileTest(){
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile("hello.txt","r");
            raf2 = new RandomAccessFile("hello1.txt","rw");

            int len;
            byte[] buffer=new byte[1024];
            while((len=raf1.read(buffer))!=-1) {
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2!=null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    作为输出流输出时，如果写出到的文件存在，则会对原有文件内容进行（默认从头覆盖）覆盖

    实现在已经存在内容的文件内插入指定位置特定字符
     */
    @Test
    public void randomAccessFileInsertTest(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt","rw");
            raf.seek(3);
            //保存指针后的所有数据
            StringBuilder sb=new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while((len = raf.read(buffer))!=-1){
                sb.append(new String(buffer,0,len));
            }
            //调回指针
            raf.seek(3);
            //写入指定位置
            raf.write("xyz".getBytes());
            raf.write(sb.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        try {
            if(raf!=null){
                raf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
