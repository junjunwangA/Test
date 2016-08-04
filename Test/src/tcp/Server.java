package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.建立一个ServerSocket
 * 2.建立socket的连接
 * 3.数据输出流,数据输入流
 * 4.读取client的数据
 * 5.给出一个响应道client
 * 6.关闭连接
 * 
 * @author Zhou-Jingxian
 *
 */
public class Server {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			
			serverSocket = new ServerSocket(10001);
			socket = serverSocket.accept();
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
//			DataInputStream dis = new DataInputStream(socket.getInputStream());
			 BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String str=null;
			StringBuffer buff=new StringBuffer("");
			while((str=dis.readLine())!=null){
				System.out.println(str);
				buff.append(str);
				
			}
			dis.close();
			System.out.println("服务器接受到客户端的连接请求:" + buff);
			
			dos.writeUTF("接收连接请求,连接成功!---消息来自服务端 Server");
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(!socket.isClosed()) socket.close();
				if(!serverSocket.isClosed()) serverSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
