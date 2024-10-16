import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] arr;
    static int inputY, inputX;

    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로
        inputX = Integer.parseInt(st.nextToken());
        //세로
        inputY = Integer.parseInt(st.nextToken());

        arr = new int[inputY][inputX];

        for (int i = 0; i < inputY; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < inputX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }


        bfs();
        check();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tx = tmp[0];
            int ty = tmp[1];

            for (int i = 0; i < 4; i++) {

                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && ny >= 0 && nx < inputY && ny < inputX) {
                    if (arr[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        arr[nx][ny] = arr[tx][ty] + 1;
                    }
                }
            }

        }
    }

    static void check() {
        int days = 0;

        for (int i = 0; i < inputY; i++) {
            for (int j = 0; j < inputX; j++) {
                // bfs 가 거치지 못했으므로 모든 토마토가 익지 못하는 상황
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, arr[i][j]);
            }
        }

        if (days == 1)
            System.out.println(0);
        else {
            System.out.println(days - 1);
        }

    }


}