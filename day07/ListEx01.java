package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListEx01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list를 생성
		 * 출력 for / 향상된 for / Iterator 출력
		 * import 단축키 : ctrl+shift+o */
		
		List<String> list = new ArrayList<String>();
		list.add("기상");
		list.add("출근");
		list.add("수업");
		list.add("점심");
		list.add("수업");
		list.add("퇴근");
		list.add("저녁");
		
		//for
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------");
		
		//향상된 for
		for(String tmp : list) {
			System.out.println(tmp);
		}
		System.out.println("----------------");
		
		Iterator<String>it = list.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp);
		}
		System.out.println("----------------");
		
		//정렬 list.sort(Comparator 구현체);
		System.out.println(list);
		// 오름차순
		Collections.sort(list);
		System.out.println(list);
		
		//내림차순
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// compareTo
				// 사전순으로 앞에 있으면 - 같으면 0 뒤에 있으면 +
				// o1.compareTo(o2) : 오름차순
				// o2.compareTo(o1) : 내림차순
				return o2.compareTo(o1);
			}
		});
		
		System.out.println(list);
		
		//같은 Object가 2개 이상이더라도 앞에있는 하나만 삭제
		List<String> ex = new ArrayList<>();
		ex.add("수업");
		list.removeAll(ex); 
		System.out.println(list);


	}

}