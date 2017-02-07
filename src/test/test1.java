package test;
import java.net.InetAddress;

public class test1 {
	//java代码获取指定网址的ip地址
	public static void main(String[] args) throws Exception {
		//先获取一个InetAddress对象
		InetAddress ia =InetAddress.getByName("www.baidu.com");
		//然后调用InetAddress中的getHostAddress方法来获取IP地址
		String ip = ia.getHostAddress();
		System.out.println("解析出来的IP地址为"+ip);
	}

}
