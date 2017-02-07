package test;
import java.net.InetAddress;

public class test2 {

	public static void main(String[] args) throws Exception{
		//使用java代码获取本地的ip地址
		//首先获取InetAddress对象
		InetAddress ia = InetAddress.getLocalHost();
		
		String ip = ia.getHostAddress();
		System.out.println("本地IP地址为："+ip);
	}

}
