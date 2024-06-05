import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 막대기 배열
        int[] bars = new int[n];
        for (int i = 0; i < n ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            bars[i] = Integer.parseInt(st1.nextToken());
        }
        // 맨뒤 기준
        int highest = bars[n-1];
        // 일단 맨뒤 하나 카운트
        int count = 1;
        for (int i = n-2 ; i >=0 ; i--) {
            if (bars[i] > highest) {
                highest = bars[i];
                count++;
            }
        }
        System.out.println(count);
    }
}