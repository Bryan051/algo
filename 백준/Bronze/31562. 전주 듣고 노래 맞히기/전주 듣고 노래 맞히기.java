import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 아는 노래 갯수 n
        int m = Integer.parseInt(st.nextToken()); // 시도할 노래 갯수 m

        // 길이 t, 노래 제목 s, 계이름 a 공백포함 7개.
        String s ;
        String a ;
        // Map<String, String> map = new HashMap<>();
        // 이렇게 하면 list 에 담는 하나의 map 이 되기 때문에 중복 key 넣을 수 없음
        // a 를 중복으로 넣을거임 // 매번 새로운 map을 만들어줄거임
        // List<Map<String, String>> list =new ArrayList<>();
        // list.add(map); // 각 map을 list에 저장 // key 를 a 로, value 를 이름으로 각 map 에 저장.

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            StringTokenizer st1 = new StringTokenizer(string);

            int t = Integer.parseInt(st1.nextToken()); // 길이

            s = st1.nextToken(); // 노래 제목 저장

            StringBuilder sb = new StringBuilder(); // 공백제거후 build
            for (int j = 0; j < 3; j++) { // 어차피 3개만 비교할거라 3개만 저장.
                sb.append(st1.nextToken());
            }
            a = sb.toString();

            map.put(s, a);
        }

        // m 개 중  ("E D E") 한번씩 비교와 동시에
        // 동일한 노래가 하나만 있다면 해당 노래의 제목을, 두 개 이상이면 ?을, 없다면 !을 한 줄에 하나씩
        String b ; // 받아올 문제 계이름 배열
        for (int i = 0; i < m; i++) {
            String string = br.readLine();
            StringTokenizer st2 = new StringTokenizer(string);
            StringBuilder sb = new StringBuilder();

            // 계이름 받아서 공백없는 한문장으로
            for (int j = 0; j < 3 ; j++) {
                sb.append(st2.nextToken());
            }
            b = sb.toString();


            // 중복체크
            int count = 0;
            for (String val : map.values()) {
                if (val.equals(b)) {
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("!");

            } else if (count == 1) {
//                String B = b;
//                System.out.println(map.entrySet().stream()
//                        .filter(entry -> Objects.equals(entry.getValue(), B))
//                        .map(Map.Entry::getKey)
//                        .collect(Collectors.toList())
//                );

                String ans;
                for (Map.Entry<String, String> mp : map.entrySet()) {
                    if (mp.getValue().equals(b)) {
                        ans = mp.getKey();
                        System.out.println(ans);
                    }
                }

            }else {
                System.out.println("?");

            }

        }
    }
}