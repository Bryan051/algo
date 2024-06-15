import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] APT = new int[15][15];
        for (int i = 0; i < 15 ; i++) {
            APT[0][i] = i;
            APT[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15 ; j++) {
                APT[i][j] = APT[i][j-1] + APT[i-1][j];
            }
        }


        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t ; i++) {
            // k 줄 n 번째
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(APT[k][n]);
        }

    }


}