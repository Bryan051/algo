import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 수업시간
            int d = Integer.parseInt(br.readLine());

            // l 지각
            // l + l * l <= d
            int l = 0;
            // d 가 될 순 없음
            for (int j = 0; j < d ; j++) {
                if (j + j * j <= d) {
                    l = j;
                }else{
                    break;
                }
            }
            System.out.println(l);
            
        }

    }

}