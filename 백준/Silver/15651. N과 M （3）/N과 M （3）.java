import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 1부터 ~ n 중 m 개 nCm
    2. 같은 수 여러번 ok
     */


    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        arr = new int[m];

        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth){
        // 탈출조건
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[depth] = i; // depth 에 방문한 노드 저장
            dfs(n, m, depth + 1);
        }

    }
}

