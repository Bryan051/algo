import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    맨 왼쪽은 무조건 깨야됨
    다음 숫자 안겹치면 카운트 안해도됨
    깨야될 때 (겹치면) 카운트
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        boolean[] isBroken = new boolean[1000001];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean check = true;

            for (int j = 0; j < 3 ; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;

                if (isBroken[val]) { // 지금 숫자가 직전 화분 깨진 숫자랑 겹치면 false
                    check = false;
                } else {
                    isBroken[val] = true; // 깨진화분에 적힌 숫자인것을 적어놓음
                }
            }
            if (check) {
                ans++;
            }
        }

        System.out.println(ans);



    }
}












