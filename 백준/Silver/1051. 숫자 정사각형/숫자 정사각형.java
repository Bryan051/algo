import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        for (int i = 0; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0; j < M ; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }
        
        // 정사각형으로 for 문 범위 줄이기
        // 가장 큰 정사각형 변 길이
        int length = Math.min(N, M);

        while (length > 1 ){
            for (int i = 0; i <= N - length; i++) {
                for (int j = 0 ; j <= M - length; j++) {
                    int num = a[i][j];
                    if (num == a[i][j + length - 1] &&
                            num == a[i + length - 1][j] &&
                            num == a[i + length - 1][j + length - 1]) {
                        System.out.println(length*length);
                        return;
                    }
                }
            }
            length--;
        }
        System.out.println(length*length);
    }
}