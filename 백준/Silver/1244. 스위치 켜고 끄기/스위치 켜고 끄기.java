import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1~ ? 스위치 있음
        // 남자 = 받은 숫자의 배수 (3 이면 3,6 바꿈)
        // 여자 = 받은 숫자 중심 좌우대칭 -- 뻗어나감 -- 대칭인곳부터 n까지 다바꿈
        // n+1, n-1이 서로 다르면 n 숫자 만 바꾸고 뻗어나가지않음 ㄴ

        // 입력  1. 스위치 갯수
        //      2. 스위치들의 처음 상태 100 이하 양의 정수. 사이 빈칸있음
        //      3. 학생수 100이하 양정
        //      4. 성별과 받은 수 (마지막 줄 까지 라고 하는 거 보니 5줄 이상도 생각 해야돨듯
        //
        //      20개씩 출력, 각 숫자 다음 띄어쓰기 한칸

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  스위치 갯수
        int n = Integer.parseInt(br.readLine());

        //  스위치 배열
        int[] numArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        //  사람 명수
        int m = Integer.parseInt(br.readLine());

        // 사람 배열
        int[] gender = new int[m];
        int[] arr = new int[m];
        for (int i = 0; i < m ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            gender[i] = Integer.parseInt(st1.nextToken());
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        // 남자 = 받은 숫자의 배수 (3 이면 3,6 바꿈)
        // 여자 = 받은 숫자 중심 좌우대칭 -- 뻗어나감 -- 대칭인곳부터 n까지 다바꿈
        // n+1, n-1이 서로 다르면 n 숫자 만 바꾸고 뻗어나가지않음 ㄴ
        for (int i = 0; i < m ; i++) {
            // 남
            if(gender[i] == 1) {
                for (int j = 0; j < n ; j++) {
                    if((j+1)%arr[i] == 0)
                    numArr[j] = numArr[j] == 0 ? 1 : 0 ;
                }
            }
            //여
            else{
                numArr[arr[i]-1] = numArr[arr[i]-1] == 0 ? 1 : 0;
                for (int j = 0; j <n/2; j++) {
                    if(arr[i]-1+j >= n || arr[i] - 1 - j <0) break;
                    if(numArr[arr[i] - 1 - j ] == numArr[arr[i] - 1 + j]){
                        numArr[arr[i] - 1 - j ] = numArr[arr[i] - 1 - j ] == 0? 1:0;
                        numArr[arr[i] - 1 + j ] = numArr[arr[i] - 1 + j ] == 0?1:0;
                    }else break;
                }
            }
            
        }
        for (int i = 0; i < n ; i++) {
            System.out.print(numArr[i]+" ");
            if((i+1)%20 == 0)
                System.out.println();
        }
    }
}