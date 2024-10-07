import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n + 1 이 원하는 i의 갯수
        // I + < O I > 의 갯수. (2N +1)
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int count = 0;
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            if (arr[i - 1] == 'I' && arr[i]== 'O' && arr[i + 1] == 'I') {
                count++;
                if (count == n) {
                    count--;
                    ans++;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(ans);

    }

}