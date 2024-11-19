import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs();

    }

    static void bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{n, 0});
        visited[n] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int position = cur[0];
            int time = cur[1];

            if (position == k) {
                System.out.println(time);
                return;
            }

            int teleport = position * 2;
            if (teleport > 0 && teleport <= 100000 && !visited[teleport]) {
                visited[teleport] = true;
                deque.addFirst(new int[]{teleport, time});
            }

            int[] walk = {position - 1, position + 1};
            for (int newPosition : walk) {
                if (newPosition >= 0 && newPosition <= 100000 && !visited[newPosition]) {
                    visited[newPosition] = true;
                    deque.addLast(new int[]{newPosition, time + 1});
                }
            }


        }
    }

}
