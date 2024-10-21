import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    D, S, L, R
    래자스터 0 아성 10,000 미만 십진수
    네자리, d1,d2,d3,d4 = n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4
    D = n * 2  if D > 9999 = D % 10000 ;
    S = n - 1 ;
    L = d2, d3, d4, d1 ;
    R = d4, d1, d2, d3 ;

    처음에 그냥 숫자 하나 하나 비교하는거는 아예 틀린접근이었음
    dslr 4가지 방식을 사용 해야 되기 때문에 4 가지를 bfs 로 상하좌우 하듯 돌려서
    command 경우의 수를 다 배열 해 놓고 도착지의 경우의 수를 출력했음
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            queue.add(A);
            visited[A] = true;
            Arrays.fill(command, "");

            while (!queue.isEmpty() && !visited[B]) {
                int cur = queue.poll();

                int D = (2 * cur) % 10000;
                int S = cur == 0 ? 9999 : cur - 1;
                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur % 10) * 1000 + cur / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    command[D] = command[cur] + "D";
                }
                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    command[S] = command[cur] + "S";
                }
                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    command[L] = command[cur] + "L";
                }
                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    command[R] = command[cur] + "R";
                }
            }
            System.out.println(command[B]);

        }

    }


}