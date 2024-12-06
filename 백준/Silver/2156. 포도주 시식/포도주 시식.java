import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    
        dp[0] = 0;
        // dp[i] = dp[i-1] or dp[i-2] + wine[i] or dp[i-3] + wine[i-1] + wine[i]

        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = wine[i];
            else if (i == 2) dp[i] = wine[i] + wine[i-1];
            else {
                dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i]+wine[i-1]));
            }
        }
        System.out.println(dp[n]);
    }
}
