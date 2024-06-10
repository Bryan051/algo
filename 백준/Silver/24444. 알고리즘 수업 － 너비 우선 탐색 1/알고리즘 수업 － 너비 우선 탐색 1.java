import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int cnt;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // vertex = N edge = M , undirected edge, =1
        // start = R

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 오름차순 정렮
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(r); // 시작노드

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        // 시작 정점 방문순서는 1
        cnt = 1;

        q.offer(node);
        visited[node] = cnt++;

        while (!q.isEmpty()) {
            int a = q.poll();
            for (int i = 0; i < graph.get(a).size(); i++) {
                int next = graph.get(a).get(i);

                if (visited[next] != 0) {
                    continue;
                }
                q.offer(next);
                visited[next] = cnt++;

            }
        }


    }
}