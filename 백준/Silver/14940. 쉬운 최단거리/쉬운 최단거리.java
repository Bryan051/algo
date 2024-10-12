import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    0 은 갈 수 없는 땅.
    1 은 갈 수 있는 땅,
    2 는 목표지점. 단 한개.
    각 지점에서 목표지점까지의 거리를 출력.
    원래 갈 수 없는 위치는 0
    갈 수 있는 땅인 부분 중 도달할 수 없는 위치는 -1 ( 0 에 가로막힌)

    2 가 목표지점이라고 말했으나 각 점에서 2에 도달할 수 있는 경우의 수를 찾는 것이므로
    2를 시작점으로 나머지 좌표로 뻗어나간다
     */

    static int[][] graph;
    static int[][] result;
    static boolean [][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 세로
        n = Integer.parseInt(st.nextToken());
        // 가로
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 시작점 찾기
                if (graph[i][j] == 2) {
                    x = i;
                    y = j;
                }// 시작점 체크
                else if (graph[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        bfs(x, y);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 아예 접근이 안됨, 방문한적이 없음
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[0] + dx[i];
                int nextY = tmp[1] + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        result[nextX][nextY] = result[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

}