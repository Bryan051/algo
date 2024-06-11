import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Long> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t ; i++) {
            int k = Integer.parseInt(br.readLine());

            pq.clear();// 해 줘야 다음 회차때 전에 값에 추가안됨. 이상한값들어감
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k ; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                sum += a + b;
                pq.offer(a+b);
            }
            System.out.println(sum);
        }
    }

}