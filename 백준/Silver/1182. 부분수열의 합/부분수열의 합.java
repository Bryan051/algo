import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    n 개의 정수 수열
    크기가 양수인 부분수열 중 그 수열의 원소를 다 더한 값이 S 가 되는 경우의 수를 구하라
     */
    static int n, s, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(result);
    }

    static public void dfs(int sum, int index) {
        if (index >= n) return;
        if (sum + arr[index] == s) result++;
        // 더하는 경우
        dfs(sum + arr[index], index + 1);
        // 더하지 않는 경우
        dfs(sum, index + 1);
    }
}

