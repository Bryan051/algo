import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    1. n 개의 작은 박스를 l * w * h 직육면체 박스 안에 모두 넣으려고한다.
    2. 작은박스는 정육면체. 가장 큰 작은박스를 구하라
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int shortestSide = Math.min(l, Math.min(w, h));

        double start = 0;
        double end = shortestSide;

        for (int i = 0; i < 10000; i++) {
            double mid = (start + end) / 2;

            if ((long) (w / mid) * (long) (l / mid) * (long) (h / mid) >= n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);


    }

}












