package test;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {
	
	public static void main(String[] args) throws Exception{ 
		//创建socket服务
		DatagramSocket ds = new DatagramSocket(8080);
		//定义一个缓冲区，用于接收数据
		byte[] buf = new byte[1024];//在该行后面，UDP协议传输数据包时，每个包的大小在64k之内
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		//接收数据包中的数据
		ds.receive(dp);
		//查看一下该数据来源是什么地址
		String ip = dp.getAddress().getHostAddress();
		System.out.println("来自"+ip+"的数据为：");
		System.out.println(new String(buf,0,dp.getLength()));
		ds.close();
	}
}
