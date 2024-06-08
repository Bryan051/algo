import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 이긴 횟수 x
        long x = Integer.parseInt(st.nextToken());
        // 이긴 게임 y
        long y = Integer.parseInt(st.nextToken());

        int z = (int)(y * 100 / x) ; // 현 승률 , 99퍼 99/100 일때 100/101 101/102 ... 무한대

        int ans = -1;

        // ans 가 나누고 나서 소숫값이 커지면 오차가 커지기때문에 double 후 ceil로 올림
        if (z < 99) {
            ans = (int)Math.ceil((100 * y - (z + 1) * x) / (double)(z - 99));
        }
        System.out.println(ans);
    }
}