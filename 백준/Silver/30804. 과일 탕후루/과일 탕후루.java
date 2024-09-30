import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] fruit = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        // 과일 종류 카운트
        
        HashMap<Integer, Integer> count = new HashMap<>();
        // 최대 연속 길이
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            count.put(fruit[right], count.getOrDefault(fruit[right], 0) + 1);

            while (count.size() > 2) {
                count.put(fruit[left], count.get(fruit[left]) - 1);

                if (count.get(fruit[left]) == 0) {
                    count.remove(fruit[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }

}
