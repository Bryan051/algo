import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 행렬 크기 n * m
    // 행렬 A의 원소 M개 B의 원소 M개가 차례대로.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];
        int[][] B = new int[n][m];

        for (int i = 0; i < n ; i++) {
            StringTokenizer a = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A [i][j] = Integer.parseInt(a.nextToken());
            }
        }

        for (int i = 0; i < n ; i++) {
            StringTokenizer a = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                B [i][j] = Integer.parseInt(a.nextToken());
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + B[i][j] + " ");
                if (j == m - 1) {
                    System.out.println();
                }
            }
        }
    }
}
