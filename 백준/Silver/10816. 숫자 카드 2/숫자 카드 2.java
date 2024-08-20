import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            cardCount.put(a, cardCount.getOrDefault(a, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {

            int a = Integer.parseInt(st1.nextToken());
            int result = cardCount.getOrDefault(a, 0);
            bw.write(result +" ");
        }

        bw.flush();
        bw.close();

    }
}
