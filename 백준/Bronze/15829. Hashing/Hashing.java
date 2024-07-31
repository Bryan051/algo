import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        br.close();

        int arr;
        double res = 0;
        for (int i = 0; i < N ; i++) {

            char ch = str.charAt(i);
            int value = (int) ch - 'a' + 1;
            res += value * Math.pow(31, i);
        }

        System.out.println((long)res);

    }

}