package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		/* < Stream(스트림) >
		 1. 실제 입력(출력)되는 데이터의 흐름
		 2. 파이프라인으로 데이터가 흘러가는 흐름의 개념
		 3. 자료에 스트림을 별도 생성하여 연산(복사본)
		 4. 스트림 연산은 연산을 다 수행하면 소모됨(1회성)
		 5. 기존 자료를 복사하여 스트림을 구성하기 때문에 기존 자료의 변경 유발 x
		 6. 스트림용 연산이 별도 존재(중간 연산 / 최종 연산)
		  1) 중간 연산 : 메서드를 이어서 사용할 수 있음
		   (1) distinct() : 중복 제거
		   (2) filter() : 조건에 맞는 자료만 다음 스트림으로 이동
		   (3) limit() : 스트림의 일부를 잘라냄(어디서부터 어디까지)
		   (4) skip() : 스트림의 일부를 건너뜀
		   (5) sorted() : 정렬
		   (6) map() : 새로운 형태로 변경 ..... 등
		    - mapToInt() / mapToLong() / mapToObject
		  2) 최종 연산 : 스트림의 최종 결과 연산(마지막에서만 사용 가능)
		   (1) forEach(), count(), sum(), allMatch() : 스트림 요소가 전부 일치하는지?
		   (2) anyMatch() : 하나라도 일치하는지?
		   (3) toArray() : 리스트를 배열로 변환
		   (4) collect() : 스트림을 수집					*/
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("---< 일반적인 합계 구하는 법 >---");
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println();
		
		System.out.println("---< 스트림을 이용한 sum() >---");
		int total = Arrays.stream(arr).sum();
		System.out.println(total);
		System.out.println();
		
		System.out.println("---< 스트림을 이용한 count() >---");
		// count() 연산은 return long 반환
		long cnt = Arrays.stream(arr).count();
		System.out.println(cnt);
		System.out.println();
		
		System.out.println("--< 스트림을 이용한 average() >--");
		// Optional : nullPointException 같은 Exception을 처리할 수 있게 도와줌
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg); // OptionalDouble[5.0]
		System.out.println();
		
		System.out.println("--< 배열의 값 중 5 이상만 출력 filter() >--");
		// filter : 조건
		Arrays.stream(arr).filter(n -> n>=5).forEach(m -> {
			System.out.print(m + " ");
		});
		System.out.println();
		
		System.out.print("5 이상의 숫자 합계 : ");// 5 이상의 합계 출력
		int sum2 = Arrays
				.stream(arr)
				.filter(n-> n>=5)
				.sum();
		System.out.println(sum2);
		System.out.println();
		
		int[] score = {78, 89, 86, 58, 74, 51, 63, 89, 90};
		// Stream을 이용하여 합계, 평균, 최대값, 70점 이상 인원 수
		int scoreTotal = Arrays.stream(score).sum();
		System.out.println("점수 합계 : " + scoreTotal + "점");
		
		OptionalDouble scoreAvg = Arrays.stream(score).average();
		System.out.println("점수 평균 : " + scoreAvg);
		
		OptionalInt max = Arrays.stream(score).max();
		System.out.println("가장 높은 점수 : " + max + "점");

		System.out.print("70점 이상 > ");
		Arrays.stream(score).filter(n -> n>= 70).forEach(m -> {
			System.out.print(m + "점, ");
		});
		long cnt70 = Arrays.stream(score).filter(n -> n >= 70).count();
		System.out.print("(총 " + cnt70 + "명)");
		
		System.out.println();
		System.out.println();
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(7);
		list.add(8);
		list.add(1);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(7);
		list.add(8);
		
		System.out.println("--< list stream 구성 >--");
		list.stream().forEach(n -> {System.out.print(n + " ");});
		System.out.println();
		System.out.println();
		
		System.out.println("--< distinct() 중복 제거 >--");
		list.stream().distinct().forEach(n -> System.out.print(n + " "));
		System.out.println();
		System.out.println();
		
		System.out.println("--< sorted() 정렬 >--");
		list.stream()
		.distinct()
		.sorted()
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		System.out.println();
		
		System.out.println("--< 합계 >--");
//		int s = list.stream().sum(); // 합계 > intStream에게만 존재
		// map : 스트림 변환에 사용하는 중간 연산
		// mapToInt : map 값을 int로 변환하는 역할
		int s = list.stream()
				.mapToInt(n -> n.intValue())
			    .sum();
		System.out.println("list 합계 : " + s);
		System.out.println();
		
		System.out.println("--< Stream 객체 생성 >--");
		Stream<Integer> s1 = Stream.of(10, 20, 30, 40, 50, 60);
		
		int s2 = s1.mapToInt(n -> n.intValue()).sum();
		System.out.println("s1 합계 : " + s2);
		
		// 이미 소모된 스트림은 다시 사용할 수 없음 -> stream has already been operated upon or closed
//		OptionalDouble avg3 = s1.mapToInt(n -> n.intValue()).average();
//		System.out.println(avg3);
	}	
}
