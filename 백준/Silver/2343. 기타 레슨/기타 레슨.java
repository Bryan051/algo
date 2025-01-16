import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    n 개의 기타강의, 강의의 순서가 바뀌면 안됨.
    i 와 j 를 같은 블루레이에 하려면 그 사의 모든 강의도 같은 블루레이에 녹화해야함.
     % 왼~오 순서를 건너 뛸 수는 없다.
    블루레이의 갯수를 가급적 줄이려고함
    m 개의 블루레이에 모든 기타 강의를 녹화.
    이때 블루레이의 크기 ( 녹화 가능한 길이 ) 를 최소로. 단, 모두 같은 크기.

    각 강의의 길이가 분 단위로 주어짐. 이때 가능한 블루레이의 크기 중 최소를 구하는 프로그램.

    ex ) 강의는 총 9개이고, 블루레이는 총 3개
    1번 블루레이에 1, 2, 3, 4, 5, 2번 블루레이에 6, 7, 3번 블루레이에 8, 9 를 넣으면 각 블루레이의 크기는 15, 13, 17이 된다.
    블루레이의 크기는 모두 같아야 하기 때문에, 블루레이의 크기는 17이 된다.
    17보다 더 작은 크기를 가지는 블루레이를 만들 수 없다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0, sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); // 가장 긴 강의 길이
            sum += arr[i]; // 모든 강의 길이의 합
        }

        // 이분 탐색 초기 범위 설정
        int left = max; // 블루레이 크기의 최소값, 가장 큰 강의보다 작을 수 없음
        int right = sum; // 블루레이 크기의 최대값

        while(left <= right) {
            int middle = (left + right) / 2;    // 현재 임시 블루레이 크기 후보

            int count = 1, tempSum = 0;
            for(int i=0; i< n; i++) {
                if(tempSum + arr[i] > middle) {
                    count++;    // 블루레이 한장 더 필요
                    tempSum =0;
                }
                tempSum += arr[i];
            }

            // 블루레이 개수가 M 이하, 더 작은 크기를 탐색
            if (count <= m) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(left);
    }
}



