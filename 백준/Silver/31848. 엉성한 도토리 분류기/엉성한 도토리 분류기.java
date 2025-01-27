import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 예제입력 부분에서
     * 5 6 1 4 9 2 8 10 3 7
     * --------------------------
     * 구멍값에 가중치 1을 미리 더한다
     * 5 7 3 7 13 7 14 17 11 16
     * --------------------------
     * 현재 구멍보다 이전 구멍의 값이 더 크면 도토리는 어차피 이전 구멍에 들어가게 되므로
     * 현재 구멍의 값을 이전 구멍의 값으로 바꿔주는 작업을 반복해준다
     * 5 7 7 7 13 13 14 17 17 17
     * ---------------------------------------
     * -> 오름차순으로 정렬되어 이분탐색이 사용 가능해진다
     * -> 현재 값이 어떤 인덱스를 가리키고 있는지 알려주는 작업이 필요해 보인다 -> map
     */

    static int[] holes;
    static int[] acorns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 구멍 갯수
        int n = Integer.parseInt(br.readLine());

        holes = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            holes[i] = Integer.parseInt(st.nextToken());
        }

        // 도토리 갯수
        int q = Integer.parseInt(br.readLine());
        acorns = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            acorns[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 가중치 더하기
        for (int i = 0; i < n; i++) {
            holes[i] += i; 
            if (!map.containsKey(holes[i])) { // 구멍 있으면 어차피 거기에 들어감. 생략
                map.put(holes[i], i + 1); // 구멍 순서 저장
            }
        }
        // 직전 구멍이 지금보다 크거나 같다면 바꾸기
        for (int i = 1; i < n; i++) {
            if (holes[i - 1] >= holes[i]) {
                holes[i] = holes[i - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            int idx = binarySearch(0, n - 1, acorns[i]); // 인덱스 찾기
            int key = holes[idx]; // 값 - 인덱스 map 에서 정확한 인덱스 찾기
            sb.append(map.get(key)).append(" ");
        }
        
        System.out.println(sb);
    }

    static int binarySearch(int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (holes[mid] >= target) { // 현재 구멍의 크기가 도토리보다 크거나 같을 경우
                end = mid; // 더 작은 구멍을 탐색
            } else {
                start = mid + 1; // 더 큰 구멍을 탐색
            }
        }
        return end;
    }

}