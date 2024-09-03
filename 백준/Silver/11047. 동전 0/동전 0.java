
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = getCount(n, k, arr);

        System.out.println(ans);

    }

    private static int getCount(int n, int k, int[] arr) {
        int count = 0;

        for (int i = n - 1; i >=0 ; i--) {
            if (k >= arr[i]) {
                count += k / arr[i];
                k %= arr[i];
            }
            if (k == 0) break;
        }
        return count;
    }


}
