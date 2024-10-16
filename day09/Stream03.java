package day09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream03 {

	public static void main(String[] args) {
		/* Student 클래스로 리스트 구성
		 * Student 이름, 점수만 가지는 클래스
		 * 학생 5명 추가, 콘솔에 출력 */
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("김민지", 83));
		studentList.add(new Student("팜하니", 72));
		studentList.add(new Student("강해린", 65));
		studentList.add(new Student("다니엘", 96));
		studentList.add(new Student("이혜인", 51));
		
		studentList.stream().forEach(System.out::println);
		
		System.out.println("----- 다른 방법 -----");
		studentList.stream().forEach(n-> {
			String name = n.getName();
			int score = n.getScore();
			System.out.println(name + " -> " + score);
		});
		
		System.out.println("-- 이름 순으로 정렬하여 출력 --");
		studentList.stream().sorted(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(System.out::println);
		System.out.println();
		
		// list의 점수 합계 / 전체 인원 수
		int sum = studentList.stream()
				.mapToInt(n -> n.getScore())
				.sum();
		System.out.println("점수 합계 : " + sum);
		
		long count = studentList.stream().count();
		System.out.println("인원 수 : " + count);
		System.out.println();
	}
}
