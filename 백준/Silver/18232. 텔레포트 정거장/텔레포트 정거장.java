import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, s, e, ans;
    static ArrayList<ArrayList<Integer>> teleport;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        // 1부터 n 까지 각 점에 하나의 텔포
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 출발지
        s = Integer.parseInt(st.nextToken());
        // 목적지
        e = Integer.parseInt(st.nextToken());

        teleport = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            teleport.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 연결정보, 중복 없음.
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            teleport.get(x).add(y);
            teleport.get(y).add(x);
        }
        visited = new boolean[n + 1];


        bfs();


    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s,0});
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPos = cur[0];
            int dist = cur[1];

            if (curPos == e) {
                System.out.println(dist);
                return;
            }

            if (curPos - 1 > 0 && !visited[curPos - 1]) {
                visited[curPos - 1] = true;
                queue.add(new int[]{curPos - 1,  dist + 1});
            }
            if (curPos + 1 <= n && !visited[curPos + 1]) {
                visited[curPos + 1] = true;
                queue.add(new int[]{curPos + 1,  dist + 1});
            }
            for (int i : teleport.get(curPos)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, dist + 1});
                }
            }

        }
    }
}

