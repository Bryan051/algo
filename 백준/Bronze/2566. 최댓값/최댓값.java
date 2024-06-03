import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] A = new int[9][9];
        int max = 0;
        int idx1 = 0, idx2 = 0;

        for (int i = 0; i < 9 ; i++) {
            StringTokenizer a = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                A [i][j] = Integer.parseInt(a.nextToken());
            }
        }

        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if (A[i][j] >= max) {
                    max = A[i][j];
                    idx1 = i+1;
                    idx2 = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(idx1 +" "+ idx2);
    }
}