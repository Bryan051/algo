import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    N M
    N - 1부터 N 까지
    M - 중복없이 M 개

    nCm 출력
     */


    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // 1부터 시작이다. at : 1
        dfs(1, 0);
        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            for (int ans : arr) {
                sb.append(ans).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }


}