import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        br.close();

        /*

        1,7,19,37,61~
        += 6 * i

         */
        int res  = 1;
        int sector = 1;
        for (int i = 0; i < N; i++) {
            sector += 6 * i;
            res = i + 1;
            if (sector >= N) break;
        }
        System.out.println(res);


    }

}
