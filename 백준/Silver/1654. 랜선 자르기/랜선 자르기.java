import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이미 들고있는 랜선 갯수, 길이 제각각
        int k = Integer.parseInt(st.nextToken());
        // 만들어야하는 갯수
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        Arrays.sort(arr);

        // 이진탐색 초기설정.
        long left = 1;
        // 주어진 랜선의 최대 길이
        long right = arr[k-1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 길이로 자른 랜선의 수를 세는 변수
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            // 자른 랜선의 수가 n 보다 크거나 같으면 더 긴 길이도 가능한지 확인
            if (count >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }


}

