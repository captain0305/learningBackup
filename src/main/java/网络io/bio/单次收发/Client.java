package 网络io.bio.单次收发;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args)throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        //从客户端拿输出流
        OutputStream os=socket.getOutputStream();
        PrintStream ps=new PrintStream(os);
        ps.println("hello worle !服务端");
        ps.flush();
    }
}
