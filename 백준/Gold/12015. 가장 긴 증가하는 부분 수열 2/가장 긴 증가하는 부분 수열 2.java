import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    /**
     가장긴증가하는부분수열 LIS
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] LIS = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 0; i < N; i++) {
            int key = arr[i];

            // 만약 key 가 LIS 의 마지막 값보다 클 경우 추가하고 넘김
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }
            // key 가 LIS 의 마지막 값보다 작은 경우 대치
            // ( 경우의 수 늘리기, 경우의 수가 같거나 늘어날 수 밖에 없다.)
            // 따라서 가장 긴 최장수열과 길이만 같은 수열일 수 있고
            // 가장 긴 최장수열 자체는 아닐 수 도 있다.
            else {
                // Lower Bound 이분탐색
                // 키 ( 현재 탐색중인 )값 보다 큰 가장 가까운 값을 찾기위함
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if(LIS[mid] < key) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid;
                    }

                }
                /*
                 *  lo가 LIS 에서 대치 될 원소의 위치가 됨
                 *  해당 위치의 key 값으로 원소를 바꿔줌
                 */

                LIS[lo] = key;

            }

        }
        System.out.println(lengthOfLIS);
    }
}
