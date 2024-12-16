import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 작 -> 큰 상자 순으로 넣을 수 있음.
    2. 한 번에 넣을 수 있는 최대의 상자 개수를 출력하는 프로그램을 작성하시오.
    LIS 최장증가수열, dp 문제
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int ans = Integer.MIN_VALUE;
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // arr[j] < arr[i] 인 경우 이전 dp와 비교 가능
                // dp[i] < dp[j] + 1 이어야 한다 (갯수가 같거나 작아야한다 )
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(ans);
    }
}

