import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        int[][] sumArr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = Math.max(sumArr[i - 1][j - 1], sumArr[i - 1][j]) + arr[i][j];
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (answer < sumArr[N][i]) {
                answer = sumArr[N][i];
            }
        }

        System.out.println(answer);

    }


}