package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 11:17 2021/4/20
 * @ Version:
 */
public class PrintStreamTest {
    /*
    将输出位置从控制台变成文件
     */
    public void printStreamTest(String path) {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}
