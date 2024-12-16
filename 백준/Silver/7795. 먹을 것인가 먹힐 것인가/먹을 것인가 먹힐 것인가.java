import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. a 는 b를 먹는다. 단, a는 자기보다 작은 먹이만.
        a>b 쌍 갯수 구하라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            // a, b 갯수
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arrA = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] arrB = new int[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            // groupB는 이분탐색의 범위이므로 정렬이 필수이다.
            // 처음알았다..
            Arrays.sort(arrB);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int low = 0;
                int high = m - 1;
                int cnt = 0;

                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arrB[mid] < arrA[i]) {
                        low = mid + 1;
                        // 정렬이 되었기때문에 mid 갯수만큼 카운트.
                        // 인덱스 0 부터 시작이라 + 1
                        cnt = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                ans += cnt;
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}

