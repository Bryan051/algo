import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = s.length() / 10;
        if (s.length() % 10 > 0) {
            count++;
        }

        for (int i = 0; i < count; i++) {
            int a = i * 10;
            int b = 10 * (i + 1);
            if (i >= s.length()/10) {
                System.out.println(s.substring(a));
                break;
            }
            System.out.println(s.substring(a,b));
        }
    }
}