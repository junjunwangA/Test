package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1.建立一个socket
 * 2.数据输出流,数据输入流
 * 3.向server写数据
 * 4.读取server的响应数据
 * 5.关闭连接
 * 
 * @author Zhou-Jingxian
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("127.0.0.1", 10001);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			dos.writeUTF("客户端,请求建立连接!---消息来自客户端client  ");

			System.out.println(dis.readUTF());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			System.out.println("未知的主机异常: " + e);
			
		} catch (IOException e) {
			System.out.println("IO异常: " + e);
		} finally {
			try {
				if(!socket.isClosed()) 
					socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
