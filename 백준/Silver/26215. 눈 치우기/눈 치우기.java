import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 1분에 두 집 각각 1만큼
    2. 1분에 한집만 1만큼 눈 치울 수 있음
    3. 1440분 이상이면 -1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (queue.isEmpty()) {
                time += a;
                break;
            }
            int b = queue.poll();
            time += b;
            queue.add(a - b);
        }
        
        if (time > 1440) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }


    }

}

