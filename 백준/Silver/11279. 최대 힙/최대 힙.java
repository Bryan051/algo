import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> num = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            num.add(x);

            if (num.isEmpty() && x == 0) {
                System.out.println(0);
            } else if (!num.isEmpty() && x == 0){
                int biggest = num.poll();
                System.out.println(biggest);
            }
        }

    }


}
