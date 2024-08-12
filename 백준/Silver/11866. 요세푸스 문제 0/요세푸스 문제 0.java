import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < n+1 ; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 0;
        while (list.size() > 0) {
            count = (count + k - 1) % list.size();
            sb.append(list.remove(count));
            if (list.size() > 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());

    }

}
