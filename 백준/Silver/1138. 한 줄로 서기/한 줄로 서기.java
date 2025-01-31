import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     자기보다 큰 사람이 왼쪽에 몇명 있었는지만 기억



     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 키큰사람순으로 넣음
        // 내 앞에 (왼쪽) 몇명 < 인덱스 > , 내 키 < 벨류 >
        // 인덱스 중복 허용, 순서대로 입력들어감.
        for (int i = n ; i >= 1; i--) {
            ans.add(arr[i], i);
        }
        // 2 1 1 0 -> 0 1 1 2 순으로 바뀌고
        // 4 / 43 / 423 / 4231 순으로 저장됨
        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}

