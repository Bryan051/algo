import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 자주 나오는 단어일수록 앞에 배치.
    2. 해당 단어의 길이가 길 수록 앞에 배치.
    3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치.
    4. m 이상의 길이의 단어들만 외운다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        //지문 단어 갯수
        int n = Integer.parseInt(st.nextToken());
        // 외울 단어의 길이 기준
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // map 에서 단어들(keySet)을 가져와서 arraylist 에 저장.
        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 빈도수 = map.get(key) 내림차순
                if (!map.get(o1).equals(map.get(o2))) {
                    return map.get(o2) - map.get(o1);
                }
                // 2. 길이 내림차순
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 3. 사전순
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
        

    }

}












