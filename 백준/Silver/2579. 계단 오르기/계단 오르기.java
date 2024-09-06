
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한번에 한칸 혹은 두칸만
        // 1 + 1 + 1 안됨
        // 마지막 무조건 밟아야됨

        int n = Integer.parseInt(br.readLine());

        // 계단을 밟은 횟수가 n 을 넘을 순 없음
        int[] step = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = step[1];
        if (n >= 2) {
            dp[2] = step[1] + step[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i-1])+ step[i];
        }

        System.out.println(dp[n]);

    }

}
