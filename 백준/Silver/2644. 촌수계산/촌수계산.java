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
        StringBuilder sb = new StringBuilder();

        // 전체 사람 node의 수 N
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 계산해야하는 번호 두개 a,b
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // 부모자식관계 갯수 m = edge 간선

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 간선 갯수 m 만큼 . 무방향 이므로 x,y 둘다. x가 y의 부모
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int ans = bfs(a,b); // 시작,끝
        System.out.println(ans);

    }

    private static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        visited[start] = true;

        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (!visited[next]) {
                    dist[next] = dist[cur]+1;
                    if (next == end) {
                        return dist[next];
                    }
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}