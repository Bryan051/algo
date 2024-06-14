import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) { // 하나잡고시작
            int cnt = 0;
            int h = arr[i];
            for (int j = i+1; j < n; j++) {
                if (h < arr[j]) break;
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);

    }

}