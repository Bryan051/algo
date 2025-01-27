import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /*
    n 명 병사가 무작위 나열. 전투력이 높은 병사가 앞쪽으로 내림차순 배치 하고싶음
    열외 시키는 방법을 이용, 남은 병사의 수가 최대가 되고싶음
    9 8 1 6 2 4 -> 9864
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] soldier = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // 감소하는 최장길이의 부분수열 구하기
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 그 이전값들만 비교
            for (int j = 0; j < i; j++) {
                // 이전값이 지금 값보다 크다면
                if (soldier[j] > soldier[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(n - res);

    }

}












