import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            } else {
                pq.add(now);
            }
        }

        System.out.println(sb.toString().trim());

    }

}