import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[A + 1];
        int[] dp = new int[A + 1];
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < A; i++) {
            dp[i] = 1;
            // i 이전 원소들중
            for (int j = 0; j < i; j++) {
                // j 번 ( i - 1 번째 이하의) 원소가 i 값보다 작으면서
                // i 번째 dp 가 j 번째 dp + 1 보다 작은 경우
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    // i 번째 dp 가 j 번째 dp 의 + 1  값이 된다.
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < A; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }


}