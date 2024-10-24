import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    테트로미노
    테트리스 블록 한개 놓아서 (총 4칸)
    n * m 안에 숫자가 가장 큰 경우를 찾아라
    depth 4에서 stop, 가장 큰 숫자
     */


    static int[][] map;
    static boolean[][] visited;
    static int N, M, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true; // 현재 위치 방문 표시
                dfs(i, j, map[i][j],1); // DFS 탐색 시작
                visited[i][j] = false; // 방문 해제
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int x, int y,int sum, int depth) {

        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            // 격자 범위를 넘어가는지 체크
            if (curX >= 0 && curX < N && curY >= 0 && curY < M
                    && !visited[curX][curY]) {

                visited[curX][curY] = true; // 방문 표시

                // ㅗ 모양 은 순차적으로 찍을때 안만들어짐
                if (depth == 2) {
                    dfs(x, y, sum + map[curX][curY], depth + 1);
                }

                dfs(curX, curY, sum + map[curX][curY],depth + 1); // 다음 위치로 이동
                visited[curX][curY] = false; // 방문 해제

            }

        }
    }


}