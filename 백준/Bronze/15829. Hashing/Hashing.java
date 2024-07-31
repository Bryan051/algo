import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        br.close();

        long res = 0;
        long pow = 1;
        for (int i = 0; i < L ; i++) {

            char ch = str.charAt(i);
            int value = (int) ch - 'a' + 1;

            res += value * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(res%1234567891);
    }

}