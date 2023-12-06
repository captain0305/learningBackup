package com.captainx.learningBackup.网络io.bio.多次收发;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：客户端多次发消息，服务端
 */
public class Server {
    public static void main(String[] args) {
        //定义一个serverSocket
        try {
            ServerSocket SS=new ServerSocket(9999);
            //监听连接请求
            Socket accept = SS.accept();

            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg= bufferedReader.readLine())!=null){
                System.out.println("服务端收到"+msg);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
