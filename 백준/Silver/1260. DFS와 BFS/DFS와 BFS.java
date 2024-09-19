
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int m, n, v;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 시작 정점, 양방향
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[n + 1];
        dfs(graph, visited, v, sb);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(graph, visited, v, sb);
        System.out.println(sb);
    }

    static void dfs(int[][] graph, boolean[] visited, int start, StringBuilder sb) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, sb);
            }
        }
    }

    private static void bfs(int[][] graph, boolean[] visited, int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 1; i < graph.length; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    queue.offer(i); //해당 정점 큐에 추가
                    visited[i] = true; //정점 방문 표시
                    sb.append(i).append(" ");
                }
            }
        }
    }
    
}
