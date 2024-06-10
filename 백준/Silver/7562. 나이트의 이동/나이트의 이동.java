import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int x, y, a, b, l;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 갯수
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            // 한 변 길이
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());

            arr = new int[l][l];
            visited = new boolean[l][l];

            // 현재칸
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(arr[a][b]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                // 옮긴 자리가 0 이하면 안된다 + 판 크기보다 크면 안된다
                if (ox >= 0 && oy >= 0 && ox < l && oy < l) {
                    if (!visited[ox][oy]) {
                        q.add(new int[]{ox, oy});
                        arr[ox][oy] = arr[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }

            }


        }


    }
}