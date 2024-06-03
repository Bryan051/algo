import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 생성
        // W true , B false
        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        // 8*8 몇개인지 갯수 row, col
        // 8*8 bw 확인 메소드로 넘겨줌
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);

    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // B,W 첫칸 색
        boolean BW = arr[x][y];

        // b, w 고려 8*8 bw 확인. b 버전, w 버전 나눠서.
        // 8*8 갯수 맞춰 배열시작점 = x, y
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 시작을 기준으로 다르면 다바꿈 BW 랜덤.->
                // 추후 -64 해서 작은게 최소
                if (arr[i][j] != BW) {
                    // 바꿔준거 카운트
                    count++;
                }
                // 바꿔주기, 안해도되긴함
                BW = (!BW);
            }
            // 다음 줄은 다른색으로 진행
            BW = !BW;
        }

        // count 가 b,w 중 하나의 기준.
        // 8*8의 경우의 수인 64 - count 해서 둘중 작은수 채택
        count = Math.min(count, 64 - count);
        
        min = Math.min(min, count);
        
    }

}