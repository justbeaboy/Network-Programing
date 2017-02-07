package udpsocketThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {

	public static void main(String[] args) {
		//创建读取线程
		new Thread(new chatThread()).start();
				// 创建服务
				DatagramSocket ds = null;
				BufferedReader br = null;
				try {
					if (ds == null)
						ds = new DatagramSocket();
					// 读取键盘录入
					if (br == null)
						br = 
		                       new BufferedReader(new InputStreamReader(System.in));
					// 读取数据
					String line = null;
					while ((line = br.readLine()) != null) {
						// 发送数据
						byte[] buf = line.getBytes();
						DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.10.172.23"), 10001);
						ds.send(dp);
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				} finally {

					ds.close();
					if (br != null)
						try {
							br.close();
						} catch (Exception e) {
							System.out.println(e.toString());
						}
				}

	}
	
}
