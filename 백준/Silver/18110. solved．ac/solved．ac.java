import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int bound = Math.round((float) n / 100 * 15);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }
        Arrays.sort(arr);

        int tmp = 0;
        for (int i = bound ; i < n - bound; i++) {
            tmp += arr[i];
        }

        int round = n - bound * 2;
        int ans = Math.round((float) tmp / round);

        System.out.println(ans);
    }
}
