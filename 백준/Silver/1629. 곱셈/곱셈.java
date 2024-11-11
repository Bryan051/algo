import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         a * b % c 구하라.
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong((st.nextToken()));
        long B = Long.parseLong((st.nextToken()));
        long C = Long.parseLong((st.nextToken()));

        System.out.println(pow(A,B,C));


    }

    public static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long temp = pow(A, B / 2, C);

        if (B % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }


}