package test;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class chat {
//UDP协议进行数据的发送
	public static void main(String[] args) throws Exception{
		//创建socket服务
		//发送的端口号可在数据中指定
		DatagramSocket ds = new DatagramSocket();
		
		//将需要发送的数据进行打包
		String str = "我是通过udp协议来发送的！";
		 //数据转换成字节数组
		byte[] buf = str.getBytes();
		
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.10.172.23"),8080);
		ds.send(dp);
		ds.close();
		
	}

}
