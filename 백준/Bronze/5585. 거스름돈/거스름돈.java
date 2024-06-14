import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] coin = {500, 100, 50, 10, 5, 1};

        int change = 1000 - n;
        int cnt = 0;
        if (change > 0) {
            for (int i = 0; i < 6 ; i++) {
                cnt += change / coin[i];
                change = change % coin[i];
            }
        }
        System.out.println(cnt);
    }

}