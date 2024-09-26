import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    /*
    (땅 고르기) 1칸 없애고 인멘토리에 넣기 - 2초
    인멘토리에서 꺼내 땅 위에 쌓기 - 1초
    고르는데 걸리는 시간, 땅을 고른 후 가장 높은 땅의 높이 출력
     */
    static int[][] ground;
    static int n;
    static int m;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        // n x m 마크 땅
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 인벤토리 안에 들어있는 블록 수
        b = Integer.parseInt(st.nextToken());

        ground = new int[n][m];
        int max = 0, min = 256;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a < min) min = a;
                if (a > max) max = a;
                ground[i][j] = a;
            }
        }

        int min_time = Integer.MAX_VALUE;
        int max_height = 0;
        for (int height = min; height <= max; height++) {
            int plus_count = 0;
            int del_count = 0;
            int temp_b = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ground[i][j] < height) {
                        plus_count += height - ground[i][j];
                        temp_b -= height - ground[i][j];
                    } else if (ground[i][j] > height) {
                        del_count += ground[i][j] - height;
                        temp_b += ground[i][j] - height;
                    }
                }
            }
            if (temp_b < 0) {
                continue;
            }
            int time = del_count * 2 + plus_count;
            if (time <= min_time && height >= max_height) {
                min_time = time;
                max_height = height;
            }
        }

        System.out.println(min_time + " " + max_height);

    }

}
