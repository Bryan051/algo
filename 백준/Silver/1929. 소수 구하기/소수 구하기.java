
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        prime = new boolean[n + 1];
        isPrime();

        for (int i = m; i <= n ; i++) {
            if (!prime[i]) System.out.println(i);
        }

    }

    public static void isPrime(){
        // true = 소수 아님
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length) ; i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

    }


}

