import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine(); // ac 함수
            int n = Integer.parseInt(br.readLine()); // 배열안의 수 갯수
            String input = br.readLine();
            st = new StringTokenizer(input, "[],");
            Deque<Integer> deque = new ArrayDeque<>();
            if (!input.isEmpty()) {
                while (st.hasMoreTokens()) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }
            boolean reverse = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {// 에러
                        isError = true;
                        break;
                    }
                    if (reverse) {// 뒤집힌상태면 마지막숫자제거
                        deque.removeLast();
                    } else {// 아니면 첫번째 제거
                        deque.removeFirst();
                    }

                }
            }
            StringBuilder sb = new StringBuilder();
            if (isError) {
                sb.append("error");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) { // 마지막 반점 제거
                        sb.append(",");
                    }
                }
                sb.append("]");
            }
            System.out.println(sb);

        }


    }
}