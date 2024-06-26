import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int length[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        length[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    max = Math.max(length[j], max);
                }
            }
            length[i] = max + 1;
        }
        Arrays.sort(length);
        System.out.println(length[n-1]);



    }


}
