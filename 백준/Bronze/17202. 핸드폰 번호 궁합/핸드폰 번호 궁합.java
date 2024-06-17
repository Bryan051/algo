import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        Queue<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            arr.add(Character.getNumericValue(a.charAt(i)));
            arr.add(Character.getNumericValue(b.charAt(i)));
        }

        int cycle = 15;

        while (arr.size() != 2) {
            for (int i = 0; i < cycle; i++) {
                int x = arr.poll();
                int y = arr.peek();
                int z = (x + y) % 10;
                arr.add(z);
            }
            // 끝났을 때 마지막 번호는 peek 이라 queue에 남아있다.
            arr.poll();
            cycle--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr.poll());
        sb.append(arr.poll());
        String ans = sb.toString();
        System.out.println(ans);
    }

}
