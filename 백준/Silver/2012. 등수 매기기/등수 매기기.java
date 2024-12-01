import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected);
        
        // 불만도의 합
        long dissatisfaction = 0;
        for (int i = 0; i < n; i++) {
            dissatisfaction += Math.abs(expected[i] - (i + 1));
        }

        System.out.println(dissatisfaction);
    }
}

