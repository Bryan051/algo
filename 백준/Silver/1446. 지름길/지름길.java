import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
    지름길 n, 고속도로 길이 d
    n <=12 d <= 10_000
    n 개 줄에 시작위치, 도착위치, 지름길 길이 주어짐

     */

    static int result = Integer.MAX_VALUE;
    static int n, d;
    static List<FastLane> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 지름길 갯수
        d = Integer.parseInt(st.nextToken());   // 고속도로 길이

        map = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작위치 , 도착위치, 길이
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.add(new FastLane(start, end, cost));
        }

        visited = new boolean[map.size()];
        dfs(0, d, 0);
        System.out.println(result);

    }
    public static void dfs(int now, int end, int distance) {
        if (now > end) {
            return;
        }
        else if (now == end) {
            result = Math.min(result, distance);
        }
        else {
            // 고속도로의 끝지점 - 지금까지 온 길) + 지금까지 이동한 거리와 기록을 비교.
            // 현재 조건을 만족하는 지름길이 없거나, 지름길을 선택하지 않았을 때 끝지점까지 이동하는 거리를 구하는 것.
            // 따라서 지름길을 이후에 선택할 수도 있기 때문에 DFS를 종료하지 않는다.
            result = Math.min(result, distance + (end - now));
        }

        // 지름길의 시작지점이 내가 현재 있는 위치와 같은지 판단.
        // 조건에 부합할 경우 지름길의 끝을 우리가 앞으로 시작할 지점으로 넣고, 지나온 거리에 지름길의 값을 넣어줌.
        for (int i = 0; i < map.size(); i++) {
            if (!visited[i]) {
                FastLane fastLane = map.get(i);
                if (fastLane.start == now) {
                    visited[i] = true;
                    dfs(fastLane.end, d, distance + fastLane.cost);
                    visited[i] = false;
                }
            }
        }
        // 지름길을 선택하지 않았다면, 현재 위치+1, 지금까지 지나온 거리+1 을 해줘 1거리 만큼 간 다음 DFS로 넘겨줌.
        dfs(now + 1, d, distance + 1);

    }


    static class FastLane {
        int start, end, cost;
        public FastLane(int x, int y, int z) {
            this.start = x;
            this.end = y;
            this.cost = z;
        }
    }


}

