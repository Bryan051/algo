import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        // 물품 수
        int n = Integer.parseInt(st.nextToken());
        // 버틸 수 있는 무게
        int k = Integer.parseInt(st.nextToken());

        int[][] bag = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 물건 무게
            int w = Integer.parseInt(st.nextToken());
            // 물건 가치
            int v = Integer.parseInt(st.nextToken());

            bag[i][0] = w;
            bag[i][1] = v;
        }


        for (int i = 1; i < n + 1 ; i++) {     // 갯수
            for (int j = 1; j < k + 1 ; j++) {     // 무게
                if (j - bag[i][0] >= 0) { // 현 무게에서 이번 턴의 아이템의 무게를 뺐을 때 남는 무게가 존재하면
                    // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bag[i][0]] + bag[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }

}
