import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    보석상자
    m 가지 다른 색상
    n 명의 학생들에게 / 받지 못하는 학생이 있어도 되지만 한 명은 한 색만
    질투심 - 보석 갯수 가장 많은 아이 보석 갯수
    질투심이 최소가 되게
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int highest = 0, lowest = 1, mid = 0, sum, ans = 0;


        int[] jemStone = new int[m];
        for (int i = 0; i < m; i++) {
            jemStone[i] = Integer.parseInt(br.readLine());
            highest = Math.max(highest, jemStone[i]);
        }

        // 질투심의 범위 ( 보석 갯수 ) 를 이진탐색으로 줄임
        // 공평하게 분배할 수 있는지

        while (lowest < highest) {
            mid = (lowest + highest) / 2;  // 질투심 중간치
            sum = 0;
            for (int i = 0; i < m; i++) {
                if (jemStone[i] % mid == 0) {
                    sum += jemStone[i] / mid;
                } else {
                    sum += jemStone[i] / mid + 1; // 올림
                }
            }
            if (sum > n) {  // 더 많은 보석을 학생에게 주어야 한다.
                lowest = mid + 1;
            } else {
                highest = mid;
            }

        }

        System.out.println(lowest);
    }
}
