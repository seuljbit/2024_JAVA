package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Collection01 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크 : 표준화된 방식의 자료구조
		 * List, Set, Map => 인터페이스. 반드시 구현 클래스로 객체를 생성
		 * 데이터를 묶어서 관리할 때 사용
		 * 주로 배열대신 사용
		  
		 * List(배열과 동일)
		   - 값을 하나씩 저장
		   - index : 순서를 보장
		   - 중복 허용
		   - 배열 대신에 가장 많이 사용하는 구조
		  
		 * Set
		   - 값을 하나씩 저장
		   - index 없음 : 순서를 보장하지 않음.
		   - 중복 x (같은 값이 입력되면 덮어씀.)
		  
		 * Map 
		   - 값을 두개씩 저장  key/value 쌍으로 저장
		   - index는 없고, key가 index 역할을 함.
		   - key : 중복 x / value : 중복가능.
		   - key가 중복되면 value는 덮어써짐. 
		   - 2개의 값이 하나의 자료로 묶어야 할 때 사용
		   - 아이디/패스워드, 제품명/가격, 학생명/점수
		  
		 * 배열은 기본자료형
		 * int arr[], double arr[], String arr[], Student arr[] 다 가능.
		  
		 * Collection은 기본자료형은 불가능함. 클래스 자료형만 가능.
		 * 래퍼클래스(Wrapper Class) : 기본타입 자료형을 클래스 타입으로 변환한 클래스
		 * 기본자료형 (Boxing) > 클래스자료형
		 * 클래스자료형 (UnBoxing) > 기본자료형
		  
		 * 기본자료형 > 래퍼클래스
		 * int     > Integer
		 * char    > Character
		 * byte    > Byte
		 * short   > Short
		 * long    > Long
		 * float   > Float
		 * double  > Double
		 * boolean > Boolean
		  
		 * Collection에서 클래스를 지정하지 않으면 Object가 자동으로 설정
		  
		 * 리스트 생성
		 * List<className> 객체명 = new 구현클래스<className>();
		 * List<Integer> list = new ArrayList<Integer>();
		 * List의 구현클래스 => ArrayList, LinkedList
		  
		 * ArrayList : 검색 시 유리 (배열과 유사한 형태)
		   - 미리 길이를 지정하지 않음. 추가되면 늘어남. 삭제되면 줄어듬
		   - 추가, 삭제가 쉽다. 검색이 쉬움
		  
		 * LinkedList : 추가 / 삭제가 많을 경우 유리
		   - 중간에 값을 끼워넣거나, 빼는게 쉬움.
		   - 검색이 느리다. */
		
		int num = 10;
		Integer boxNum = 20; //자동박싱
		int a = boxNum;  //자동언박싱
		
//		System.out.println(boxNum);
//		System.out.println(a);
		
		//클래스.parse+기본타입명 : 형변환 가능.
		String str = "10";  // String => int
		int i2 = Integer.parseInt(str);
		
		List<Integer> list = new ArrayList<Integer>(); //부모를 기준으로 생성
		ArrayList<Integer> list2 = new ArrayList<Integer>(); //자식 기준으로 생성
		List list3 = new ArrayList(); //Object로 생성
		ArrayList<Integer> list4 = new ArrayList<>(); //구현체 클래스는 생략가능.
		
		List<Integer> linkedList = new LinkedList<>();  // LinkedList 생성
		
		/* List Method
		 * - add() : 요소를 추가
		 * */
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		//- get(index) : index 번지의 요소를 가져오기
		System.out.println(list.get(0));
		
		//- set(index, value) : index번지의 값을 value로 변경
		System.out.println(list.set(0, 10));
		System.out.println(list);
		
		// - size() : list의 개수
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(int in : list) {
			System.out.println(in);
		}
		System.out.println("--list.size()--");
		System.out.println(list.size());
		
		// 문자열을 담는 리스트 생성
		// 문자열 5개 저장 한 후 출력
		List<String> strList = new ArrayList<String>();
		strList.add("새벽");
		strList.add("아침");
		strList.add("점심");
		strList.add("저녁");
		strList.add("밤");
		System.out.println(strList);
		
		for(int i=0; i<strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("------------");
		//향상된 for문 
		for(String tem : strList) {
			System.out.println(tem);
		}
		
		// - remove(index) : index번지의 값을 삭제 => List에서만 가능
		// - remove(object) : object 요소를 삭제 => set/map 
		strList.remove(0);
		System.out.println(strList);
		strList.remove("밤");
		System.out.println(strList);
		System.out.println(list);
		Integer re = 10;
		list.remove(re); //index
		System.out.println(list);
		
		// - contains(object) : list에 값이 있는지 검사 true/ false로 리턴
		System.out.println(strList.contains("새벽"));
		
		// - clear() : 리스트 비움
		strList.clear();
		System.out.println(strList);
		
		//- isEmpty()  : 리스트가 비었는지 확인 true / false
		System.out.println(strList.isEmpty());
		
		/* Iterator : index가 없는 자료형을 출력하기 위해 사용
		 * list는 index가 있기 때문에 get(i)를 사용하여 원하는 번지에 접근이 가능
		 * set / map은 index가 없어서 일반 for문은 사용불가 
		 * (향상된 for문만 가능 - map은 불가능)
		 * 순서와 상관없이 값을 가져올수 있는 Iterator 사용
		 * map은 향상된for, Iterator 둘다 직접 사용은 불가능
		 * */
		System.out.println("-- Iterator출력 --");
		Iterator<Integer> it = list.iterator(); //리스트를 이터레이터 객체로 변환(복사)
		while(it.hasNext()) { //it 다음 요소값이 있는 체크 true / false
			Integer tmp = it.next(); // 다음 요소 가져오기
			System.out.println(tmp);
		}
		
		// - indexOf(object) : 해당 Object의 index를 리턴 / 없으면 -1
		System.out.println(list.indexOf(re));
		
		list.add(15);
		list.add(12);
		list.add(1);
		list.add(6);
		list.add(8);
		System.out.println(list);
		
		//정렬
		// Collections.sort() // 오름차순만 가능
		Collections.sort(list);
		System.out.println(list);
		//list.sort(Comparator를 구현한 구현체) : 정렬
		// Comparator 인터페이스를 구현한 구현체를 넣어야 함. (익명클래스 사용)
		// - compareTo : 사전상 앞이면 -1, 같으면 0, 뒤면 +1
		
		//내림차순
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// 결과가 -면 앞으로 보내고, + 뒤로 보내는 역할
				//o1 - o2 : 오름차순   o2 - o1 : 내림차순
				return o2 - o1;
			}
		});
		
		System.out.println(list);
	}
}