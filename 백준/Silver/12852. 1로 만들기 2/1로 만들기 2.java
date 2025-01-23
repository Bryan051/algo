import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    x % 3 == 0 이면 3 으로 나눔
    x % 2 == 0 이면 2 로 나눔
    1을 밴다

    n 이 주어졌을 때 위 3가지 연산으로 1을 만드려고 함

    첫째줄 연산 사용 최솟값 출력
    둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] trace = new int[n+1];

        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n ; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            // 2로 나눠지는 경우
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
            // 3으로 나눠지는 경우
            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1){
                dp[i] = dp[i/3]+1;
                trace[i] = i/3;
            }

        }
        System.out.println(dp[n]);
        while (n > 0) {
            sb.append(n + " ");
            n = trace[n];
        }
        System.out.println(sb);
    }








}












