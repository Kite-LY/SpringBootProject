package netDemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;




/**
 * 实现tcp的网络编程
 * 案例1：客户端法总信息给服务端，服务端将数据显示在控制台上
 * 
 * @author 小风筝
 *
 */
public class TCPTset1 {
	
	//客户端
	@Test
	public void client()  {
		InetAddress inet1;
		Socket socket =null;
		OutputStream os = null;
		try {
			//1.创建Socket对象，指明服务器的ip和端口号
			inet1 = InetAddress.getByName("192.168.0.113");
			socket = new Socket(inet1, 8890);
			//2.获取一个输出流，用于数据的传输
			os = socket.getOutputStream();
			//3.写出数据操作
			os.write("你好，我是客户端".getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.资源的关闭 
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		


	}
	
	
	//服务端
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket socket  = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			//1.创建一个服务器的ServerSocket，指明自己的端口号
			ss = new ServerSocket(8890);
			//2.调用accept（）方法标识接受来自于客户端的socket
			socket = ss.accept();
			//3.获取输入流
			is = socket.getInputStream();
			//4.读取输入流中的数据
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[5];
			int len;
			while((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			System.out.println(baos.toString());
			System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//关闭资源
				baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
}











