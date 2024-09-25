import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph = new int[1001][1001];
    static int n;
    static int m;
    static boolean[] visited = new boolean[1001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        // 정점의 갯수
        n = Integer.parseInt(st.nextToken());
        // 간선의 갯수
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 양 끝점
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 간선 연결
            graph[u][v] = graph[v][u] = 1;
        }

        int ans = 0;

        // dfs
        for (int i = 1; i <= n ; i++) {
            if (visited[i] == false) {
                dfs(i);
                ans ++;
            }
        }

        System.out.println(ans);

    }

    public static void dfs(int index) {
        if (visited[index] == true) {
            return;
        } else {
            visited[index] = true;
            for (int i = 1; i <= n ; i++) {
                if (graph[index][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}