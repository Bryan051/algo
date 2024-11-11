import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1번 집은 2번 집의 색과 같지 않아야 헌더
    n 번 집의 색은 n-1 번 집의 색과 같지 않아야 한다
    i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
    집의 수
    빨 초 파 비용
    모든 집 칠하는 비용의 최소
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파
        }

        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 빨
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 초
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 파
        }

        int result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(result);
    }


}