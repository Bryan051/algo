import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Main {

    /**

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i < 251 ; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
        }

        String input ;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }



}











