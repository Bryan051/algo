import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1 <= n <= 100
        int n = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;

        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1; //1자리 계단 수
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) { //0으로 시작하는 계단 수
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) { //9로 시작하는 계단 수
                    dp[i][j] = dp[i - 1][8] % mod;
                } else { //2 ~ 8 로 시작하는 계단 수
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        System.out.println(ans);
    }


}