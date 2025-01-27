import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * n 개 헛간 중 하나에 숨어야한다. 1부터 센다.
     * <p>
     * 1부터 찾을걸 알고 있다.
     * <p>
     * 모든 헛간은 m 개의 양방향 길로 이어져 있다.
     * 그 양 끝을 a_i 와 b_i 로 나타낸다.
     * 어떤 헛간에서 다른 헛간으로 언제나 도달 가능 ( 양방향 ), 헛간사이 길이 1
     * <p>
     * 1번에서 가장 거리가 먼 헛간에서 숨을 것.
     * <p>
     * 1. 숨어야 하는 헛간 번호 ( 같은 거리라면 작은 번호 )
     * 2. 그 헛간까지의 거리
     * 3. 그 헛간과 같은 거리를 갖는 헛간의 갯수 출력
     */

    static ArrayList<Integer> list[];
    static boolean[] visited;
    static int n, m;
    static int destination, distance, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        // m 줄에 걸쳐 a_i 와 b_i 가 공백으로 주어짐
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        destination = 0;
        distance = 0;
        count = 1;
        bfs(1, 0);
        System.out.println(destination+" "+distance+" "+count);
    }

    public static void bfs(int start, int val) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, val});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cur = arr[0];
            int next = arr[1];

            // 현재 거리가 기존 최장 거리보다 더 멀다면
            if (next > distance) {
                distance = next;
                destination = cur;
                count = 1;
            }
            else if (next == distance) {
                if (destination > cur) destination = cur;
                count++;
            }

            for(int i=0;i<list[cur].size();i++){
                int otherWay = list[cur].get(i);
                if(!visited[otherWay]){
                    visited[otherWay] = true;
                    queue.offer(new int[]{otherWay,next+1});
                }
            }


        }
    }


}








