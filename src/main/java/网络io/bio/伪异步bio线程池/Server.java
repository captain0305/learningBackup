package 网络io.bio.伪异步bio线程池;

import java.io.IOException;
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
            HandlerSocketServerPool handlerSocketServerPool = new HandlerSocketServerPool(5, 6);
            //监听连接请求
            while (true) {
                Socket accept = SS.accept();

                Runnable target=new ServerRunnableTarget(accept);
                handlerSocketServerPool.execute(target);

                
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
