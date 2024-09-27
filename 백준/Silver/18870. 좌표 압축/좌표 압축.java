import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] newArr = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = newArr[i] = a;
        }

        Arrays.sort(newArr);

        int rank = 0;

        for (int val : newArr) {
            if (!rankMap.containsKey(val)) {
                rankMap.put(val, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(rankMap.get(val)).append(" ");
        }
        System.out.println(sb);
    }

}
