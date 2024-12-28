import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    1. 맥주 박스 총 20
    2. 50미터에 한병씩 마심
    3. 출발 및 중간 편의점 나가기 전에 -1
    4. 편의점에서만 빈병 버릴 수 있음
    5. 집, 편의점, 목표지 좌표 x,y
    6. 가능하면 happy, 안되면 sad
     */


    static int[][] map;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            // 편의점 갯수
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 2];
            map = new int[n + 2][2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            if (bfs()) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }

        }
        System.out.println(sb);
    }

    public static boolean bfs(){
        Queue<Integer> queue = new LinkedList<>();
        // 시작 숫자. 0번 = 상근이 집
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int curX = map[currentNode][0];
            int curY = map[currentNode][1];

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i]) {
                    int targetX = map[i][0];
                    int targetY = map[i][1];
                    int dist = Math.abs(targetX - curX) + Math.abs(targetY - curY);
                    // 맥주 20병의 거리
                    if (dist <= 1000) {
                        queue.add(i);
                        visited[i] = true;
                        // 페스티벌 도착
                        if (i == n + 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}


