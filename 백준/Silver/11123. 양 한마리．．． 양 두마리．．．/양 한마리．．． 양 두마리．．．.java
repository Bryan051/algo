import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 전투력 기준 칭호
     ex) 10,000 이하 weak, 10,000 ~ 100,000 normal, 100,000 ~ 1,000,000 strong

    2. 칭호 갯수 n , 출력해야하는 캐릭터 갯수 m
    3. n 개 줄에 칭호' '기준숫자
     */

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] grid;
    static int h, w, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            grid = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    if (s.charAt(j) == '#') {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }

            ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(ans);

        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny] && grid[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }

            }


        }


    }


}












