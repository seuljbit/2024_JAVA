package day10;

import java.io.File;

public class File06 {

	public static void main(String[] args) {
		/* File 객체 : 경로 + 확장자
		 * D:\seulbit_240904\java_workspace\java_project\test.txt
		 * 파일 생성
		 * File.separator : 파일 경로 구분자(운영체제마다 다름) \\ (\ /)
		 * java에서 읽을 수 있는 파일 형식 : txt, xml, json, csv(파이썬에서 주로 봄) 	
		 * 데이터 센터(https://www.data.go.kr/index.do) => xml, json*/
		
		File f = new File("D:\\seulbit_240904\\java_workspace\\java_project\\test.txt");
		System.out.println(File.separator);
		
		String name = f.getName();
		System.out.println(name); // test.txt, 파일명.확장자
		System.out.println(f.getPath()); // 경로+파일명+확장자
		System.out.println(f.getParent()); // 경로만
		
		// 파일 객체를 스트링으로 변환
		String f2 = f.toString();
		System.out.println(f2);
		
		String f2name = f2.substring(f2.lastIndexOf(File.separator)+1);
		System.out.println(f2name);
	}
}
