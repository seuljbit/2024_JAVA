package Word;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class WordController {
    Map<String, List<String>> map = new HashMap<>();

    public WordController() {
        map.put("friend", new ArrayList<>(Arrays.asList("친구", "동지")));
        map.put("get", new ArrayList<>(Arrays.asList("받다", "얻다")));
        map.put("have", new ArrayList<>(Arrays.asList("소유하다", "가지다")));
        map.put("take", new ArrayList<>(Arrays.asList("가지고 가다", "데리고 가다", "집다")));
        map.put("put", new ArrayList<>(Arrays.asList("놓다", "밀어넣다", "보내다")));
        map.put("on", new ArrayList<>(Arrays.asList("위", "계속하여")));
        map.put("up", new ArrayList<>(Arrays.asList("위", "위쪽에")));
    }

    public void printWordNote() {
        System.out.println("---- 단어장 ----");

        map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println
                (entry.getKey() + " : " + String.join(", ", entry.getValue()));
            });

        System.out.println("-----------------");
    }

    public void addWord(Scanner scan) {
        System.out.print("추가할 단어를 입력하세요 > ");
        String word = scan.next();
        scan.nextLine();

        System.out.print("단어의 뜻을 입력하세요(여러 개일 경우 ','로 구분) > ");
        String meanings = scan.nextLine();
        List<String> meaningList = new ArrayList<>(Arrays.asList(meanings.split(",")));

        map.put(word, meaningList);
        System.out.println("단어가 추가되었습니다.");
    }

    public void searchWord(Scanner scan) {
        System.out.print("검색할 단어를 입력하세요 > ");
        String search = scan.next();

        // 영단어 입력
        if (map.containsKey(search)) {
            System.out.print(search + " : ");
            System.out.println(String.join(", ", map.get(search)));
            return;
        }

        // 한글(뜻) 입력
        boolean found = false;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> meanings = entry.getValue();
            
            if (meanings.contains(search)) {
                System.out.println("- " + entry.getKey() + " : " + String.join(", ", entry.getValue()));
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 단어가 사전에 없습니다.");
        }
    }

    public void modifyWord(Scanner scan) {
        System.out.print("수정할 단어를 입력하세요 > ");
        String word = scan.next();

        if (map.containsKey(word)) {
            System.out.print("새로운 뜻을 입력하세요(여러 개일 경우 ','로 구분) > ");
            scan.nextLine();
            String meanings = scan.nextLine();
            List<String> meaningList = new ArrayList<>(Arrays.asList(meanings.split(",")));

            map.put(word, meaningList);
            System.out.println("단어가 수정되었습니다.");
        } else {
            System.out.println("해당 단어가 사전에 없습니다.");
        }
    }

    public void deleteWord(Scanner scan) {
        System.out.print("삭제할 단어를 입력하세요 > ");
        String word = scan.next();

        if (map.containsKey(word)) {
            map.remove(word);
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("해당 단어가 사전에 없습니다.");
        }
    }

    public void createFile() throws IOException {
        FileWriter wordNote = new FileWriter("wordNote.txt");

        int i = 1;
        for (Map.Entry<String, List<String>> entry : map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList())) {

            wordNote.write(i + ". " + entry.getKey() + " : ");
            wordNote.write(String.join(", ", entry.getValue()));
            wordNote.write("\r\n");
            i++;
        }

        wordNote.close();
        System.out.println("영단어사전 파일이 생성되었습니다.");
    }
}