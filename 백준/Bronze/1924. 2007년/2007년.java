import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 2007년 1월 1일 월요일
        // 2007년 x월 y일은 무슨 요일 일 까?
        // 첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다.
        // 1 1 -> MON

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        int [] Month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] Day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int result = y;
        for (int i = 0; i < x - 1; i++) {
            result += Month[i];
        }
        System.out.print(Day[result % 7]);
    }
}