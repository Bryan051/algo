import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // n 수  b 진법
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int n = str.length();

        int b = Integer.parseInt(st.nextToken());

        // 닡개
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            char a = str.charAt(i);
            c[i] = a;
            if (c[i] >= 65) {
                c[i] -= 55;
            }else if (c[i]>=48){
                c[i] -=48;
            }
        }
        int result = 0;
        int sq = 1;
        for (int i = n-1; i >=0; i--) {
            result += c[i] * sq;
            sq *= b;
        }
        System.out.println(result);
    }
}