import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // x축 기준 분모가 짝수 = 좌 -> 우상
        // 분모가 홀수 = 우 -> 좌하
        // 배열은 (대각선) = 1,2,3,4,5,6,7 순으로 늘어남
        // a= n(n+1)/2
        // x가 n을 i 로 돌리면서 찾는다 how?
        // x가 a 보다 같거나 작으면 n 열의 분수.
        // n 홀 - 분자 = n - x - 누적합 -1  , 분모  = x - 누적합
        // n 짝 - 분자 = x - 누적합 , 분모 = n - x - 누적합 -1
        // X 최대 10000000 = n(n+1)/2 = 4467.~

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        // n = 대각선
        int n = 1;
        // s = 누적합
        int s = 0;

        while (true) {
            if (X <= s + n) {
                if (n % 2 == 1) {
                    System.out.println((n-(X-s-1)) + "/" + (X-s));
                    break;
                }else{
                    System.out.println((X-s) + "/" + (n-(X-s-1)));
                    break;
                }
            }else { // X 번째 분수가 해당 대각선에 포함되지 않는 경우
                s += n;
                n++;
            }
        }
    }
}