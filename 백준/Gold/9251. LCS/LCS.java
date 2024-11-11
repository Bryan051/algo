import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();

        int[][] dp = new int[st1.length() + 1][st2.length() + 1];

        for (int i = 1; i <= st1.length(); i++) {
            for (int j = 1; j <= st2.length(); j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[st1.length()][st2.length()]);
    }


}