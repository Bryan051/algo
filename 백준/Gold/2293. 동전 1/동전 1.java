import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 유기농배추
     * 상하좌우 인접
     * 모여있으면 한마리로 충분
     */

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 종류 갯수
        int K = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= K ; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[K]);
    }



}











