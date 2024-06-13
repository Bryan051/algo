import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int n,k;
    static String[] card;
    static boolean[] visited;
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n 개 총 갯수중
        n = Integer.parseInt(br.readLine());
        // k 개 뽑아서 문자열 만들거임. 겹치면 1개로 카운트 hashset?
        k = Integer.parseInt(br.readLine());

        card = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n ; i++) {
            card[i] = br.readLine();
        }

        // 초기값 넣어줌 null, 0 ( 카운트 할 때와 동시에 초기값을 넣어줄것임)
        dfs(new String(),0);
        // hashset 은 value 중복이 안되기 때문에
        // level = k 값일 경우까지만 재귀했으므로 size 가 총 갯수.
        System.out.println(hs.size());
//        System.out.println(hs.toString());



    }

    private static void dfs(String s, int level) {
        if (level == k) { // 탈출조건, k 장 뽑으면 재귀 금지
//            System.out.println(s);
            hs.add(s);
            return;
        }
        // 재귀, card[] 배열의 총 n개 숫자 중 하나 뽑아서 시작
        for (int i = 0; i < n ; i++) {
            if (!visited[i]) {
                // 방문 체크
                visited[i] = true;
                // 문자열 추가, level ( 카드 내려논 횟수 ) 상승
                dfs(s + card[i], level + 1);
                // 전체 for문 생각했을 때 ex( i = 0 , n , i++) i = 0 에서
                // 재귀로 다시 들어갔을 때 해당 문자열 ex( card[0] = 11) 의 visited 카운트는
                // 전역변수로, true 값을 가지게 되기 때문에
                // 다음 재귀 i = 0 에서 쓰지 못하고 1부터 시작되게 된다. -> card[1]부터 시작.

                visited[i] = false;
                // 이후 dfs 재귀가 다 끝나면 처음 시작했던 for문의 카운트가 올라가야 하는데
                // 그 전에 해당 주석 바로 위 dfs (재귀가 끝난)이후 visited [i] 값을 false로 해 준다.
                // 모든 재귀가 백트래킹(맞는 표현인지 모르겠다.)으로 false-> false-> false-> false->...
                // 시작포문 i = 1. 모든 visited[i] = false;
                // 이제 어느정도 이해가가는듯.
            }
        }
    }

}