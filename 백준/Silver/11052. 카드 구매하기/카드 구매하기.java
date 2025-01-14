import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    n개 카드, 8등급의 팩.
    장당 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것.
    최대한 비싸게 사서 n 개 카드 구할것.
    i 개가 포함된 카드팩 가격은 pi 원이다.

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] cardpack = new int[n + 1];
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cardpack[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cardpack[j]);
            }
        }

        System.out.println(dp[n]);

    }

}



