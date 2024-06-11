import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.add(s);

            sb = new StringBuilder(s);
            String rs = sb.reverse().toString();
            if (set.contains(rs)) {
                System.out.println(s.length() + " " + s.charAt(s.length() / 2));
                break;
            }
        }

    }

}