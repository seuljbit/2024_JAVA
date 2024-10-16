package day07;

import java.util.ArrayList;
import java.util.List;

public class ListEx03 {

    public static void main(String[] args) {
        String num = "45,78,98,65,84,52,64,31";
        String[] arr = num.split(",");
        int sum = 0;
        int pass = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for (String s : arr) {
            int score = Integer.parseInt(s);
            list.add(score);
            sum += score; 
            
            if (score >= 70) {
                pass++;
            }
        }
        
        System.out.println("합계 : " + sum);
        System.out.println("70점 이상인 인원 수 : " + pass + "/" + list.size());
    }
}