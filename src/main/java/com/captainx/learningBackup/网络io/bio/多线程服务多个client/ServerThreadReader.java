package com.captainx.learningBackup.网络io.bio.多线程服务多个client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadReader extends Thread{
    private Socket socket;
    public ServerThreadReader(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
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

