import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] count = new int[41][2];

        count[0][0] = 1;  // fibonacci(0)
        count[0][1] = 0;
        count[1][0] = 0;  // fibonacci(1)
        count[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            count[i][0] = count[i - 1][0] + count[i - 2][0];
            count[i][1] = count[i - 1][1] + count[i - 2][1];
        }
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(count[n][0] + " " + count[n][1]);
        }

    }

}
