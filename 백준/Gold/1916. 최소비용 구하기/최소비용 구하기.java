import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class info implements Comparable<info>{
        int node, value;
        public info(int node, int value){
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(info o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<info>> graph = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph.get(s).add(new info(e, val));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int ans = search(s, e, graph, n);
        System.out.println(ans);

    }

    static int search(int start, int end, ArrayList<ArrayList<info>> graph, int size) {
        PriorityQueue<info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[size + 1];
        pq.add(new info(start, 0)); // 시작 도시 저장

        // 최단 거리 탐색
        while (!pq.isEmpty()) {
            info cur = pq.poll();
            visited[cur.node] = true; // 방문처리

            if (cur.node == end) { // 최초 목적 도시 도착
                return cur.value;
            }
            // 버스 경로 탐색
            for (info next : graph.get(cur.node)) {
                if (!visited[next.node]) { // 방문하지 않았던 도시일 때
                    pq.add(new info(next.node, cur.value + next.value));
                }
            }
        }
        return -1; // 해당 도시에 도착하지 못할 때
    }


}
