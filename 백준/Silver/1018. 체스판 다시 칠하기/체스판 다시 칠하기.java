import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int minValue = Integer.MAX_VALUE;

        // 모든 8x8 크기의 체스판 영역을 확인
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                minValue = Math.min(minValue, find(arr, i, j));
            }
        }

        System.out.println(minValue);

    }

    static int find(char[][] board, int row, int col) {
        int white = 0;
        int black = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 예상 색깔을 계산
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                // 실제 보드 색깔과 비교
                if (board[row + i][col + j] != expectedW) {
                    white++;
                }
                if (board[row + i][col + j] != expectedB) {
                    black++;
                }

            }
        }

        return Math.min(white, black);
    }



}


