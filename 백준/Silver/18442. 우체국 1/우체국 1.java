import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    /**
     *
     */
    public static int V, P;
    public static long L;
    public static long[] villages;
    public static long minDistanceSum = Long.MAX_VALUE;
    public static long[] postOffices;
    public static long[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 입력 받기
        V = Integer.parseInt(st.nextToken()); // 마을 개수
        P = Integer.parseInt(st.nextToken()); // 우체국 개수
        L = Long.parseLong(st.nextToken()); // 원형 도로의 길이

        villages = new long[V];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            villages[i] = Long.parseLong((st.nextToken()));
        }

        postOffices = new long[P];
        result = new long[P];

        combination(0,0);

        System.out.println(minDistanceSum);

        // 우체국 위치 오름차순
        Arrays.sort(result);
        for (long location : result) {
            System.out.print(location + " ");
        }
    }
    // 백트래킹
    static void combination(int start, int depth) {
        if (depth == P) {
            calcTotalDistance();
            return;
        }
        for (int i = start; i < V ; i++) {
            postOffices[depth] = villages[i]; // 우체국을 현재 마을에 배치
            combination(i + 1, depth + 1); // 다음 마을 탐색 (조합)
        }
    }

    static void calcTotalDistance() {
        long totalDistance = 0;

        for (long village : villages) {
            long minDistance = Long.MAX_VALUE;
            for (long postOffice : postOffices) {
                long directDistance = Math.abs(village - postOffice);
                long circularDistance = L - directDistance;
                minDistance = Math.min(minDistance, Math.min(directDistance, circularDistance));
            }
            totalDistance += minDistance;
        }
        // 최소 거리 합을 갱신하며 최적의 우체국 배치 저장
        if (totalDistance < minDistanceSum) {
            minDistanceSum = totalDistance;
            for (int i = 0; i < P; i++) {
                result[i] = postOffices[i];
            }
        }
    }

}











