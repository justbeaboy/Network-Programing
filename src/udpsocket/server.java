package udpsocket;

import java.io.BufferedWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class server {

	public static void main(String[] args) {
		//建立socket服务
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		
		try {
			if(ds==null){
				ds = new DatagramSocket(10000);
			}
			byte[] buf = new byte[1024];
			
			if(dp==null){
				dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				
				System.out.println("来自"+ip+"中的数据为：");
				System.out.println(new String(buf,0,dp.getLength()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ds.close();
		}

	}

}
