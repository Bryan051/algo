import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //  바둑판 넘어가는 범위 padding 두어 로직 체크 생략
    static int[][] board = new int[21][21];
    //  dfs 재귀탐색
    static int[][][] memo = new int[21][21][4];
    // 탐색 방향 - 오목판 입력, 가장 왼쪽의 점 출력 위해 좌상단 - 아래로 탐색
    //                  기존 i,j축에서 j,i축으로 변경했다고 생각하고 탐색.
    //                  하,우하,우,우상
    static int[] dx = { 1, 1, 0,-1 };
    static int[] dy = { 0, 1, 1, 1 };
    //  오목판 입력, 가장 왼쪽의 점 출력 위해 좌상단 - 아래로 탐색

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(find());

    }

    public static String find() {
        for (int j = 1; j <=19; j++) {
            for (int i = 1; i <=19 ; i++) {
                if (board[i][j] != 0) {
                    for (int d = 0; d <4 ; d++) {
                        if (memo[i][j][d] == 0 && calc(i, j, d, board[i][j]) == 5) {
                            return board[i][j] + "\n" + i + " " + j + "\n";
                        }
                    }
                }
            }
        }
        return "0";
    }

    public static int calc(int x, int y, int dir, int color) {
        // x방향(아래) / y 방향 (우측)
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (board[nx][ny] == color) {
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
        }
        return 1;
    }
}