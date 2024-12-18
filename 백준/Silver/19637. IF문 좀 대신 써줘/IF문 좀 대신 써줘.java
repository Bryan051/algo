import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 전투력 기준 칭호
     ex) 10,000 이하 weak, 10,000 ~ 100,000 normal, 100,000 ~ 1,000,000 strong

    2. 칭호 갯수 n , 출력해야하는 캐릭터 갯수 m
    3. n 개 줄에 칭호' '기준숫자
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] rank = new String[n];
        int[] power = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rank[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;
                // cur 값이 전투력 power 보다 높으면 랭크 범위(미만)에서 벗어나므로
                // low 값을 mid + 1 로 높인다.
                if (power[mid] < cur) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(rank[left]).append("\n");

        }
        System.out.println(sb);

    }


}












