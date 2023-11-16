package 网络io.bio.多线程服务多个client;

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
            while (true) {
                Socket accept = SS.accept();

                new ServerThreadReader(accept).start();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
