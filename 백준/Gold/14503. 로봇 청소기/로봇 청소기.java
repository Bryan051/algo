import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 로봇청소기
     * n * m 직사각형
     * 동서남북으로 본다
     * 각 칸은 좌표 r,c
     * 북서가 0,0
     * 남동이 n-1, m-1
     * 1. 현재 칸이 청소되지 않은 경우 청소.
     * 2. 주변 동서남북 중 빈칸이 없는 경우,
     * 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
     * 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
     * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
     * 1. 반시계 방향으로 90도 회전한다.
     * 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
     * 3. 1번으로 돌아간다.
     * <p>
     * 로봇청소기 좌표 r,c 와 방향 d 가 입력된다.
     * 0,1,2,3, 북,동,남,서
     * 칸의 값이 0 이면 청소 안된 상태
     * 1인경우 벽.
     * 테두리는 벽.
     */

    static int[][] arr;
    static int N, M, r, c, d;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int dir) {
        // 청소되지 않은 경우만 청소
        if (arr[x][y] == 0) {
            arr[x][y] = -1;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            // 90 도 돌려서 다음으로 넘김
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M
                    // 청소되지 않은 공간이면 이동
                    && arr[nx][ny] == 0) {
                clean(nx, ny, dir);
                return;
            }
        }
        // 그 이후 네 방향 모두 청소가 완료된 경우 후진
        int dir2 = (dir + 2) % 4; // 후진
        int nx2 = x + dx[dir2];
        int ny2 = y + dy[dir2];
        if (nx2 >= 0 && ny2 >= 0 && nx2 < N && ny2 < M
                && arr[nx2][ny2] != 1) {
            // 보는 방향 그대로 후진, dir2 대신 dir 이 들어간다.
            clean(nx2, ny2, dir);
        }
    }
}
