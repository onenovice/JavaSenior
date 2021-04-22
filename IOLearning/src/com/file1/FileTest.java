package com.file1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用
 * 1. File类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2. File类声明在`java.io`包下
 * 3. File类中涉及关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及写入读取文件内容。如需使用，需要使用IO流完成。
 * 4. 后续File类的对象通常作为参数传递到流的构造器，指明读取或写入的“终点”。
 */
public class FileTest {
    @Test
    public void fileTest1() {
    /*
    1. 如何创建File实例
    	File(String filePath)
    	File(String parentPath,String childPath)
    	File(File parentFile,String childPath)
    2.
    	相对路径：相对当前Module
    	绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
    windows:\\
    unix:/
    */
        //构造器1
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\hello\\file1\\hello.txt");//或者“D:/hello/hello.txt”也行
        //构造器2
        File file3 = new File("D:\\hello", "file1");
        //构造器3
        File file4 = new File(file3, "h1.txt");
        System.out.println(file4);
        //直到此时还未和真实文件建立关系，只是内存中的对象
    }

    /* 获取方法
    `public String getAbsolutePath()`:获取绝对路经
    `public String getPath()`:获路路径
    `public String getName()`:获取名称
    `public String getParent()`:获取上层文件目录路径。若无，返null
    `public Long length()`:获取文件长度(即：字节数)。不能获取目录的长度。
    `public Long lastModified()`:获取最后一次的修改时间，毫秒值

    `public String[] list()`:获取指定目录下的所有文件或者文件目录的名称数组
    `public File[] listFiles()`:获取指定目录下的所有文件或文件目录的File数组
     */
    @Test
    public void fileTest2() {
        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());//此时返回null，需要在创建真实文件后可用
        //length()此时默认值0，lastModified()默认值0，创建真实文件后才有意义
        //其他示例略
    }

    /*重命名
    `public boolean renameTo(File dest)`:把文件重命名为指定的文件路径
    比如：`file1.renameTo(file2)`

    要保证成功重命名，	**要求file1存在，file2不存在**
     */
    @Test
    public void fileTest3() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\hello\\hi.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /*
    判断方法
    `public boolean isDirectory()`:判断是否是文件目录
    `public boolean isFile()`:判断是否是文件
    `public boolean exists()`:判断是否存在
    `public boolean canRead()`:判所是否可读
    `public boolean canWrite()`:判断是否可写
    `public boolean isHidden()`:判断是否隐藏
    */
    /*
    创建方法
     public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
        如果此文件目录的上层目录不存在，也不创建。
     public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
    注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。

     */
    @Test
    public void fileTest4() throws IOException {
        //文件创建
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功！");
        } else {
            file1.delete();
            System.out.println("删除成功！");
        }
    }

    @Test
    public void fileTest5() {
        //文件目录创建
        File file1 = new File("D:\\io\\io1");
        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        }
        File file2 = new File("D:\\io\\io1");
        boolean mkdirs = file2.mkdirs();
        if (mkdirs) {
            System.out.println("file2创建成功");
        }
        file2.delete();//删除文件夹时，要保证文件夹是空的（即先删文件再删文件夹）
        System.out.println("删除成功");
    }
    //练习：遍历某目录下所有文件名和子目录下的文件名（子目录可能也存在子目录）

}
