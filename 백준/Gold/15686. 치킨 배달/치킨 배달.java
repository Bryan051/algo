import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
    0,1,2 - 빈집, 집, 치킨
    집 < 2N , 최소 1개.
    M <= 치킨 <= 13

    N * N 개 도시
    M 개 = 최대 치킨 집,

     */

    static int n, m;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        solution(0, 0, new int[m][2]);
        System.out.println(answer);

    }

    /*
     dfs + 백트래킹
     1. 집과 치킨집의 좌표를 각각의 list 에 저장 해 둔다.
     2. 치킨집이 open 한 갯수와 m 이 같다면, 모든 집에 대해 m 개의 치킨집 중 최단거리를 계산한다.
     3. 탐색을 시작하는 지점이 치킨집 list 사이즈를 벗어나면 탐색을 종료한다.
     */
    static void solution(int start, int cnt, int[][] arr) {
        if (cnt == m) {
            int res = 0;
            for (int[] house : houses) {
                int temp = Integer.MAX_VALUE;
                // 어떤 집과 치킨집 중 open 한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int[] chicken : arr) {
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    temp = Math.min(temp, dist);
                }
                res += temp;
            }
            answer = Math.min(answer, res);
            return;
        }
        // 백트래킹
        for (int i = start; i < chickens.size(); i++) {
            arr[cnt] = chickens.get(i);
            solution(i + 1, cnt + 1, arr);
        }
    }



}












