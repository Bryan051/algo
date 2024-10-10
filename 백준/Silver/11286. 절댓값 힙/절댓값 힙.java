import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> absPQ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        absPQ = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        
        
        for (int i = 0; i < n; i++) {
            // if --  x != 0 , arr[i] = x
            // if -- x == 0 , 절댓값이 가장 작은 값을 출력하고 그 값을 제거.
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (absPQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absPQ.poll());
                }
            } else {
                absPQ.add(x);
            }

        }
        


    }

}