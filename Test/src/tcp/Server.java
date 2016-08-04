package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.����һ��ServerSocket
 * 2.����socket������
 * 3.���������,����������
 * 4.��ȡclient������
 * 5.����һ����Ӧ��client
 * 6.�ر�����
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
			System.out.println("���������ܵ��ͻ��˵���������:" + buff);
			
			dos.writeUTF("������������,���ӳɹ�!---��Ϣ���Է���� Server");
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
