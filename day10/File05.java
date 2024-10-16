package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class File05 {
    public static void main(String[] args) throws IOException {
        /* test.txt 파일을 읽어들여 map에 저장
         * 명단, 합계, 평균 출력
         * 읽어들이는 파일은 모두 String
         * 계산을 위해서는 int로 변환 필요 -> Integer.parseInt();
         * 80점 이상인 학생 명단 */

        BufferedReader read = new BufferedReader(new FileReader("test.txt"));
        Map<String, Integer> map = new HashMap<>();

        String name = null;
        int score;
        int sum = 0;
        int count = 0;

        // 파일을 읽고 map에 저장 및 합계 계산
        while (true) {
            String line = read.readLine();

            if (line == null) { 
                break; 
            }

            int index = line.indexOf(" ");
            name = line.substring(0, index);
            score = Integer.parseInt(line.substring(index + 1));

            map.put(name, score);
            sum += score;
            count++;
        }
        read.close();

        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("----------------");
        System.out.println("합계 : " + sum);
        System.out.printf("평균: %.2f\n", (double) sum / count);

        System.out.println("--- 80점 이상 학생 명단 ---");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 80) {  // 수정된 부분
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}