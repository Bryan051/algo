import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // 딸0, 초1, 바2
        // 0,1,2 순으로 도는데 a 먹은 후 b 가 아니면 다른가게 다 지나침

        int cnt = 0;
        int next = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == next && next == 0) {
                cnt++;
                next = 1;
            }
            if (x == next && next == 1) {
                cnt++;
                next = 2;
            }
            if (x == next && next == 2) {
                cnt++;
                next = 0;
            }
        }
        System.out.println(cnt);
    }

}