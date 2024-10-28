import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트
        List<List<Integer>> adjList = new ArrayList<>();
        int[] parents = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        // 인접 리스트 초기화
        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adjList.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parents[next] = cur;
                }
            }
        }

        for (int i = 2; i <= N ; i++) {
            System.out.println(parents[i]);
        }

    }


}