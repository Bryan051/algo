import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    노래 여러조각, 정해진 순서대로 다운
    각 조각의 길이와 다운로드 길이 안다.
    모두 다운받기 전에 들으려고 한다
    다운로드 시작 후 몇초 후 부터 끊김없이 노래를 들을 수 있는지
    
    다 더해서 가장 긴 경우에서 하나씩 줄여 나가봄
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) + map[i-1][0];
            int v = Integer.parseInt(st.nextToken()) + map[i-1][1];
            map[i][0] = d; // 노래 길이
            map[i][1] = v; // 다운 속도
        }
        
        int idx = n;
        int ans = 0;
        while (idx > 0) {
            ans = Math.max(ans, map[idx][1] - map[idx - 1][0]);
            idx--;
        }
        System.out.println(ans);
    }
}


