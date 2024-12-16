import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. n 입력시 함수 호출 횟수 구하라
     */
    
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println(1);
            return;
        }

        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + 1) % 1_000_000_007;
        }
        System.out.println(dp[n]);
    }
}
