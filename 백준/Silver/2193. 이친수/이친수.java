import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 0으로 시작하지 않는다
     * 1이 두번 연속 나타나지 않는다.
     *  1, 10, 100, 101, 1000, 1001, 1010
     *  1=1, 2=1, 3=2, 4=3,
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);

    }
}











