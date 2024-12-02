import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        visited = new boolean[n+1];
        visited[1] = true;
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dfs(1,0);
        int count = 0;
        for (int i = 2; i < visited.length ; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count);
    }

    static void dfs(int start, int cnt) {
        if (cnt == 2) { // 친구의 친구까지만. 친구 친구 친구는 안됨
            return;
        }
        for (int i : graph.get(start)) {
            visited[i] = true;
            dfs(i,cnt + 1);
        }   
    }
}