package 网络io.bio.单次收发;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：客户端发消息，服务端届消夏
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
