import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람수
        int n = Integer.parseInt(br.readLine());

        // 2런 중 max, 5트 중 max
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st1.nextToken());
            int r2 = Integer.parseInt(st1.nextToken());
            int maxRun = Math.max(r1,r2);

            int[] trick = new int[5];
            for (int j = 0; j < 5 ; j++) {
                trick[j] = Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(trick);
            int maxTrick = (trick[4] + trick[3]);

            ans[i] = maxRun + maxTrick;

        }
        Arrays.sort(ans);
        int z = ans.length-1;
        System.out.println(ans[z]);
    }
}