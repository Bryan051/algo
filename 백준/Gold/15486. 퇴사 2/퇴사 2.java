import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
     보기 편하게 확장자들을 사전 순으로 정렬해 줘
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N + 1 까지. 자신의 일차 + P 이니까.

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = 0;

        for (int i = 1; i <= N ; i++) {
            maxProfit = Math.max(maxProfit, dp[i]);

            int nextDay = i + T[i]; // 상담 끝나는 날
            if (nextDay <= N + 1) {
                dp[nextDay] = Math.max(dp[nextDay], maxProfit + P[i]);
            }
        }

        System.out.println(Math.max(maxProfit, dp[N + 1]));


    }
}











