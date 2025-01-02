import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    n * m 미로.
    맨 왼쪽 위 1,1 / 가장 오른쪽 아래 n, m
    r,c 에 있으면 +1, 0 / 0, +1 / +1, +1 이동 가능.
    방에 놓여진 사탕을 모두 가져갈 수 있다.
    사탕 갯수의 최댓값을 구하라.
     */

    static int[][] maze;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                dp[i][j] = maze[i][j] +
                        Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        System.out.println(dp[n][m]);
    }
}
