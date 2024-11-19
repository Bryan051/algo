import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 사람(node) 수
        int n = Integer.parseInt(br.readLine());

        // 촌수를 계산해야 하는 서로다른 두 사람의 번호
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 부모 자식들간의 관계의 갯수 m (edge, 간선)
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 간선 갯수 m 만큼. 무방향. x,y 둘다. x 가 y 의 부모.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int ans = bfs(a, b);
        System.out.println(ans);

    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (!visited[next]) {
                    dist[next] = dist[cur] + 1;
                    if (next == end) {
                        return dist[next];
                    }
                    queue.add(next);
                    visited[next] = true;
                }

            }
        }
        return -1;
    }


}
