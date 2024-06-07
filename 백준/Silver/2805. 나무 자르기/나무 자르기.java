import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나무의 갯수
        int n = Integer.parseInt(st.nextToken());
        // 자르고 남은거 더한 나무의 길이, 딱 맞추길 원함
        int m = Integer.parseInt(st.nextToken());
        // 나무길이 - h +=a -> m 이 되게 하는 h 를 구하라
        // 높은거부터 저장 - > i - [i+1] 더하면될듯

        // 갯수만큼 받아서 자르기
        int[] a = new int[n]; // 인덱스 에러 안나게하려고 한칸더.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            //  i 번째 나무 길이
            a[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(a);

        int left = 0;
        int right = a[n-1];

        while (left < right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int len : a) {
                // 음수 포함 x
                if(len - mid>0) sum += len - mid;
            }

            // upper bound
            if (sum >= m) left = mid +1;
            else right = mid;
        }

        System.out.println(left - 1);

    }
}