package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1.����һ��socket
 * 2.���������,����������
 * 3.��serverд����
 * 4.��ȡserver����Ӧ����
 * 5.�ر�����
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
			
			dos.writeUTF("�ͻ���,����������!---��Ϣ���Կͻ���client  ");

			System.out.println(dis.readUTF());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			System.out.println("δ֪�������쳣: " + e);
			
		} catch (IOException e) {
			System.out.println("IO�쳣: " + e);
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
