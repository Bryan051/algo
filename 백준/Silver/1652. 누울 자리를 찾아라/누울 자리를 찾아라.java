import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 줄단위가 아니었음. 최소 2개면 다 카운트.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 방 구조
        char [][] r = new char[101][101];

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < n ; i++) {
            String str = br.readLine();
            for (int j = 0; j < n ; j++) {
                r[i][j] = str.charAt(j);
            }
            // 맨 끝 + 1은 전부 X 로
            // 진행하다 X 에 닿으면 count가 올라가야함.
            r[i][n] = r[n][i] = 'X';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1 ; j++) {

                // 진행하다 X벽이 닿으면 count가 올라감.
                // 맨 끝 벽을 X 로 만들어 놨음.
                // '.' 두개 연속 + X 에 닿아야 rowCount (2칸 이상 방 무시, 마지막에 카운트)
                // 가로
                if (r[i][j] == '.' && r[i][j + 1]=='.' && r[i][j + 2]=='X') {
                    rowCount++;
                }
                // 세로
                if (r[j][i] == '.' && r[j+1][i]=='.' && r[j + 2][i]=='X') {
                    colCount++;
                }
            }
        }
        System.out.println(rowCount +" "+ colCount);
    }
}
