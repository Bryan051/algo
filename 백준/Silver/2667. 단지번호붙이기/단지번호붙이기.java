import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> houseCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        houseCnt = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }


        System.out.println(houseCnt.size());
        Collections.sort(houseCnt);
        for (int h : houseCnt) {
            System.out.println(h);
        }
    }

    static void bfs(int x, int y) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n
                        && !visited[nextX][nextY] && map[nextX][nextY] == 1) {

                    if (map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        count++;
                    }
                }
            }

        }
        houseCnt.add(count);
    }

}