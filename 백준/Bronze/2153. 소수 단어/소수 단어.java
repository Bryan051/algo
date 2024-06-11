import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int l = s.length();
        int sum = 0;
        boolean isPrime = false;

        for (int i = 0; i < l ; i++) {
            int tmp = s.charAt(i);
            // 대문자
            if (tmp >= 65 && tmp < 91) {
                sum += tmp - 64 + 26;
            } else {    //소문자
                sum += tmp - 96;
            }
        }
        for (int i = 2; i < sum ; i++) {
            if (sum % i == 0) {
                isPrime = true;
            }
        }

        if (isPrime) {
            System.out.println("It is not a prime word.");
        } else {
            System.out.println("It is a prime word.");
        }


    }

}