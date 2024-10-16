package day08;

import java.util.TreeSet;

public class TreeSet02 {

	public static void main(String[] args) {
		int[] score = {80, 79, 85, 46, 35, 84, 78, 96, 82};
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int s : score) {
			set.add(s);
		}
		System.out.println("점수 : " + set);
		System.out.println();
		
		// headSet(value) : value보다 작은 값
		// tailSet(value) : value보다 큰 값
		System.out.print("80보다 작은 값 -> ");
		System.out.println(set.headSet(80));
		System.out.print("80보다 큰 값 -> ");
		System.out.println(set.tailSet(80));
	}
}
