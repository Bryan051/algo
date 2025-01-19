import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class IceBerg {
    int x;
    int y;

    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    /*
    빙산 - 동서남북 0 갯수만큼 녹는다
     */


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        // 빙하 2개 이상 분리 될 경우 반복문 종료
        // 빙하가 다 녹아버렸을 경우 0
        while ((cnt = countIceberg()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }
            bfs();
            ans++;
        }

        System.out.println(ans);


    }

    public static int countIceberg() {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited); // 총 몇개의 빙하로 이루어 졌는지
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx,ny,visited);
            }

        }

    }

    public static void bfs() {
        Queue<IceBerg> queue = new LinkedList<>();

        // visited 없으면 과정상 먼저 녹아 없어져 0 이 된 자리도
        // 0 으로 카툰트함
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            IceBerg ice = queue.poll();

            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    seaNum++;
                }
            }
            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
