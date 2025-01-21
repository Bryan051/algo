import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
    연산자 끼워넣기

    음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다

    순서대로 연산해야되니 나눗셈, 빼기, 덧셈, 곱하기 순으로 가야됨


     */
    static int n;
    static int[] arr;
    static int[] operArr;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operArr = new int[4];
        for (int i = 0; i < 4; i++) {
            operArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int level, int sum) {
        if (level == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operArr[i] > 0) {
                operArr[i] -= 1;
                switch (i) {
                    case 0:
                        dfs(level + 1, sum + arr[level]);
                        break;
                    case 1:
                        dfs(level + 1, sum - arr[level]);
                        break;
                    case 2:
                        dfs(level + 1, sum * arr[level]);
                        break;
                    case 3:
                        dfs(level + 1, sum / arr[level]);
                        break;
                }
                operArr[i] += 1;
            }
        }
    }
}