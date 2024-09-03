import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> wallet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String site = st1.nextToken();
            String pass = st1.nextToken();
            wallet.put(site, pass);
        }

        for (int i = 0; i < m; i++) {
            String a = br.readLine();
            String ans = wallet.get(a);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }


}