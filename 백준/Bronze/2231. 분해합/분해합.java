

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

        /* 분해합 = N , 256
            생성자 = M, 245
            245 + 2 + 4 + 5 = 256
         */

        int M = 0;

        for (int i = 0; i < N; i++) {
            int number = i;
            int res = 0;

            while (number > 0){
                res += number % 10;
                number /= 10;
            }

            if (res + i == N) {
                M = i;
                break;
            }

        }

        System.out.println(M);





    }

}

