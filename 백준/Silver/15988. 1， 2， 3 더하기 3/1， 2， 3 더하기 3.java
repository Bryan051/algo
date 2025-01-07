import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    dp[1] = 1   1개
    dp[2] = 2 / 1,1     2개
    dp[3] = 1,1,1, / 1,2 / 2,1 / 3      4개

    dp[4] = dp[1] 에 3 더해 준 값 (가짓수 같음)
            + dp[2] 에 2 더해 준 (가짓수 같음)
            + dp[3] 에 1 더해 준 (가짓수 같음)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;

        long[] dp = new long[1_000_001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001 ; i++) {
            dp[i] = ( dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod ;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);

        }




    }

}












