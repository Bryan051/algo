import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n ; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        Arrays.sort(arr);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();

    }

}
