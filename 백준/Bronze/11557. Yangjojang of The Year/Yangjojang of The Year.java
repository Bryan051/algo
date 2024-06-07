import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 숫자 t

        String a = null,b = null;
        int x = 0,y = 0;
        for (int i = 0; i < t; i++) {              // t 만큼 입력
            int n = Integer.parseInt(br.readLine()); // 학교 갯수
            for (int j = 0; j < n ; j++) { // 학교갯수만큼 받고 비교
                StringTokenizer st = new StringTokenizer(br.readLine());
                b = st.nextToken();
                y = Integer.parseInt(st.nextToken());
                if (y > x) {
                    x = y;
                    a = b;
                }
            }
            System.out.println(a);
        }

    }
}