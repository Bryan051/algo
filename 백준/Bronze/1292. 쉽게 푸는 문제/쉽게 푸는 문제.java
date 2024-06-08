import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        // b 보다 작을 수 없으니 넉넉히 만들어줌
        // 런타임에러??? index OoB?
        // b 가 1000이면 너무많나?
        // count 로 1000까지
        int count = 0;
        for (int i = 1; i < b + 1; i++) {
            for (int j = 1; j <= i; j++) {
                count++;
                arr.add(i);
            }
            if (count > 1000) break;
        }

        int sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += arr.get(i);
        }
        System.out.println(sum);
    }
}