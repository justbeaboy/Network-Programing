package udpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class chat {
	//将在键盘输入的内容，发送到server端
	public static void main(String[] args) {
		//建立socket服务
		DatagramSocket ds = null;
		//获取输入的字符
		BufferedReader br = null;
		try {
			if(ds==null){
				ds = new DatagramSocket();
			}
			if(br==null){
				//将输入的字符进行打包
				// System.out.println("请输入：");
				
				br = new BufferedReader(new InputStreamReader(System.in));
				byte[] buf = br.readLine().getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.10.172.23"), 10000);
				ds.send(dp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ds.close();
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
