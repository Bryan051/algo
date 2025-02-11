import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
     보기 편하게 확장자들을 사전 순으로 정렬해 줘
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");

            st.nextToken();
            String extension = st.nextToken();

            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.print(sb);
    }
}











