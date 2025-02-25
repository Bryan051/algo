import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     * 투포인터
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        int check = Integer.MAX_VALUE;
        int ans1 = 0; // 작은쪽
        int ans2 = 0; // 큰쪽

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < check) {
                check = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }


        }

        System.out.println(ans1 + " " + ans2);

    }


}











