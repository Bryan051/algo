import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // f (n) = f(n-2) + f(n-3)
        wave();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            System.out.println(arr[p]);
        }

    }

    static void wave() {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <=100 ; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
    }

}
