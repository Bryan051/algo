import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);


    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < depth; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }

        int previousNumber = 0;
        for (int i = 0; i < N; i++) {
            if (previousNumber != arr[i] && !visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                previousNumber = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
        
    }


}