import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    L 육지 W 바다 / 상하좌우로 이웃한 육지로만 이동 가능, 한칸에 한시간.
    보물은 최단거리로 이동하는데 가장 긴 시간이 걸리는 육지 두곳에 나뉘어있다.
    ( 섬이 여러개라도 그 중 돌아가지 않고 가장 긴 최단거리를 구하라 )
    최단거리는 같은곳을 두번이상, 돌아가면 안된다.
     */

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int maxDistance = 0;

        // 모든 육지에서 BFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }
        System.out.println(maxDistance);

    }
    // BFS 를 이용한 최단 거리 탐색
    public static int bfs(int startX, int startY) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 0});

        visited[startX][startY] = true;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            maxDist = Math.max(maxDist, dist);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        // 방문하지 않았고, 육지라면
                        && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return maxDist;
    }






}












