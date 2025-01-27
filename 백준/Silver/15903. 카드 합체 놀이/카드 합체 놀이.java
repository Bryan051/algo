import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    덮어쓴다가 포인트, 덮어쓴 값이 다시 가장 작은 수가 되면 그걸 또 더해주면됨
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            pq.add(Long.valueOf(st.nextToken()));
        }

        // 가장 작은 수 poll 두번 하고 다시 두개 집어넣음됨
        for (int i = 0; i < m; i++) {
            long tmp = pq.poll();
            tmp += pq.poll();
            pq.add(tmp);
            pq.add(tmp);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }





}












