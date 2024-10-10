import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 거쳐가는 점 k
        for (int k = 0; k < n; k++) {
            // 출발점 i
            for (int i = 0; i < n; i++) {
                // 도착점 j
                for (int j = 0; j < n; j++) {
                    // 가중치 없는 방향 그래프이기 때문에 그냥 1인지만 확인함
                    // 가중치가 있으면 arr[i][k] + arr[k][j] < arr[i][j] ( 최소의경우 )
                    // 인지 비교하고 값을 넣어줌
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}