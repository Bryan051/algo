import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,k;
    static int[] visited = new int[1000001];
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //  걷기 = x-1 or x+1 / 순간이동 2x
        st = new StringTokenizer(br.readLine());
        // 시작
        n = Integer.parseInt(st.nextToken());
        // 도착
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n));

    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int n = q.poll();
            int a = n - 1;
            int b = n + 1;
            int c = n * 2;
            if (n == k) {
                // 시작값이 1이었으므로
                return visited[n]-1;
            }
            if (a>=0 && visited[a] == 0 ) {
                cnt++;
                visited[a] = visited[n]+1;
                q.add(a);
            }
            if (b <= 100000 && visited[b] == 0) {
                cnt++;
                visited[b] = visited[n]+1;
                q.add(b);
            }
            if (c <= 100000 && visited[c] == 0) {
                cnt++;
                visited[c] = visited[n]+1;
                q.add(c);
            }
        }
        return -1;
    }
}