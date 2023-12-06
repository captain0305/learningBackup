package com.captainx.learningBackup.网络io.bio.多次收发;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args)throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        //从客户端拿输出流
        OutputStream os=socket.getOutputStream();
        PrintStream ps=new PrintStream(os);
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("说！");
            String s = sc.nextLine();

            ps.println(s);
            ps.flush();
        }


    }
}
