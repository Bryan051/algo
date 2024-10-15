import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    static int[] dy = { 1, -1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static int[][][] arr;
    static int inputX, inputY, inputZ;

    static Queue<point> queue = new LinkedList<>();

    static class point {
        int x, y, z;

        point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        // 가로
        inputY = Integer.parseInt(st.nextToken());
        //세로
        inputX = Integer.parseInt(st.nextToken());
        inputZ = Integer.parseInt(st.nextToken());

        arr = new int[inputZ][inputX][inputY];
        for (int k = 0; k < inputZ; k++) {
            for (int i = 0; i < inputX; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < inputY; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1) {
                        queue.add(new point(k,i,j));
                    }
                }
            }
        }

        bfs();
        check();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            point tmp = queue.poll();
            int tz = tmp.z;
            int tx = tmp.x;
            int ty = tmp.y;

            for (int i = 0; i < 6; i++) {
                int nz = tz + dz[i];
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < inputX && ny < inputY && nz < inputZ) {
                    if (arr[nz][nx][ny] == 0) {
                        queue.add(new point(nz, nx, ny));
                        arr[nz][nx][ny] = arr[tz][tx][ty] + 1;
                    }
                }


            }

        }
    }

    static void check() {
        int days = 0;
        for (int k = 0; k < inputZ; k++) {
            for (int i = 0; i < inputX; i++) {
                for (int j = 0; j < inputY; j++) {
                    if (arr[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, arr[k][i][j]);
                }
            }
        }
        if (days == 1)
            System.out.println(0);
        else {
            System.out.println(days - 1);
        }

    }


}