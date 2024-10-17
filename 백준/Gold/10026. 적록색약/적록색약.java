import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static String s;
    static char[][] arr;
    static boolean[][] visited;
    static int N;

    static Queue<int[]> queue = new LinkedList<>();

    /*
     적록색약 - 인접한 블록이 R 혹은 G 일때 + 1 , b 일때 + 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        // 색약없음
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.print(cnt + " ");

        // 색약 있음
        cnt = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G'; // R을 G로 바꿈
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.print(cnt);
    }

    static void bfs(int x, int y) {
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tx = tmp[0];
            int ty = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N
                        && !visited[nx][ny] && arr[tx][ty] == arr[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }


}