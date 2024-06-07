import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int min = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>(); // 원래 그냥 배열썼다가 마지막에 i+1 값 추가해주려고 썼음
        for (int i = 0; i < n ; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a); // 정렬하고
        int z = a.get(n - 1) + 1;   // 마지막인덱스+1에 전+1값 넣어줌
        a.add(n,z);

//        int ans = 0;
        for (int i = 0; i < n ; i++) {
            if (a.get(0) > 1) { // 첫번째가 1이 아니면 무조건 1
                System.out.println(1);
                break;
            }
            else if (a.get(i + 1) - a.get(i) > 1) { // 배열이 1씩 커지면 상관 x, 1 이상 벌어지면 직전+1 최소
                // ans = a[i] + 1;                    // 마지막일때 i+1이라 인덱스 에러 백준 ㅋㅋ -> add 로 해결
                System.out.println(a.get(i) + 1);
                break;
            }
            else if (i == n-1) { // 배열이 1씩 커지면서 마지막에 도달했을 때
                System.out.println(z);
            }
        }
    }
}