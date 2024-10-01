import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 유저의 수
        int n = Integer.parseInt(st.nextToken());
        // 관계 수
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 케빈 베이컨 수를 찾을 변수 초기화
        int minKevinBacon = Integer.MAX_VALUE;
        int person = -1;

        for (int i = 1; i <= n; i++) {
            int kevinBaconNumber = bfs(i, graph, n);

            // 케빈 베이컨 수가 더 작은 사람을 찾을 경우 갱신
            if (kevinBaconNumber < minKevinBacon) {
                minKevinBacon = kevinBaconNumber;
                person = i;
            }
        }
        System.out.println(person);
    }

    public static int bfs(int start, ArrayList<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    // 붙은거 거리 +1
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        // 모든 노드에 대한 거리를 더한 값을 반환
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += distance[i];
        }
        return sum;
    }


}
