import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. n 개의 도시
    2. 도로들은 서로 길이가 다를 수 있다.
    3. 기름통은 무제한, 1km 마다 1 리터.
    4. 도시마다 주유소 1개, 리터당 가격 다름.
    5. 도시 갯수 n, 도로 길이 n-1 개, 리터당 가격 N개로 3줄.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] road = new int[n];
        int[] gas = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;
        long minPrice = gas[0]; // 첫 도시의 기름값을 초기 최솟값으로 설정.

        for (int i = 0; i < n - 1; i++) {
            if (gas[i] < minPrice) {
                minPrice = gas[i];
            }
            totalCost += minPrice * road[i];
        }
        System.out.println(totalCost);
    }



}












