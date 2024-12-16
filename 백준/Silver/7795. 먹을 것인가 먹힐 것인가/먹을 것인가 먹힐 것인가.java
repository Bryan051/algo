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
            Integer[] arrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            Integer[] arrB = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA,Collections.reverseOrder());
            Arrays.sort(arrB,Collections.reverseOrder());

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < m; j++) {
                    if (arrA[i] > arrB[j]) {
                        // 내림차순으로 정렬했기때문에
                        // A가 B보다 더 큰 값을 발견하면 
                        // 그 다음 숫자들은 당연히 크다.
                        ans += (m - cnt);
                        break;
                    } else {
                        cnt++;
                    }
                }
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }


}

