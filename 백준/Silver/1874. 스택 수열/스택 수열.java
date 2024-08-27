import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        // 1~n 까지 오름차순 정렬. 해당 수열 만들기.
        int n = Integer.parseInt(br.readLine());

        int start = 0;
        // n 번 반복
        while (n --> 0) {

            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int i = start + 1; i <= value ; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            }
            // 맨 위의 원소가 입력 받은 줄과 값이 다르면
            // 오름차순 정렬로 된 배열에서 해당 열을 만들 수 없다.
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");

        }
        System.out.println(sb);


    }


}

