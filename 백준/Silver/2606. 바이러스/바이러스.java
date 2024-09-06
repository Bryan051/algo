
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] map;
    static boolean[] check;
    static int count = 0;

    public static int dfs(int i) {
        check[i] = true;

        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && check[j] == false) {
                count++;
                dfs(j);
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 컴퓨터 수 정점, 노드
        n = Integer.parseInt(br.readLine());
        // 1대1로 연결된 컴퓨터 수, 간선
        k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));

    }


}