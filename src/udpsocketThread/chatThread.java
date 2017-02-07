package udpsocketThread;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class chatThread implements Runnable {

	@Override
	public void run() {
		while(true){
			DatagramSocket ds = null;
			try {
	                      ds = new DatagramSocket(10001);
	                        //获取数据
	                        byte[] buf = new byte[1024];
	                        
	                        DatagramPacket dp = new DatagramPacket(buf,buf.length);
	                        ds.receive(dp);                       
	                        
	                        //获取IP
	                        String ip = dp.getAddress().getHostAddress();
	                        
	                        //输出数据
	                        System.out.println(ip+" :"+new String(buf,0,dp.getLength()));
	                   
	                        
                        } catch (Exception e) {
                        	System.out.println(e.toString());
                        }finally{
                        	ds.close();
                        }
		}

	}

}
