package day11;

import java.io.IOException;
import java.net.*;

public class Network01 {

	public static void main(String[] args) throws IOException {
		// 인터넷 주소의 정보를 확인
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println("HostAddress" + ip.getHostName()); // HostAddresswww.naver.com
		System.out.println("HostAddress" + ip.getHostAddress()); // HostAddress23.53.224.202
		System.out.println(ip.toString()); // www.naver.com/23.53.224.202
		
		URL url = new URL("https://news.kbs.co.kr/news/pc/view/view.do?ncd=8081646");
		System.out.println(url.getContent()); // sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@dd05255
		System.out.println(url.getAuthority()); // 접근 권한 : news.kbs.co.kr
		System.out.println(url.getDefaultPort()); // 443
		System.out.println(url.getProtocol()); // https
		System.out.println(url.getHost()); // news.kbs.co.kr
		System.out.println(url.getQuery()); // ncd=8081646 (물음표 뒤에 있는 거)
		System.out.println(url.getPath()); // /news/pc/view/view.do

		
	}
}
