import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 영역전개
     * k 개 줄에 직사각형 왼쪽아래꼭짓점 x,y 좌표, 오른쪽 위 x,y 좌표가 주어짐
     * 모눈종이 왼쪽아래가 0,0 / 오른쪽 위가 n,m
     * k 개 분리된 영역 제외
     * 영역갯수 출력 \n
     * 각 영역의 넓이
     *
     * 문제에서 모눈종이는 왼쪽 아래가 (0, 0)
     * 2차원배열은 왼쪽 위가 (0, 0)
     */

    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // y, x 순으로 주어짐
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2 ; y++) {
                for (int x = x1; x < x2 ; x++) {
                    map[y][x] = 1; // 왼쪽 위 시작
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 직사각형 내부 좌표가 아닐때
                if (!visited[i][j] && map[i][j] == 0) {
                    int ans = bfs(i, j);
                    list.add(ans);
                }
            }
        }

        Collections.sort(list);
        int x = list.size();
        sb.append(x).append("\n");

        for (int i = 0; i < x; i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (0 <= nX && 0 <= nY && nX < m && nY < n) {
                    if (!visited[nX][nY] && map[nX][nY] == 0) {
                        visited[nX][nY] = true;
                        queue.add(new int[]{nX, nY});
                        cnt++;
                    }
                }
            }

        }
        return cnt;
    }

}











