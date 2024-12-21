import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. c 명의 후보, v 명의 유권자= 홀수.
    2. 투표는 2회. 과반 이상 획득한 후보가 없다면 가장 많은 표를 받은 두명만 2회차 재투표.
    3. 1회차에서 2등과 3등 득표수 항상 다르다 가정.\
    4. 선호도는 1,2회차 동일. 기권 x
    첫 줄에 테스트케이스 t
    각 케이스 첫줄에 후보수 c 와 유권자수 v
    v 줄에 걸쳐 c 개의 정수로 각 유권자 선호도표가 주어짐.
    가장선호 -> 덜 선호 순으로 선호도표 주어짐, 중복정수 x 1~c 까지의 정수 1개씩.
    당선번호' '종료회차
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int[][] favor = new int[v][c];
            for (int i = 0; i < v; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    favor[i][j] = Integer.parseInt(st.nextToken());   
                }
            }

            // 1차 투표
            int[] votes = new int[c + 1];
            for (int i = 0; i < v; i++) {
                votes[favor[i][0]]++;
            }
            // 1차 투표 결과 확인
            int first = 0, second = 0;
            for (int i = 1; i <= c; i++) {
                if (votes[i] > votes[first]) {
                    second = first;
                    first = i;
                } else if (votes[i] > votes[second]) {
                    second = i;
                }
            }

            int totalVotes = Arrays.stream(votes).sum();
            if (votes[first] > totalVotes / 2) {
                // 과반 득표자가 있는 경우
                sb.append(first).append(" 1\n");
            } else {
                // 2차 투표
                Arrays.fill(votes, 0); // 투표 수 초기화
                for (int i = 0; i < v; i++) {
                    // 가장 선호하는 두 후보 중 하나에 투표
                    for (int j = 0; j < c; j++) {
                        if (favor[i][j] == first || favor[i][j] == second) {
                            votes[favor[i][j]]++;
                            break;
                        }
                    }
                }
                // 2차 투표 결과 확인
                if (votes[first] > votes[second]) {
                    sb.append(first).append(" 2\n");
                } else {
                    sb.append(second).append(" 2\n");
                }
            }
        }
        System.out.println(sb);
    }

}












