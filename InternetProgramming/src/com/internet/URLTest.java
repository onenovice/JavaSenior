package com.internet;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ Description:
 * @ Author: Jay
 * @ Date: Create in 21:01 2021/4/20
 * @ Version:
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/myTest.txt");
            System.out.println("getProtocol() :"+url.getProtocol());
            System.out.println("getHost() :"+url.getHost());
            System.out.println("getPort() :"+url.getPort());
            System.out.println("getPath() :"+url.getPath());
            System.out.println("getFile() :"+url.getFile());
            System.out.println("getQuery() :"+url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    /*
    从某地址下载文件到本地
     */
    @Test
    public void URLTest1(){
        HttpURLConnection urlConnection= null;
        InputStream is= null;
        FileOutputStream fos= null;
        try {
            URL url=new URL("http://localhost:8080/examples/myTest.txt");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream(new File("hello.txt"));
            byte[] buffer=new byte[20];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection!=null) {
                urlConnection.disconnect();
            }
        }

    }
}
