import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    n 개의 컴퓨터.
    마스터 컴퓨터 찾아서 해킹하고싶음
    컴퓨터는 신뢰관계가 주어짐, 한번에 가장 많은 컴퓨터를 해킹할 수 있는 컴 번호 구하라.
     */

    static int n, m;
    static List<Integer>[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new List[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        // 모든 노드에 대해 BFS 수행
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        // 최대 해킹 가능한 노드 개수 확인
        int biggest = 0;
        for (int i = 1; i <= n; i++) {
            biggest = Math.max(biggest, result[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == biggest) {
                System.out.print(i + " ");
            }
        }

    }
    public static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i : arr[num]) {
                if (!visited[i]) {
                    result[i]++;
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
    }

}












