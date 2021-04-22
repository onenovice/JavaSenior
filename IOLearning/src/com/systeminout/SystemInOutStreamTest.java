package com.systeminout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准的输入、输出流
 * <p>
 * 1.1 `System.in`：标准的输入流，默认从键盘输入
 * <p>
 * `System.out`:标准的输出流，默认从到控制台输出
 * <p>
 * 1.2 `System`类的`setIn(InputStream is) / setOut(PrintStream ps)`方式重新指定输入和输出的流
 */
public class SystemInOutStreamTest {
    /*
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
进行输入操作，直至当输入“e”或者“exit”时，退出程序。
    方式一：使用Scanner实现，调用next()返回一个字符串
    方法二：使用System.in实现:System.in --->转换流 --->BufferedReader的readLine()
     */
    //System.in的单元测试在idea中会有问题导致控制台无法输入，这里使用main方法
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序退出！");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
