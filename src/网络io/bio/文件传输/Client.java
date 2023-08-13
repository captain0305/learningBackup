package 网络io.bio.文件传输;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",8888);
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            // 先发送上传文件的后缀给服务端
            dataOutputStream.writeUTF(".png");
            InputStream inputStream=new FileInputStream("/Users/xuchengrui/IdeaProjects/leetcode/src/网络io/bio/多线程服务多个client/Server.java");
            byte[] buffer=new byte[1024];
            int len;
            while ((len= inputStream.read(buffer))>0){
                dataOutputStream.write(buffer,0,len);
            }
            dataOutputStream.flush();
        }catch (Exception e){

        }
    }
}
