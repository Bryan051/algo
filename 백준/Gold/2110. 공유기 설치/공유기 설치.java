import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    /**
     * N개가 수직선 위에, 중복 x
     * c 개 설치하려함
     * 한 집에는 공유기를 하나만 설치
     * 가장인접한 두 공유기 사이의 거리가 가장 길게
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        /*  '거리' 를 탐색 범위로 잡고 이분탐색
        가능한 값 중 최대의 mid 찾기
        mid 를 유지하면서 left = mid + 1;
         */
        int result = 0;
        int left = 1;
        int right = houses[N - 1] - houses[0];

        while (left <= right) {
            // 첫번째 집 무조건 설치 가정
            int cnt = 1;
            int cur = houses[0];
            int mid = (left + right) / 2;
            // 두번째집부터
            for (int i = 1; i < N; i++) {
                if (houses[i] - cur >= mid) {
                    cnt++;
                    cur = houses[i];
                }
            }
            // 설치 가능한 공유기 개수 크거나 같으면 거리 늘림
            if (cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println(result);

    }



}











