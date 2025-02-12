import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * n 일 동안 사용할 금액, m 번만 돈을 뺀다
     * k 원을 인출하여 하루 사용 불가능 - 잔액 집어넣고 다시 k 원 출금
     * 정확히 m 번을 맞추기 위해 남은 금액이 그 날 사용할 금액보다 많더라도 집어넣고 다시 인출 가능
     * 인출 금액 k 최소화.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] perDay = new int[N];

        int left = 0; // 최댓값, 가장 큰 1일 사용 가능 금액
        int right = 0; // 총합, 모든 금액을 한번만 출금하는 경우

        for (int i = 0; i < N; i++) {
            perDay[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, perDay[i]);
            right += perDay[i];
        }

        int result = right; // 최솟값, 최소 인출 금액.

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1; // M
            int sum = 0;

            for (int i = 0; i < N; i++) {
                // 초과시 출금 후 sum 초기화
                if (sum + perDay[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += perDay[i];
            }
            // 출금 횟수가 많으면 인출금액 증가
            if (count > M) {
                left = mid + 1;
            }
            // 출금횟수가 M 이하, k 금액 줄임,
            else {
                result = mid;
                right = mid -1;
            }


        }

        System.out.println(result);

    }
}











