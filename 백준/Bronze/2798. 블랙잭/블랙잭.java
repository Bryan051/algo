import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n];

        st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int appr = 0; // 근사치

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = numArr[i] + numArr[j] + numArr[k];

                    if (sum == m) {
                        appr = sum;
                        break;
                    }
                    if (appr < sum && sum <= m) {
                        appr = sum;
                    }
                }
            }
        }

        System.out.println(appr);

    }

}