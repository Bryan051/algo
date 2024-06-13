import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long figure = 1;
        for (int i = n; i > n - 5; i--) {
            figure *= i;
        }

        long star = 1;
        for (int i = 5; i >0 ; i--) {
            star *= i;
        }

        long ans = figure / star;

        System.out.println(ans);

    }

}