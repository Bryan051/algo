import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        // 사다리의 수
        int N = Integer.parseInt(st.nextToken());
        // 뱀의 수
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 각 칸의 목적지 ( 수정전 )
        }

        // 사다리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; // x 번 칸 사다리 -> y
        }

        // 뱀
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v; // u 번 칸 뱀 -> v
        }
        System.out.println(bfs(board));

    }

    public static int bfs(int[] board) {
        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0}); // 시작점 1, 주사위 0
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int position = tmp[0];
            int roll = tmp[1];

            if (position == 100) return roll;

            for (int i = 1; i <= 6; i++) {
                int nextPos = position + i;

                if (nextPos > 100) continue;

                // 사다리나 뱀이 있는 위치
                nextPos = board[nextPos];

                // 방문하지 않은 칸이면 이동
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, roll + 1});
                }
            }
        }
        return -1;
    }
}