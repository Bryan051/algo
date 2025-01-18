import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*

     */
    static int n, s, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];
        int MOD = 10007;

        // 길이가 1인 경우, 각 숫자(0~9)에서 끝나는 오르막 수는 1개씩 존재
        Arrays.fill(dp[1], 1);

        // 길이 n에 대해 오르막 수 계산
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;  // 나머지 연산 적용
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10 ; i++) {
            ans += dp[n][i];
        }
        System.out.println(ans % MOD);
    }

}


